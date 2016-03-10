/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Hib_util.HibernateUtil_airbus;
import Work.InspectDeliv;
import Work.InspectFal;
import Work.InspectSection;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

/**
 *
 * @author Khadija
 */
public class UpdateCom extends HttpServlet {

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


        //this servlet allow to save the comments and the status of an inspection
        
        String com = request.getParameter("com");

        String phase = request.getParameter("phase");
        int id = Integer.parseInt(request.getParameter("idph"));
        int msn = Integer.parseInt(request.getParameter("msn"));
        String st = request.getParameter("st");


        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        if ("FAL".equals(phase)) {
            List<InspectFal> ins1;
            ins1 = PlanInspecBd.searchFal(id, msn);
            InspectFal isp = ins1.get(0);
            isp.setStatusFal(st);
            isp.setComments(com);
            sh.update(isp);
            sh.getTransaction().commit();
        }



        if ("Delivery".equals(phase)) {

            List<InspectDeliv> ins;
            ins = PlanInspecBd.searchDel(id, msn);
            InspectDeliv isp = ins.get(0);
            isp.setStatusDel(st);
            isp.setComments(com);
            sh.update(isp);
            sh.getTransaction().commit();
        }
        
        if ("Section".equals(phase)) {

            List<InspectSection> ins;
            ins = PlanInspecBd.searchSect(id, msn);
            InspectSection isp = ins.get(0);
            isp.setStatusSect(st);
            isp.setComments(com);
            sh.update(isp);
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
