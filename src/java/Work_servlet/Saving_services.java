/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Work.*;
import Work_define.ServicesBD;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Fast
 */
public class Saving_services extends HttpServlet {

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

        //this servlet allow to creat a booking for a resource according to an owner 
        try {

            String namebd = request.getParameter("nameserv");
            String owner = request.getParameter("own");
            int idresbooked = Integer.parseInt(request.getParameter("res"));
            String date_begin = request.getParameter("date_begin");
            String date_end = request.getParameter("date_end");

            if ("Office".equals(namebd)) {
                List<Object> lstown = ServicesBD.getid_reources(namebd, idresbooked);
                Office id_find = (Office) lstown.get(0);
                
                Long cc = id_find.getCodeO();
                String dd = cc.toString();
                int id_find2 = Integer.parseInt(dd);

                Owner owner2 = ServicesBD.getidOwner_type(owner);
                ServicesBD.recbooking_office(date_begin, date_end, namebd, id_find2, owner2);
            }

            if ("Car".equals(namebd)) {
                List<Object> lstown = ServicesBD.getid_reources(namebd, idresbooked);
                Car id_find = (Car) lstown.get(0);
                
                int id_find2 = id_find.getIdC();

                Owner owner2 = ServicesBD.getidOwner_type(owner);
                ServicesBD.recbooking_office(date_begin, date_end, namebd, id_find2, owner2);
            }

            if ("Secretary".equals(namebd)) {
                List<Object> lstown = ServicesBD.getid_reources(namebd, idresbooked);
                
                Secretary id_find = (Secretary) lstown.get(0);
                int id_find2 = id_find.getIdSec();

                Owner owner2 = ServicesBD.getidOwner_type(owner);
                ServicesBD.recbooking_office(date_begin, date_end, namebd, id_find2, owner2);
            }

            if ("Hostess".equals(namebd)) {
                List<Object> lstown = ServicesBD.getid_reources(namebd, idresbooked);
                
                Hostess id_find = (Hostess) lstown.get(0);
                int id_find2 = id_find.getIdHos();

                Owner owner2 = ServicesBD.getidOwner_type(owner);
                ServicesBD.recbooking_office(date_begin, date_end, namebd, id_find2, owner2);
            }
     

        } finally {
            out.close();
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
