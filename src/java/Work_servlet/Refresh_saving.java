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
public class Refresh_saving extends HttpServlet {

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

        try {
            String owner = request.getParameter("own");
            
            Integer idowwn = ServicesBD.getidOwner(owner);
            List<Object[]> lstsecret = ServicesBD.listbooking("Secretary", idowwn);
            List<Object[]> lstoffice = ServicesBD.listbooking("Office", idowwn);
            List<Object[]> lstcar = ServicesBD.listbooking("Car", idowwn);
            List<Object[]> lsthos = ServicesBD.listbooking("Hostess", idowwn);

            changeformat_date reverse_date = new changeformat_date();

            //CAR
            String content = "<table class=\"sizetable\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"5\" class=\"titlebox12white\">CAR</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Brand</td>"
                    + "<td class=\"titlebox12white\">Model</td>"
                    + "<td class=\"titlebox12white\">Registration</td>"
                    + "<td class=\"titlebox12white\">From...to</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            for (Object[] row : lstcar) {
                String disable = "";
                String var_status= row[6].toString();
                if ("inprogress".equals(row[6].toString())) {
                    content += "<TR bgcolor=\"#FAAC58\">";
                    disable = "disabled";
                } else if ("plan".equals(row[6].toString())) {
                    content += "<tr bgcolor=\"#C3E3FA\" >";
                } else {
                    content += "<tr>";
                }
            
                String end = reverse_date.change_date_reverse(row[4].toString());
                content += "<td>" + row[0] + "</td>"
                        + "<td>" + row[1] + "</td>"
                        + "<td>" + row[2] + "</td>"
                        + "<td>" + reverse_date.change_date_reverse(row[3].toString()) + "<br/>" + end + "</td>"
                        + "<td><input type=\"button\" id=\"" + row[5] + "\" "
                        + "name=\"" + row[5] + "\" value=\"Remove\" " + disable + ""
                        + " onclick=\"bookremove('" + row[5] + "','" + owner + "', 'Car','"+var_status+"','"+end+"')\"/></td>"
                        + "</tr>";
            }

            content += "</table><br/>";

            
            //HOSTESS
            content += "<table class=\"sizetable\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"4\" class=\"titlebox12white\">HOSTESS</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Name</td>"
                    + "<td class=\"titlebox12white\">Phone & Mobile</td>"
                    + "<td class=\"titlebox12white\">From...to</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            for (Object[] row : lsthos) {
                String disable = "";
                String var_status= row[7].toString();
                if ("inprogress".equals(row[7].toString())) {
                    content += "<TR bgcolor=\"#FAAC58\">";
                    disable = "disabled";
                } else if ("plan".equals(row[7].toString())) {
                    content += "<tr bgcolor=\"#C3E3FA\" >";
                } else {
                    content += "<tr>";
                }

                 String end = reverse_date.change_date_reverse(row[5].toString());
                content += "<td>" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                        + "<td>" + row[2] + "<br/>" + row[3] + "</td>"
                        + "<td>" + reverse_date.change_date_reverse(row[4].toString())
                        + "<br/>" + end + "</td>"
                        + "<td><input type=\"button\" id=\"" + row[6] + "\" "
                        + "name=\"" + row[6] + "\" value=\"Remove\" " + disable + ""
                        + " onclick=\"bookremove('" + row[6] + "','" + owner + "', 'Hostess','"+var_status+"','"+end+"')\"/></td>"
                        + "</tr>";
            }
            content += "</table><br/>";


            
            //OFFICE
            content += "<table class=\"sizetable\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">OFFICE</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Building</td>"
                    + "<td class=\"titlebox12white\">From...to</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            for (Object[] row : lstoffice) {
                String disable = "";
                String var_status= row[4].toString();
                if ("inprogress".equals(row[4].toString())) {
                    content += "<TR bgcolor=\"#FAAC58\">";
                    disable = "disabled";
                } else if ("plan".equals(row[4].toString())) {
                    content += "<tr bgcolor=\"#C3E3FA\" >";
                } else {
                    content += "<tr>";
                }

                String end = reverse_date.change_date_reverse(row[2].toString());
                content += "<td>" + row[0] + row[3] + "</td>"
                        + "<td>" + reverse_date.change_date_reverse(row[1].toString())
                        + "<br/>" + end + "</td>"
                        + "<td><input type=\"button\" id=\"" + row[3] + "\" "
                        + "name=\"" + row[3] + "\" value=\"Remove\" " + disable + ""
                        + " onclick=\"bookremove('" + row[3] + "','" + owner + "', 'Office','"+var_status+"','"+end+"')\"/></td>"
                        + "</tr>";
            }
            content += "</table><br/>";

            
            //SECRETARY
            content += "<table class=\"sizetable\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"4\" class=\"titlebox12white\">SECRETARY</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Name</td>"
                    + "<td class=\"titlebox12white\">Phone & Mobile</td>"
                    + "<td class=\"titlebox12white\">From...to</td>"
                    + "<td class=\"titlebox12white\">Cancel</td></tr>";

            for (Object[] row : lstsecret) {
                String disable = "";
                String var_status= row[7].toString();
                if ("inprogress".equals(row[7].toString())) {
                    content += "<TR bgcolor=\"#FAAC58\">";
                    disable = "disabled";
                } else if ("plan".equals(row[7].toString())) {
                    content += "<tr bgcolor=\"#C3E3FA\" >";
                } else {
                    content += "<tr>";
                }

                  String end = reverse_date.change_date_reverse(row[5].toString());
                content += "<td>" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                        + "<td>" + row[2] + "<br/>" + row[3] + "</td>"
                        + "<td>" + reverse_date.change_date_reverse(row[4].toString())
                        + "<br/>" + end + "</td>"
                        + "<td><input type=\"button\" id=\"" + row[6] + "\" "
                        + "name=\"" + row[6] + "\" value=\"Remove\" " + disable + ""
                        + " onclick=\"bookremove('" + row[6] + "','" + owner + "', 'Secretary','"+var_status+"','"+end+"')\"/></td>"
                        + "</tr>";
            }
            content += "</table>";

            out.println(content);


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
