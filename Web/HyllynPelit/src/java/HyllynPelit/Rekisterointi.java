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
public class Rekisterointi {

    private String kayttis;
    private String salasana;
    private Map<String, String> virheet = new HashMap<String, String>();

    public void lisaaKayttisKantaan() throws NamingException, SQLException {

        String sql = "INSERT INTO Kayttaja (tunnus, salasana, oikeudet) VALUES (?, ?, 'normaali')";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, this.kayttis);
        kysely.setString(2, this.salasana);

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

    public static int lkmTunnuksella(String tunnus) throws NamingException, SQLException {

        String sql = "SELECT count(*) lkm from Kayttaja WHERE tunnus = ?";
        Connection yhteys = Yhteys.getYhteys();
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        kysely.setString(1, tunnus);

        ResultSet tulokset = kysely.executeQuery();
        ArrayList<Rekisterointi> peli = new ArrayList<Rekisterointi>();
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

    public Collection<String> getVirheet() {
        return virheet.values();
    }

    public void setVirheet(Map<String, String> virheet) {
        this.virheet = virheet;
    }

    public String getKayttis() {
        return kayttis;
    }

    public void setKayttis(String kayttis) {
        this.kayttis = kayttis;
        if (kayttis.trim().length() == 0) {
            virheet.put("Käyttäjätunnus", "tunnus ei saa olla tyhä!");
        }
        if (kayttis.length() > 50) {
            virheet.put("käyttäjätunnus", "tunnus ei saa ylittää 50 merkkiä!");
        }
    }

    public String getSalasana() {
        return salasana;
    }

    public void setSalasana(String salasana) {
        this.salasana = salasana;
        if (salasana.trim().length() == 0) {
            virheet.put("Salasana", "Salasana ei saa olla tyhä!");
        }
        if (salasana.length() > 50) {
            virheet.put("Salasana", "Salasana ei saa ylittää 50 merkkiä!");
        }
    }

    public boolean onkoKelvollinen() {
        return virheet.isEmpty();

    }

}
