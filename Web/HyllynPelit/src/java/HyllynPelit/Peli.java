package HyllynPelit;

import HyllynPelit.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
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
public class Peli {

    private String peli;
    private String tekija;
    private String alusta;
    private String lisays;
    private int vuosi;
    private int id;
    private Map<String, String> virheet = new HashMap<String, String>();

    public Peli(String peli, String tekija, String alusta, int vuosi, String lisays) {
        this.peli = peli;
        this.tekija = tekija;
        this.alusta = alusta;
        this.vuosi = vuosi;
        this.lisays = lisays;

    }

    public Peli() {

    }

    public static List<Peli> getPelit() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();
        // int montako = 10;
        // int sivu = 2;
        String sql = "SELECT PelinNimi, to_char(MilloinLisätty,'DD.MM.YYYY') MilloinLisätty,  Julkaisuvuosi, Tekijä, Pelialusta from Peli ORDER by PelinNimi";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        // kysely.setInt(1, montako);
        // kysely.setInt(2, (sivu - 1) * montako);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Peli> kayttajat = new ArrayList<Peli>();
        while (rs.next()) {
            Peli k = new Peli();
            k.setPeli(rs.getString("PelinNimi"));
            k.setLisays(rs.getString("MilloinLisätty"));
            k.setVuosi(rs.getString("Julkaisuvuosi"));
            k.setTekija(rs.getString("Tekijä"));
            k.setAlusta(rs.getString("Pelialusta"));
            kayttajat.add(k);

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

        return kayttajat;

    }

    public static int lukumaara() throws NamingException, SQLException {
        String sql = "Select count(*) as lkm FROM Peli";
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

    public static void PoistaPeli(String nimi) throws NamingException, SQLException {
        if (!Kommentti.getKommentitNimella(nimi).isEmpty()) {
            Kommentti.PoistaKommentti(nimi);
        }
        if (!Arvostelu.getArvostelutNimella(nimi).isEmpty()) {
            Arvostelu.PoistaArvosteluPelinNimella(nimi);
        }
        String sql = "DELETE FROM Peli WHERE PelinNimi = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, nimi);

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

    public static Peli haePeli(String nimi) throws NamingException, SQLException {

        String sql = "SELECT PelinNimi, to_char(MilloinLisätty,'DD.MM.YYYY') MilloinLisätty, Julkaisuvuosi, Tekijä, Pelialusta from Peli WHERE PelinNimi = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, nimi);

        ResultSet rs = kysely.executeQuery();
        ArrayList<Peli> kayttajat = new ArrayList<Peli>();
        while (rs.next()) {
            Peli k = new Peli();
            k.setPeli(rs.getString("PelinNimi"));
            k.setLisays(rs.getString("MilloinLisätty"));
            k.setVuosi(rs.getString("Julkaisuvuosi"));
            k.setTekija(rs.getString("Tekijä"));
            k.setAlusta(rs.getString("Pelialusta"));
            kayttajat.add(k);
        }

        Peli k = kayttajat.get(0);
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

    public static List<Peli> haePelitTunnuksella(String tunnus) throws NamingException, SQLException {

        String sql = "Select PelinNimi from Arvostelu WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);

        ResultSet rs = kysely.executeQuery();
        ArrayList<Peli> peli = new ArrayList<Peli>();
        while (rs.next()) {
            Peli k = new Peli();
            k.setPeli(rs.getString("PelinNimi"));
            peli.add(k);
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
        return peli;
    }

    public void lisaaPeliKantaan() throws NamingException, SQLException {

        String sql = "INSERT INTO Peli (PelinNimi, Julkaisuvuosi, Tekijä, MilloinLisätty, Pelialusta) VALUES (?, ?, ?, CURRENT_TIMESTAMP, ?)";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getPeli());
        kysely.setInt(2, this.getVuosi());
        kysely.setString(3, this.getTekija());
        kysely.setString(4, this.getAlusta());

        kysely.execute();
        // rs.next();

        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }
    }

    public void MuokkaaPelia(Peli peli) throws NamingException, SQLException {
        TaytaTyhjat(peli);
        String sql = "UPDATE Peli set PelinNimi = ?, Julkaisuvuosi = ?, Tekijä = ?, MilloinLisätty = CURRENT_TIMESTAMP, Pelialusta = ? Where PelinNimi = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.getPeli());
        kysely.setInt(2, this.getVuosi());
        kysely.setString(3, this.getTekija());
        kysely.setString(4, this.getAlusta());
        kysely.setString(5, this.getPeli());

        kysely.execute();
        // rs.next();

        try {
            kysely.close();
        } catch (Exception e) {
        }
        try {
            yhteys.close();
        } catch (Exception e) {
        }
    }

    public void TaytaTyhjat(Peli peli) {
        if (this.tekija == null || this.tekija.trim().length() == 0) {
            this.tekija = peli.getTekija();
        }
        this.lisays = peli.getLisays();
        this.peli = peli.getPeli();
    }

    public String getPeli() {
        return peli;
    }

    public void setPeli(String peli) {

        this.peli = peli;
        if (peli.trim().length() == 0) {
            virheet.put("peli", "Pelin nimi ei saa olla tyhä!");
        }
    }

    public String getTekija() {
        return tekija;
    }

    public String getLisays() {
        return lisays;
    }

    public void setLisays(String MilloinLisatty) {
        this.lisays = MilloinLisatty;

    }

    public int getVuosi() {
        return vuosi;
    }

    public void setVuosi(String julkaisuvuosi) {

        this.vuosi = Integer.parseInt(julkaisuvuosi);

    }

    public void setTekija(String tekija) {
        this.tekija = tekija;

        if (tekija == null || tekija.trim().length() == 0) {
            virheet.put("tekija", "Tekijä ei saa olla tyhjä!");
        }
    }

    public String getAlusta() {
        return alusta;
    }

    public void setAlusta(String alusta) {
        this.alusta = alusta;
    }

    public boolean onkoKelvollinen() {
        return virheet.isEmpty();

    }

    public Collection<String> getVirheet() {

        return virheet.values();
    }

}
