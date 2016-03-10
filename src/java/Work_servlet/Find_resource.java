/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Hib_util.HibernateUtil_airbus;
import Work.Car;
import Work.Hostess;
import Work.Office;
import Work.Secretary;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Fast
 */
public class Find_resource extends HttpServlet {

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
        
        //this servlet allow to find a resource
        try {

            String name = request.getParameter("name");
            String services = request.getParameter("serv");
            String location = request.getParameter("loc");

            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            String content = "";
            if ("Secretary".equals(services)) {
                Query q = sh.createQuery("from Secretary as s where s.statusSec!='blocked' "
                        + "and (s.firstNameSec like '%" + name + "%' "
                        + "or s.lastNameSec like '%" + name + "%') and s.location=" + location);

                List<Secretary> lstown = (List<Secretary>) q.list();


                Secretary loc;
                content = "<div class=\"infoBulle\"><ul>";
                if (!lstown.isEmpty()) {
                    for (int i = 0; i < lstown.size(); i++) {
                        loc = (Secretary) lstown.get(i);
                        content += "<li><a id=\"id_secret\" name=\"" + loc.getIdSec() + "\" "
                                + "onclick=\"setfield('" + loc.getFirstNameSec() + " - " + loc.getLastNameSec().toUpperCase() + "',"
                                + "'" + loc.getIdSec() + "')\" >"
                                + "" + loc.getFirstNameSec() + "  - " + loc.getLastNameSec().toUpperCase() + "</a></li>";

                    }
                } else {
                    content += "<li>NO DATA FOUND</li></ul></div>";
                }
                content += "</ul></div>";

            }

            if ("Hostess".equals(services)) {
                Query q = sh.createQuery("from Hostess as s where s.statusHos!='blocked' "
                        + "and (s.firstNameHos like '%" + name + "%' "
                        + "or s.lastNameHos like '%" + name + "%') and s.location=" + location);

                List<Hostess> lstown = (List<Hostess>) q.list();

                Hostess loc;
                content = "<div class=\"infoBulle\"><ul>";
                if (!lstown.isEmpty()) {
                    for (int i = 0; i < lstown.size(); i++) {
                        loc = (Hostess) lstown.get(i);
                        content += "<li><a id=\"id_secret\" name=\"" + loc.getIdHos() + "\" "
                                + "onclick=\"setfield('" + loc.getFirstNameHos() + " - " + loc.getLastNameHos().toUpperCase() + "',"
                                + "'" + loc.getIdHos() + "')\" >"
                                + "" + loc.getFirstNameHos() + "  - " + loc.getLastNameHos().toUpperCase() + "</a></li>";

                    }
                } else {
                    content += "<li>NO DATA FOUND</li></ul></div>";
                }
                content += "</ul></div>";
            }

            if ("Office".equals(services)) {
                Query q = sh.createQuery("from Office as s where s.statusOff!='blocked' "
                        + "and (s.building like '%" + name + "%') and s.location=" + location);

                List<Office> lstown = (List<Office>) q.list();

                Office loc;
                content = "<div class=\"infoBulle\"><ul>";
                if (!lstown.isEmpty()) {
                    for (int i = 0; i < lstown.size(); i++) {
                        loc = (Office) lstown.get(i);
                        content += "<li><a id=\"id_secret\" name=\"" + loc.getCodeO() + "\" "
                                + "onclick=\"setfield('" + loc.getBuilding() + "',"
                                + "'" + loc.getCodeO() + "')\" >"
                                + "" + loc.getBuilding() + "</a></li>";

                    }
                } else {
                    content += "<li>NO DATA FOUND</li></ul></div>";
                }
                content += "</ul></div>";
            }

            if ("Car".equals(services)) {
                Query q = sh.createQuery("from Car as s where s.statusCar!='blocked' "
                        + "and (s.brand like '%" + name + "%' "
                        + "or s.model like '%" + name + "%') and s.location=" + location);

                List<Car> lstown = (List<Car>) q.list();

                Car loc;
                content = "<div class=\"infoBulle\"><ul>";
                if (!lstown.isEmpty()) {
                    for (int i = 0; i < lstown.size(); i++) {
                        loc = (Car) lstown.get(i);
                        content += "<li><a id=\"id_secret\" name=\"" + loc.getIdC() + "\" "
                                + "onclick=\"setfield('" + loc.getBrand() + " - " + loc.getModel() + "',"
                                + "'" + loc.getIdC() + "')\" >"
                                + "" + loc.getBrand() + "  - " + loc.getModel() + "</a></li>";

                    }
                } else {
                    content += "<li>NO DATA FOUND</li></ul></div>";
                }
                content += "</ul></div>";
            }
            out.print(content);
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
