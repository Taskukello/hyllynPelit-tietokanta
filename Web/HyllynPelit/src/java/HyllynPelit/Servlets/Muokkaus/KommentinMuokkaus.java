package HyllynPelit.Servlets.Muokkaus;

import HyllynPelit.KommentinHaku;
import HyllynPelit.Models.Kayttaja;
import HyllynPelit.Models.OnkoKirjautunut;
import HyllynPelit.UudelleenOhjaus;
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
public class KommentinMuokkaus extends HttpServlet {

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
        RequestDispatcher dispatcher = request.getRequestDispatcher("KommentinMuokkaus.jsp");
        Kayttaja kirjautunut = (Kayttaja) session.getAttribute("Kirjautunut");
        OnkoKirjautunut k = new OnkoKirjautunut();
        String palautus = k.onkoKirjautunut(kirjautunut);
        request.setAttribute("KirjautumisTilanne", palautus);
        KommentinHaku uusiKommentti = new KommentinHaku();

        uusiKommentti.setKommentti(request.getParameter("kommentti"));
        uusiKommentti.setNimi(request.getParameter("PelinNimi"));
        String button = request.getParameter("button");
        if (button == null) {

            if (uusiKommentti.onkoKelvollinen() == true) {
                uusiKommentti.MuokkaaKommentia(kirjautunut.getTunnus());

                session.setAttribute("ilmoitus", "Kommenttiasi on muokattu onnistuneesti.");
                session.removeAttribute("valinta");
                UudelleenOhjaus o = new UudelleenOhjaus(uusiKommentti.getNimi());
                session.setAttribute("tiedonsiirto", o);
                response.sendRedirect("Kommentti");
            } else {
                Collection<String> virheet = uusiKommentti.getVirheet();
                session.setAttribute("virheet", virheet);
                session.setAttribute("arvostelut", uusiKommentti);
                response.sendRedirect("KommentinMuokkaus");
            }

        } else {
            if (button.contains("poista")) {
                KommentinHaku.PoistaKommenttiTunnuksella(kirjautunut.getTunnus());
                session.setAttribute("ilmoitus", "Kommenttisi on poistettu.");
                session.removeAttribute("valinta");
                UudelleenOhjaus o = new UudelleenOhjaus(uusiKommentti.getNimi());
                session.setAttribute("tiedonsiirto", o);
                response.sendRedirect("Kommentti");
            } else {
                session.removeAttribute("valinta");
                UudelleenOhjaus o = new UudelleenOhjaus(uusiKommentti.getNimi());
                session.setAttribute("tiedonsiirto", o);
                response.sendRedirect("Kommentti");
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
            Logger.getLogger(KommentinMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KommentinMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(KommentinMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(KommentinMuokkaus.class.getName()).log(Level.SEVERE, null, ex);
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
