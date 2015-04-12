package HyllynPelit.Models;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aki
 */
public class OnkoKirjautunut {

    public String onkoKirjautunut(Kayttaja kirjautunut) {

        String palautus = "";

        if (kirjautunut != null) {
            palautus = "Kirjautunut sisään käyttäjällä: " + kirjautunut.getTunnus();

        } else {
            palautus = "Et ole kirjautunut sisään";

        }
        return palautus;

    }

    public boolean onkoKirjautunutBoolean(Kayttaja kirjautunut) {

        boolean palautus;

        palautus = kirjautunut != null;
        return palautus;

    }

}
