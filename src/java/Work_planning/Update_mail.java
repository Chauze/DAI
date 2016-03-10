/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Hib_util.HibernateUtil_airbus;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.SQLQuery;
import org.hibernate.Session;

/**
 *
 * @author Fast
 */
public class Update_mail extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //define the page has not to be cache in order to allow refresh of the page under Internet Explorer
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idstep = request.getParameter("step");
        String msn = request.getParameter("msn");
        String inspector = request.getParameter("inspector");
        String phase = request.getParameter("phase");

        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();
        
        //allow to define thaht an email has been sent to someone

        if ("Section".equals(phase)) {
            SQLQuery L = sh.createSQLQuery("UPDATE inspect_section SET DATE_INS =sysdate(), mail_s='sent' where id_s=" + idstep + " and msn=" + msn + " and id_i=" + inspector);
            L.executeUpdate();
            sh.getTransaction().commit();
        }

        if ("FAL".equals(phase)) {
            SQLQuery L2 = sh.createSQLQuery("UPDATE inspect_fal SET DATE_INS =sysdate(), mail_f='sent' where id_f=" + idstep + " and msn=" + msn + " and id_i=" + inspector);
            L2.executeUpdate();
            sh.getTransaction().commit();
        }

        if ("Delivery".equals(phase)) {
            SQLQuery L3 = sh.createSQLQuery("UPDATE inspect_deliv SET DATE_INS =sysdate(), mail_d='sent' where id_d=" + idstep + " and msn=" + msn + " and id_i=" + inspector);
            L3.executeUpdate();
            sh.getTransaction().commit();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
