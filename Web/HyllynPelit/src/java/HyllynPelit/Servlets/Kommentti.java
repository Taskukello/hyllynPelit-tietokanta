package HyllynPelit.Servlets;

import HyllynPelit.Arvostelu;
import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import java.io.IOException;
import java.io.PrintWriter;
import HyllynPelit.KommentinHaku;
import HyllynPelit.Peli;
import HyllynPelit.UudelleenOhjaus;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Aki
 */
public class Kommentti extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods. metodi on ainakin omasta mielestäni kovin iso. En tiedä miten
     * servelttien kanssa toimitaan joten en ole viitsinyt pilkkoa sitä
     * pienemmäksi Metodi myös saattaa näyttää hieman härpäkkeeltä ja suurin syy
     * tähän lienee. Se että Servlettiä käyttävä jsp on myös ehkä
     * toiminallisuudeltaan suurin. Serlvetti Nimenomaisesti hoitaa sivutuksen
     * mutta hieman eritavalla kuin esimerkeissä koska esimerkki sivutus ei
     * tukenut datan lähetystä.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=ISO-8859-1");
        HttpSession session = request.getSession();

        RequestDispatcher dispatcher = request.getRequestDispatcher("Kommentti.jsp");
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("Kirjautunut");
        OnkoKirjautunut k = new OnkoKirjautunut();
        String palautus = k.onkoKirjautunut(kirjautunut);
        request.setAttribute("KirjautumisTilanne", palautus);

        UudelleenOhjaus ohjaus = (UudelleenOhjaus) session.getAttribute("valinta");
        String ilmoitus = (String) session.getAttribute("ilmoitus");
        if (ilmoitus != null) {
            session.removeAttribute("ilmoitus");

            request.setAttribute("ilmoitus", ilmoitus);
        }
        int yksiKommentti = 1;
        String sivuParametri = request.getParameter("sivu");
        int sivu = 1;
        int sivuja = 0;
        List<KommentinHaku> kommentit = new ArrayList<KommentinHaku>();
        Peli peli = null;

        if (ohjaus == null) {

            if (request.getParameter("pelinNimi") == null) {
                ohjaus = (UudelleenOhjaus) session.getAttribute("tiedonsiirto");
                session.removeAttribute("tiedonsiirto");
                ohjaus.setSivunumero(1);
                ohjaus = new UudelleenOhjaus(ohjaus.getAtribuutti(), sivu);

                kommentit = KommentinHaku.getKommentitSivulla(ohjaus.getAtribuutti(), sivu, yksiKommentti);
                peli = Peli.haePeli(ohjaus.getAtribuutti());
                int kommenttilkm = KommentinHaku.lkmNimella(ohjaus.getAtribuutti());
                sivuja = (int) Math.ceil((double) kommenttilkm / yksiKommentti);

            } else {
                ohjaus = new UudelleenOhjaus(request.getParameter("pelinNimi"), sivu);
                peli = Peli.haePeli(request.getParameter("pelinNimi"));
                kommentit = KommentinHaku.getKommentitSivulla(request.getParameter("pelinNimi"), sivu, yksiKommentti);

                int kommenttilkm = KommentinHaku.lkmNimella(request.getParameter("pelinNimi"));
                sivuja = (int) Math.ceil((double) kommenttilkm / yksiKommentti);
            }
        } else {
            int kommenttilkm = KommentinHaku.lkmNimella(ohjaus.getAtribuutti());
            peli = Peli.haePeli(ohjaus.getAtribuutti());
            sivuja = (int) Math.ceil((double) kommenttilkm / yksiKommentti);
            sivu = ohjaus.getSivunumero();
            String pelinNimi = ohjaus.getAtribuutti();
            if ("Seuraava".equals(request.getParameter("action"))) {
                sivu++;
            } else {
                sivu--;
            }

            kommentit = KommentinHaku.getKommentitSivulla(pelinNimi, sivu, yksiKommentti);

        }

        ohjaus.setSivunumero(sivu);
        ohjaus.setSuurinSivuNumero(sivuja);
        request.setAttribute("keskiarvo", peli.getKeskiarvo());
        request.setAttribute("arvosteluita", Arvostelu.lukumaaraPelille(peli.getPeli()));
        request.setAttribute("pelinjulkaisia", peli.getTekija());
        request.setAttribute("pelinJvuosi", peli.getVuosi());
        request.setAttribute("pelinNimi", ohjaus.getAtribuutti());
        session.setAttribute("valinta", ohjaus);
        request.setAttribute("sivu", sivu);
        request.setAttribute("sivuja", sivuja);
        request.setAttribute("kommentit", kommentit);
        request.setAttribute("onkoKommentti", KommentinHaku.lkmTunnuksellaJaNimella(kirjautunut.getTunnus(), ohjaus.getAtribuutti()));
        request.setAttribute("oikeus", kirjautunut.getTaso());

        dispatcher.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Kommentti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kommentti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NamingException ex) {
            Logger.getLogger(Kommentti.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Kommentti.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
