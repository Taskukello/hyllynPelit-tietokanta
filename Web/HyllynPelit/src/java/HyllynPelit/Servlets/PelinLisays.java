package HyllynPelit.Servlets;

import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import HyllynPelit.Peli;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class PelinLisays extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("PelinLisays.jsp");
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("Kirjautunut");
        OnkoKirjautunut k = new OnkoKirjautunut();
        String palautus = k.onkoKirjautunut(kirjautunut);
        request.setAttribute("KirjautumisTilanne", palautus);

        Peli uusiPeli = new Peli();
        uusiPeli.setAlusta(request.getParameter("Alusta"));
        uusiPeli.setPeli(request.getParameter("PelinNimi"));
        uusiPeli.setTekija(request.getParameter("Tekija"));
        uusiPeli.setVuosi(request.getParameter("Julkaisuvuosi"));

        if (uusiPeli.onkoKelvollinen() == true) {
            uusiPeli.lisaaPeliKantaan();

            
            session.setAttribute("ilmoitus", "Uusi peli lisätty onnistuneesti.");
            response.sendRedirect("Pelit");
            
        } else {
            Collection<String> virheet = uusiPeli.getVirheet();
            request.setAttribute("virheet", virheet);
            request.setAttribute("Peli", uusiPeli);
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
            Logger.getLogger(PelinLisays.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PelinLisays.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(PelinLisays.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(PelinLisays.class.getName()).log(Level.SEVERE, null, ex);
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
