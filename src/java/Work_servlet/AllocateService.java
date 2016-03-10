/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

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
 * @author Khadija
 */
public class AllocateService extends HttpServlet {

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

        
        //this servlet allow to delete a resource
        List<Object[]> lstservices = ServicesBD.serviceselondate2(name, idloc);
        if ("Secretary".equals(name)) {
            String content = "<br/><table class=\"sizetable\" border=\"1\">"
                    + "<tr bgcolor=\"#6593b5\"><td class=\"titlebox12white\">First Name</td>"
                    + "<td class=\"titlebox12white\">Last Name</td>"
                    + "<td class=\"titlebox12white\">Phone</td>"
                    + "<td class=\"titlebox12white\">Mobile</td><td class=\"titlebox12white\">Delete</td></tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "</td>"
                            + "<td>" + row[1] + "</td>"
                            + "<td>" + row[2] + "</td>"
                            + "<td>" + row[3] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[4] + "\" "
                            + "name=\"" + row[4] + "\" value=\"Delete\" onclick=\"deleteStoune('" + row[4] + "','" + name + "')\"/></td>"
                            + "</tr>";
                }


            } else {
                content += "<tr><td align=\"center\" colspan=\"5\">NO AVAILABILITIES</td></tr>";
            }
            content += "</table>";
            out.println(content);
        }

        if ("Hostess".equals(name)) {
       String content = "<br/><table class=\"sizetable\" border=\"1\">"
                    + "<tr bgcolor=\"#6593b5\"><td class=\"titlebox12white\">First Name</td>"
                    + "<td class=\"titlebox12white\">Last Name</td>"
                    + "<td class=\"titlebox12white\">Phone</td>"
                    + "<td class=\"titlebox12white\">Mobile</td><td class=\"titlebox12white\">Delete</td></tr>";

            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "</td>"
                            + "<td>" + row[1] + "</td>"
                            + "<td>" + row[2] + "</td>"
                            + "<td>" + row[3] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[4] + "\" "
                            + "name=\"" + row[4] + "\" value=\"Delete\" onclick=\"deleteStoune('" + row[4] + "','" + name + "')\"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<tr><td align=\"center\" colspan=\"5\">NO AVAILABILITIES</td></tr>";
            }

            content += "</table>";
            out.println(content);
        }

        if ("Car".equals(name)) {
            String content =
                    "<br/><table class=\"sizetable2\" border=\"1\"><tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Brand</td>"
                    + "<td class=\"titlebox12white\">Model</td>"
                    + "<td class=\"titlebox12white\">Registration</td><td class=\"titlebox12white\">Delete</td></tr>";
            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "</td>"
                            + "<td>" + row[1] + "</td>"
                            + "<td>" + row[2] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[3] + "\" "
                            + "name=\"" + row[3] + "\" value=\"Delete\" onclick=\"deleteStoune('" + row[3] + "','" + name + "')\"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<tr><td align=\"center\" colspan=\"4\">NO AVAILABILITIES</td></tr>";
            }

            content += "</table>";
            out.println(content);
        }

        if ("Office".equals(name)) {
            String content = "<br/><table class=\"sizetable2\" border=\"1\"><tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Building</td>"
                    + "<td class=\"titlebox12white\">Delete</td></tr>";
            if (!lstservices.isEmpty()) {
                for (Object[] row : lstservices) {
                    content += "<tr><td>" + row[0] + "</td>"
                            + "<td><input type=\"button\" id=\"" + row[1] + "\" "
                            + "name=\"" + row[1] + "\" value=\"Delete\" onclick=\"deleteStoune('" + row[1] + "','" + name + "')\"/></td>"
                            + "</tr>";
                }
            } else {
                content += "<tr><td align=\"center\" colspan=\"2\">NO AVAILABILITIES</td></tr>";
            }

            content += "</table>";
            
            out.println(content);
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
