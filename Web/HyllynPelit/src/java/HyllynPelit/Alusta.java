package HyllynPelit;

import HyllynPelit.Tietokanta.Yhteys;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author Aki
 */
public class Alusta {
    private String alusta;

    public String getAlusta() {
        return alusta;
    }

    public void setAlusta(String alusta) {
        this.alusta = alusta;
    }
    
    public static List<Alusta> GetAlustat() throws NamingException, SQLException {
        Connection yhteys = Yhteys.getYhteys();

        String sql = "SELECT Pelialusta FROM Pelialusta";
        PreparedStatement kysely = yhteys.prepareStatement(sql);
        ResultSet rs = kysely.executeQuery();
        ArrayList<Alusta> alustat = new ArrayList<Alusta>();
        while (rs.next()) {
            Alusta k = new Alusta();
            k.setAlusta(rs.getString("Pelialusta"));
            alustat.add(k);

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

        return alustat;

    }
    
    
}
