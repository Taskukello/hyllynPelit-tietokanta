package HyllynPelit.Servlets.Lisays;

import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import HyllynPelit.Peli;
import HyllynPelit.Rekisterointi;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
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
public class LisaaTunnus extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
        RequestDispatcher dispatcher = request.getRequestDispatcher("Sign-up.jsp");
        Rekisterointi rekisteri = new Rekisterointi();
        rekisteri.setKayttis(request.getParameter("Tunnus"));
        rekisteri.setSalasana(request.getParameter("salasana"));
        if (rekisteri.onkoKelvollinen() == true) {
            int k = Rekisterointi.lkmTunnuksella(rekisteri.getKayttis());
            if (k == 0) {
                rekisteri.lisaaKayttisKantaan();
                Kayttaja kayttaja = new Kayttaja();
                kayttaja.setTunnus(rekisteri.getKayttis());
                kayttaja.setSalasana(rekisteri.getSalasana());
                kayttaja.setTaso("normaali");
                session.setAttribute("Kirjautunut", kayttaja);
                session.setAttribute("ilmoitus", "Uusi tunnus lisätty onnistuneesti.");
                response.sendRedirect("Etusivu");

            } else {
                ArrayList<String> virheet = new ArrayList<String>();
                virheet.add("Valitettavasti kyseinen tunnus (" + rekisteri.getKayttis() + ") on jo käytössä");
                request.setAttribute("virheet", virheet);
                dispatcher.forward(request, response);
            }

        } else {
            Collection<String> virheet = rekisteri.getVirheet();
            request.setAttribute("virheet", virheet);
            request.setAttribute("rekisteri", rekisteri);
            dispatcher.forward(request, response);
        }

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
            Logger.getLogger(LisaaTunnus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LisaaTunnus.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(LisaaTunnus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LisaaTunnus.class.getName()).log(Level.SEVERE, null, ex);
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
