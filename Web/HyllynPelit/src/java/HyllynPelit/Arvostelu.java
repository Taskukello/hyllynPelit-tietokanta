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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author Aki
 */
public class Arvostelu {

    private String nimi;
    private String vuosi;
    private int arvosana;
    private String lisayspaiva;
    private Map<String, String> virheet = new HashMap<String, String>();
    private String tunnus;

    public String getTunnus() {
        return tunnus;
    }

    public void setTunnus(String tunnus) {
        this.tunnus = tunnus;
    }

    public Arvostelu() {

    }

    public String getNimi() {
        return nimi;
    }

    public void setNimi(String nimi) {

        this.nimi = nimi;
        if (nimi == null || nimi.trim().length() == 0) {
            virheet.put("peli", "Pelin nimi ei saa olla tyhä!");
        }
    }

    public String getVuosi() {
        return vuosi;
    }

    public void setVuosi(String vuosi) {
        this.vuosi = vuosi;
        if (vuosi.trim().length() == 0) {
            virheet.put("Vuosi", "Vuosiluku puuttui!");
        }
    }

    public int getArvosana() {
        return arvosana;
    }

    public void setArvosana(int arvosana) {
        this.arvosana = arvosana;

    }

    public String getLisayspaiva() {
        return lisayspaiva;
    }

    public void setLisayspaiva(String lisayspaiva) {
        this.lisayspaiva = lisayspaiva;
    }

    public static int lukumaara() throws NamingException, SQLException {
        String sql = "Select count(*) as lkm FROM Arvostelu";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet tulokset = kysely.executeQuery();
        tulokset.next();
        int lkm = tulokset.getInt("lkm");
        try {
            tulokset.close();
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

    public static List<Arvostelu> getArvostelut() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT Arvostelu.PelinNimi, Peli.Julkaisuvuosi, Arvostelu.arvosana, to_char(ArvostelunLisaysPaiva,'DD.MM.YYYY') ArvostelunLisaysPaiva, tunnus from Arvostelu INNER JOIN Peli ON Arvostelu.PelinNimi = Peli.PelinNimi";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Arvostelu> arvostelut = new ArrayList<Arvostelu>();
        while (rs.next()) {
            Arvostelu k = new Arvostelu();
            k.setNimi(rs.getString("PelinNimi"));
            k.setVuosi(rs.getString("Julkaisuvuosi"));
            k.setArvosana(rs.getInt("arvosana"));
            k.setLisayspaiva(rs.getString("ArvostelunLisaysPaiva"));
            k.setTunnus(rs.getString("tunnus"));
            arvostelut.add(k);

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

        return arvostelut;

    }
    
    public static List<Arvostelu> haeID() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT Arvostelu.PelinNimi, Peli.Julkaisuvuosi, Arvostelu.arvosana, to_char(ArvostelunLisaysPaiva,'DD.MM.YYYY') ArvostelunLisaysPaiva, tunnus from Arvostelu INNER JOIN Peli ON Arvostelu.PelinNimi = Peli.PelinNimi";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Arvostelu> arvostelut = new ArrayList<Arvostelu>();
        while (rs.next()) {
            Arvostelu k = new Arvostelu();
            k.setNimi(rs.getString("PelinNimi"));
            k.setVuosi(rs.getString("Julkaisuvuosi"));
            k.setArvosana(rs.getInt("arvosana"));
            k.setLisayspaiva(rs.getString("ArvostelunLisaysPaiva"));
            k.setTunnus(rs.getString("tunnus"));
            arvostelut.add(k);

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

        return arvostelut;

    }

    public static List<Arvostelu> getArvostelutNimella(String tunnus) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, arvosana, ArvostelunLisaysPaiva, tunnus from Arvostelu WHERE PelinNimi= ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        ResultSet rs = kysely.executeQuery();

        ArrayList<Arvostelu> arvostelut = new ArrayList<Arvostelu>();
        while (rs.next()) {
            Arvostelu k = new Arvostelu();
            k.setNimi(rs.getString("PelinNimi"));
            k.setArvosana(rs.getInt("arvosana"));
            k.setLisayspaiva(rs.getString("ArvostelunLisaysPaiva"));
            k.setTunnus(rs.getString("tunnus"));
            arvostelut.add(k);

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

        return arvostelut;

    }

    public static void PoistaArvosteluPelinNimella(String tunnus) throws NamingException, SQLException {

        String sql = "DELETE FROM Arvostelu WHERE PelinNimi = ?";
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

    public static void MuokkaaArvostelua(int id) throws NamingException, SQLException {

        String sql = "UPDATE Arvostelu SET  arvosana = ?  WHERE id = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, id);

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

    public void lisaaArvosteluKantaan(String kayttis) throws NamingException, SQLException {

        String sql = "INSERT INTO Arvostelu (PelinNimi, arvosana, ArvostelunLisaysPaiva , tunnus) VALUES (?, ?, CURRENT_TIMESTAMP, ?)";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getNimi());
        kysely.setInt(2, this.arvosana);
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
}
