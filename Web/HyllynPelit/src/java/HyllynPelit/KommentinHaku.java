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
public class KommentinHaku {

    private String nimi;
    private String kommentti;
    private String tunnus;
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setVirheet(Map<String, String> virheet) {
        this.virheet = virheet;
    }
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

    public static List<KommentinHaku> getKommentit() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Kommentti, tunnus, id from Kommentti";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<KommentinHaku> kommentti = new ArrayList<KommentinHaku>();
        while (rs.next()) {
            KommentinHaku k = new KommentinHaku();
            k.setNimi(rs.getString("PelinNimi"));
            k.setKommentti(rs.getString("Kommentti"));
            k.setTunnus(rs.getString("tunnus"));
            k.setId(rs.getString("id"));
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

    public static List<KommentinHaku> getKommentitSivulla(String pelinNimi, int sivu, int yksikommentti) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        int montako = 1;
        int sivut = 1;

        String sql = "SELECT * FROM Kommentti WHERE PelinNimi = ? ORDER by PelinNimi LIMIT ? OFFSET ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);

        kysely.setString(1, pelinNimi);
        kysely.setInt(2, montako);
        kysely.setInt(3, (sivu - 1) * montako);

        ResultSet rs = kysely.executeQuery();
        ArrayList<KommentinHaku> kommentti = new ArrayList<KommentinHaku>();
        while (rs.next()) {
            KommentinHaku k = new KommentinHaku();
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

    public static List<KommentinHaku> getKommentitNimella(String nimi) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Kommentti, tunnus from Kommentti WHERE PelinNimi= ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, nimi);

        ResultSet rs = kysely.executeQuery();
        ArrayList<KommentinHaku> kommentti = new ArrayList<KommentinHaku>();
        while (rs.next()) {
            KommentinHaku k = new KommentinHaku();
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

    public static KommentinHaku getKommentitTunnuksella(String tunnus) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Kommentti, tunnus from Kommentti WHERE tunnus= ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);

        ResultSet rs = kysely.executeQuery();

        rs.next();
        KommentinHaku k = new KommentinHaku();
        k.setNimi(rs.getString("PelinNimi"));
        k.setKommentti(rs.getString("Kommentti"));
        k.setTunnus(rs.getString("tunnus"));

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

        return k;

    }

    public void MuokkaaKommentia(String kayttis) throws NamingException, SQLException {

        String sql = "UPDATE Kommentti set Kommentti = ? WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getKommentti());
        kysely.setString(2, kayttis);

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

    public static int lkmTunnuksellaJaNimella(String k, String peliNimi) throws NamingException, SQLException {

        String sql = "SELECT count(*) as lkm FROM Kommentti Where tunnus= ? AND PelinNimi= ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, k);
        kysely.setString(2, peliNimi);
        ResultSet rs = kysely.executeQuery();

        rs.next();
        int lkm = rs.getInt("lkm");

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
        return lkm;

    }

    public static int lkmNimella(String k) throws NamingException, SQLException {

        String sql = "SELECT count(*) as lkm FROM Kommentti Where PelinNimi= ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, k);
        ResultSet rs = kysely.executeQuery();

        rs.next();
        int lkm = rs.getInt("lkm");

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
        return lkm;

    }

    public boolean onkoKelvollinen() {
        return virheet.isEmpty();
    }

    public Collection<String> getVirheet() {

        return virheet.values();
    }

    public static void PoistaKommenttiNimella(String tunnus) throws NamingException, SQLException {

        String sql = "DELETE FROM Kommentti WHERE pelinNimi = ?";
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

    public static void PoistaKommenttiTunnuksella(String tunnus) throws NamingException, SQLException {

        String sql = "DELETE FROM Kommentti WHERE tunnus = ?";
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

