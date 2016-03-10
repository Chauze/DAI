/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Work_define.ServicesBD;
import Work_define.changeformat_date;
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
public class Allocate_services extends HttpServlet {

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

        int idloc = Integer.parseInt(request.getParameter("locat"));
        String name = request.getParameter("nameserv");

        changeformat_date datechange = new changeformat_date();
        String date_begin = datechange.change_date(request.getParameter("date_begin"));
        String date_end = datechange.change_date(request.getParameter("date_end"));
        String content = "";

        //this servlet allow to get the list of available resource according to a service, location, interval of date
        
        List<Object[]> lstservices = ServicesBD.serviceselondate(name, idloc, date_begin, date_end);
        if ("Secretary".equals(name)) {
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">SECRETARY</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Name</td>"
                    + "<td class=\"titlebox12white\">Phone-Mobile</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                            + "<td>" + row[2] + "<br/>" + row[3] + "</td>"
                            + "<td><input type=\"button\""
                            + " value=\"Add\" onclick=\"bookadd('" + row[4] + "')\"/></td><tr>";
                }
            } else {
                content += "<td align=\"center\" colspan=\"3\">NO AVAILABILITIES</td>";
            }
            content += "</table>";

        }

        if ("Car".equals(name)) {
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"4\" class=\"titlebox12white\">CAR</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Brand</td>"
                    + "<td class=\"titlebox12white\">Model</td>"
                    + "<td class=\"titlebox12white\">Registration</td>"
                    + "<td class=\"titlebox12white\">Cancel</td>"
                    + "</tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "</td>"
                            + "<td>" + row[1] + "</td>"
                            + "<td>" + row[2] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[3] + "\" "
                            + " value=\"Add\" onclick=\"bookadd('" + row[3] + "')\"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<td align=\"center\" colspan=\"3\">NO AVAILABILITIES</td>";
            }
            content += "</table>";

        }

        if ("Office".equals(name)) {
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">OFFICE</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Building</td>"
                    + "<td class=\"titlebox12white\">Allocate</td>"
                    + "</tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + row[1] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[1] + "\" "
                            + " value=\"Add\" onclick=\"bookadd('" + row[1] + "') \"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<td align=\"center\" colspan=\"3\">NO AVAILABILITIES</td>";
            }
            content += "</table>";

        }

        if ("Hostess".equals(name)) {
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">HOTESS</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Name</td>"
                    + "<td class=\"titlebox12white\">Phone-Mobile</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                            + "<td>" + row[2] + "<br/>" + row[3] + "</td>"
                            + "<td><input type=\"button\""
                            + " value=\"Add\" onclick=\"bookadd('" + row[4] + "')\"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<td align=\"center\" colspan=\"3\">NO AVAILABILITIES</td>";
            }
            content += "</table>";

        }

        out.println(content);

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
