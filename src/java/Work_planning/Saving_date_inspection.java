/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Hib_util.HibernateUtil_airbus;
import Work.InspectFal;
import Work.InspectSection;
import Work_define.changeformat_date;
import Work_servlet.Saving_services;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

public class Saving_date_inspection extends HttpServlet {

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

        String start = request.getParameter("start");
        String end = request.getParameter("end");
        String phase = request.getParameter("phase");
        int msn = Integer.parseInt(request.getParameter("msn"));
        int idp = Integer.parseInt(request.getParameter("idph"));


        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();


        //this servlet allow to update the interval of date for inspection of an specific step of an phase type

        if ("FAL".equals(phase)) {

            changeformat_date datechange = new changeformat_date();
            String date_begin = datechange.change_date(start);
            String date_end = datechange.change_date(end);

            SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");

            List<InspectFal> ins;

            ins = PlanInspecBd.searchFal(idp, msn);

            InspectFal isp = ins.get(0);

            Date date;
            try {

                date = formatdate.parse(date_begin);
                isp.setStart(date);


                date = formatdate.parse(date_end);
                isp.setEnd(date);

            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }
            sh.update(isp);
            sh.getTransaction().commit();
        }

        if ("Section".equals(phase)) {

            changeformat_date datechange = new changeformat_date();
            String date_begin = datechange.change_date(start);
            String date_end = datechange.change_date(end);

            SimpleDateFormat formatdate = new SimpleDateFormat("yyyy-MM-dd");

            List<InspectSection> ins;

            ins = PlanInspecBd.searchSect(idp, msn);

            InspectSection isp = ins.get(0);

            Date date;
            try {

                date = formatdate.parse(date_begin);
                isp.setDateStartS(date);


                date = formatdate.parse(date_end);
                isp.setDateEndS(date);

            } catch (ParseException ex) {
                Logger.getLogger(Saving_services.class.getName()).log(Level.SEVERE, null, ex);
            }
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
