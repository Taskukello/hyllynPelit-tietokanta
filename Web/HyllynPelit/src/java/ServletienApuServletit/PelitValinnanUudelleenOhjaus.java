package ServletienApuServletit;

import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import HyllynPelit.Peli;
import HyllynPelit.UudelleenOhjaus;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class PelitValinnanUudelleenOhjaus extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");

        HttpSession session = request.getSession();
        RequestDispatcher dispatcher = request.getRequestDispatcher("Kommentti.jsp");
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("Kirjautunut");

        String nimi = request.getParameter("muokattavanNimi");
        String button = request.getParameter("action");
        UudelleenOhjaus ohjaus = new UudelleenOhjaus(nimi);
        session.setAttribute("Nimi", ohjaus);
        if (button.equals("muokkaa")) {

            response.sendRedirect("PelinMuokkaus");
        } else if (button.equals("Kommentti")) {
            response.sendRedirect("KommentinLisays");
        } else if (button.equals("KommentinMuokkaus")) {
            response.sendRedirect("KommentinMuokkausLook");
        } else if (button.equals("Poista")) {
            Peli.PoistaPeli(nimi, kirjautunut.getTunnus());
            session.setAttribute("ilmoitus", nimi + " On poistettu tietokannasta.");
            response.sendRedirect("Pelit");
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
            Logger.getLogger(PelitValinnanUudelleenOhjaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PelitValinnanUudelleenOhjaus.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PelitValinnanUudelleenOhjaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PelitValinnanUudelleenOhjaus.class.getName()).log(Level.SEVERE, null, ex);
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
