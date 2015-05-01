package HyllynPelit.Servlets.Muokkaus;

import HyllynPelit.Arvostelu;
import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import HyllynPelit.Peli;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.sql.SQLException;
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
public class MuokkaaPelia extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("PelinMuokkaus.jsp");
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("Kirjautunut");
        OnkoKirjautunut k = new OnkoKirjautunut();
        String palautus = k.onkoKirjautunut(kirjautunut);
        request.setAttribute("KirjautumisTilanne", palautus);

        String nimi = request.getParameter("Nimi");
        Peli uusiPeli = Peli.haePeli(nimi);
        Peli muokattuPeli = new Peli();
        muokattuPeli.setPeli(nimi);
        muokattuPeli.setLisays(uusiPeli.getLisays());
        muokattuPeli.setTekija(request.getParameter("Tekija"));
        muokattuPeli.setVuosi(request.getParameter("Julkaisuvuosi"));
        muokattuPeli.setAlusta(request.getParameter("Alusta"));
        Peli.haePelitNimella(nimi);
        muokattuPeli.MuokkaaPelia(uusiPeli);
        session.setAttribute("ilmoitus", "Pelin " + nimi + " tiedot on päivitetty.");
        response.sendRedirect("Pelit");
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
            Logger.getLogger(MuokkaaPelia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuokkaaPelia.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(MuokkaaPelia.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MuokkaaPelia.class.getName()).log(Level.SEVERE, null, ex);
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
