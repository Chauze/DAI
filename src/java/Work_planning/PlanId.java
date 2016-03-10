/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Hib_util.HibernateUtil_airbus;
import Work.Aircraft;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;

public class PlanId extends HttpServlet {

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
        int air = Integer.parseInt(request.getParameter("num"));
        String ty = request.getParameter("type");
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();

        //this servlet allow to the list of aicraft according to the owner and an aircraft type

        String content = "<table class=\"sizetable3\" border=1><tr bgcolor=\"#333367\">"
                + "<td class=\"titlebox12white\">OWNER</td>"
                + "<td class=\"titlebox12white\">TYPE</td>"
                + "<td class=\"titlebox12white\">MSN</td>"
                + "<td class=\"titlebox12white\">SECTION</td>"
                + "<td class=\"titlebox12white\">FAL</td>"
                + "<td class=\"titlebox12white\">DELIVERY</td>"
                + "</tr>";

        //check if the owner and aircraft type have been defined
        if (air != 0 && !ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachComb(air, ty);


            for (int i = 0; i < ow.size(); i++) {
                String owner = ow.get(i).getOwner().getFullName();
                String type = ow.get(i).getAircraftType();
                int msn = ow.get(i).getMsn();

                content += "<tr>"
                        + "<td>" + owner + "</td>"
                        + "<td>" + type + "</td>"
                        + "<td>" + msn + "</td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processSect('" + msn + "','tab" + i + "')\"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processXML('" + msn + "','tab" + i + "') \"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processDel('" + msn + "','tab" + i + "') "
                        + "\"></td></tr>"
                        + "<tr >"
                        + "<td bgcolor=\"#333367\" class=\"sizetable5\" colspan='6'>"
                        + "<div id='tab" + i + "'  name='detail' ><div>"
                        + "</td></tr>";
            }
            content += "</table>";
            out.println(content);


        }
        if (air != 0 && ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachIcao(air);

            for (int i = 0; i < ow.size(); i++) {

                String owner = ow.get(i).getOwner().getFullName();
                String type = ow.get(i).getAircraftType();
                int msn = ow.get(i).getMsn();

                content += "<tr>"
                        + "<td>" + owner + "</td>"
                        + "<td>" + type + "</td>"
                        + "<td>" + msn + "</td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processSect('" + msn + "','tab" + i + "')\"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processXML('" + msn + "','tab" + i + "')\"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processDel('" + msn + "','tab" + i + "') "
                        + "\"></td></tr>"
                        + "<tr><td colspan='6'><div id='tab" + i + "'   name='detail' ><div></td></tr>";
            }
            content += "</table>";
            out.println(content);

        }

        if (air == 0 && !ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachDetail(ty);


            for (int i = 0; i < ow.size(); i++) {

                String owner = ow.get(i).getOwner().getFullName();
                String type = ow.get(i).getAircraftType();
                int msn = ow.get(i).getMsn();


                content += "<tr>"
                        + "<td>" + owner + "</td>"
                        + "<td>" + type + "</td>"
                        + "<td>" + msn + "</td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processSect('" + msn + "','tab" + i + "')\"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processXML('" + msn + "','tab" + i + "')\"></td>"
                        + "<td><input type ='button' value='Detail' onclick =\"processDel('" + msn + "','tab" + i + "') "
                        + "\"></td></tr>"
                        + "<tr><td colspan='6'><div id='tab" + i + "'  name='detail' ><div></td></tr>";
            }
            content += "</table>";
            out.println(content);


        }

        if (air == 0 && ty.isEmpty()) {

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
