package HyllynPelit;

import static HyllynPelit.Arvostelu.getArvostelutNimella;
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
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

        public static int lukumaaraPelille(String pelinNimi) throws NamingException, SQLException {
        String sql = "Select count(*) as lkm FROM Arvostelu WHERE PelinNimi = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, pelinNimi);
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
    public static void MuokkaaArvostelua(int arv, String pelinNimi, String tunnus) throws NamingException, SQLException {
        String sql = "UPDATE arvostelu set arvosana = ? WHERE pelinNimi = ? AND tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);

        kysely.setInt(1, arv);
        kysely.setString(2, pelinNimi);
        kysely.setString(3, tunnus);
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

    public static List<Arvostelu> getArvostelut() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT Arvostelu.PelinNimi, Peli.Julkaisuvuosi, Arvostelu.arvosana, to_char(ArvostelunLisaysPaiva,'DD.MM.YYYY') ArvostelunLisaysPaiva, tunnus, id from Arvostelu INNER JOIN Peli ON Arvostelu.PelinNimi = Peli.PelinNimi";
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
            k.setId(rs.getInt("id"));
            if (!k.getTunnus().equals("tyhjaArvo")) {
                arvostelut.add(k);
            }
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
    


    public static Arvostelu haeID(String pelinNimi, String tunnus) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT id from Arvostelu WHERE tunnus = ? AND pelinNimi = ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        kysely.setString(2, pelinNimi);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Arvostelu> arvostelut = new ArrayList<Arvostelu>();
        while (rs.next()) {
            Arvostelu k = new Arvostelu();
            k.setId(rs.getInt("id"));
            arvostelut.add(k);

        }
        Arvostelu a = arvostelut.get(0);

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

        return a;

    }

    public static List<Arvostelu> haeArvostelutHakuSanalla(String hakuSana) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, arvosana, to_char(ArvostelunLisaysPaiva,'DD.MM.YYYY') ArvostelunLisaysPaiva, tunnus from Arvostelu WHERE LOWER(PelinNimi) LIKE ? OR LOWER(tunnus) LIKE ?";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, "%" + hakuSana.toLowerCase() + "%");
        kysely.setString(2, "%" + hakuSana.toLowerCase() + "%");
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

    public static List<Arvostelu> getArvostelutTunnuksella(String tunnus) throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, arvosana, ArvostelunLisaysPaiva, tunnus from Arvostelu WHERE tunnus= ?";
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

    public static void PoistaArvostelu(String tunnus, String pelinNimi, boolean bool) throws NamingException, SQLException {

        String sql;
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = null;

        sql = "DELETE FROM Arvostelu WHERE tunnus = ? AND pelinNimi = ?";
        kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);
        kysely.setString(2, pelinNimi);

        kysely.execute();

        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }
        if (bool == true) {                                 //härpäke juu. mutta ilman tätä keskiarvo ei näytä toimivan..
            Arvostelu arvostelu = new Arvostelu();
            arvostelu.setArvosana(0);
            arvostelu.setNimi("tyhjaArvo");
            arvostelu.setTunnus("tyhjaArvo");
            arvostelu.lisaaArvosteluKantaan("tyhjaArvo");
        }

    }

    public static void MuokkaaArvostelua(int arvosana, int id) throws NamingException, SQLException {

        String sql = "UPDATE Arvostelu SET  arvosana = ?  WHERE id = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setInt(1, arvosana);
        kysely.setInt(2, id);

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
        List<Arvostelu> l = getArvostelutTunnuksella("tyhjaArvo");                  //keskiarvon vuoksi
        if (!l.isEmpty()) {
            PoistaArvostelu("tyhjaArvo", this.getNimi(), false);
        }
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
