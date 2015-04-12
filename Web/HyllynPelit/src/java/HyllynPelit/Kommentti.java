package HyllynPelit;

import HyllynPelit.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;

/**
 *
 * @author Aki
 */
public class Kommentti {

    private String nimi;
    private String kommentti;
    private String tunnus;
    private Map<String, String> virheet = new HashMap<String, String>();

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {
        this.nimi = nimi;
    }

    public String getKommentti() {
        return kommentti;
    }

    public void setKommentti(String kommentti) {
        this.kommentti = kommentti;
        if (kommentti.trim().length() == 0) {
            virheet.put("kommentti", "kommenttipalkki on tyhjä!");
        } else if (kommentti.length() > 500) {
            virheet.put("kommenti", "kommentti on liian pitkä (max 500 merkkiä)");
        }
    }

    public static List<Kommentti> getKommentit() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Kommentti, tunnus from Kommentti";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Kommentti> kommentti = new ArrayList<Kommentti>();
        while (rs.next()) {
            Kommentti k = new Kommentti();
            k.setNimi(rs.getString("PelinNimi"));
            k.setKommentti(rs.getString("Kommentti"));
            k.setTunnus(rs.getString("tunnus"));
            kommentti.add(k);

        }
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }

        return kommentti;

    }

    public static List<Kommentti> getKommentitNimella(String nimi) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Kommentti, tunnus from Kommentti WHERE PelinNimi= ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, nimi);

        ResultSet rs = kysely.executeQuery();
        ArrayList<Kommentti> kommentti = new ArrayList<Kommentti>();
        while (rs.next()) {
            Kommentti k = new Kommentti();
            k.setNimi(rs.getString("PelinNimi"));
            k.setKommentti(rs.getString("Kommentti"));
            k.setTunnus(rs.getString("tunnus"));
            kommentti.add(k);

        }
        try {
            rs.close();
        } catch (Exception e) {
        }
        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }

        return kommentti;

    }

    public void lisaaKommenttiKantaan(String kayttis) throws NamingException, SQLException {

        String sql = "INSERT INTO Kommentti (PelinNimi, kommentti, tunnus) VALUES (?, ?, ?)";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getNimi());
        kysely.setString(2, this.getKommentti());
        kysely.setString(3, kayttis);

        kysely.execute();

        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }
    }

    public boolean onkoKelvollinen() {
        return virheet.isEmpty();
    }

    public Collection<String> getVirheet() {

        return virheet.values();
    }

    public static void PoistaKommentti(String tunnus) throws NamingException, SQLException {

        String sql = "DELETE FROM Kommentti WHERE PelinNimi = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);

        kysely.execute();

        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }

    }
}
