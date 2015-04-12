package HyllynPelit.Servlets;

import HyllynPelit.Models.Kayttaja;
import java.io.IOException;
import java.io.PrintWriter;
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
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws javax.naming.NamingException
     * @throws java.sql.SQLException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, NamingException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        RequestDispatcher dispatcher = request.getRequestDispatcher("Kirjautuminen.jsp");
        String password = request.getParameter("Salasana");
        String tunnus = request.getParameter("Kayttajatunnus");
        
        HttpSession session = request.getSession();
        Kayttaja kayttajatiedot = Kayttaja.etsiKayttajaTunnuksilla(tunnus, password);
        if (kayttajatiedot != null) {
           
            session.setAttribute("Kirjautunut", kayttajatiedot);
            response.sendRedirect("Etusivu");

        } else {
            if (tunnus.trim().isEmpty() && !password.trim().isEmpty()) {
                request.setAttribute("virheViesti", "Käyttäjätunnus puuttui!");
                dispatcher.forward(request, response);
            } else if (password.trim().isEmpty() && !tunnus.trim().isEmpty()) {
                request.setAttribute("virheViesti", "Salasanaa puuttui!");
                dispatcher.forward(request, response);
            } else if (tunnus.trim().isEmpty() && password.trim().isEmpty()) {
                request.setAttribute("virheViesti", "Käyttäjätunnus ja salasana puuttuivat!");
                dispatcher.forward(request, response);
            } else {
                request.setAttribute("virheViesti", "Käyttäjätunnus tai salasana on väärin!");
                dispatcher.forward(request, response);
            }
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
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Login.class
                    .getName()).log(Level.SEVERE, null, ex);
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
