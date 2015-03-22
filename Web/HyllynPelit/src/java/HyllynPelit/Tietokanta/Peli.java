package HyllynPelit.Tietokanta;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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

    public Peli(String peli, String tekija, String alusta) {
        this.peli = peli;
        this.peli = tekija;
        this.tekija = alusta;

    }

    public Peli() {

    }

    public static List<Peli> getPelit() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT PelinNimi, Tekijä, Pelialusta from Peli";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Peli> kayttajat = new ArrayList<Peli>();
        while (rs.next()) {
            Peli k = new Peli();
            k.setPeli(rs.getString("PelinNimi"));
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


    public String getPeli() {
        return peli;
    }

    public void setPeli(String peli) {
        this.peli = peli;
    }

    public String gettekija() {
        return tekija;
    }

    public void setTekija(String tekija) {
        this.tekija = tekija;
    }

    public String getAlusta() {
        return alusta;
    }

    public void setAlusta(String alusta) {
        this.alusta = alusta;
    }

}
