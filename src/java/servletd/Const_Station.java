/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package servletd;

import Fonctions.service_bd;
import Work.Delivery;
import Work.Fal;
import Work.Section;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Kenza
 */
public class Const_Station extends HttpServlet {

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

        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String idstat = request.getParameter("idserv");
        String namestat = request.getParameter("namstat");
        int iddays = Integer.parseInt(request.getParameter("n_days"));

        try {

            service_bd.Maj_stat(idstat, namestat, iddays);


            List<Section> listserv = service_bd.getSection();
            List<Fal> listfal = service_bd.getFal();
            List<Delivery> listdel = service_bd.getDelivery();
            Section valS;
            Delivery valD;
            Fal valF;

            String content = "<table cellpadding=\"8\"><tr><td valign = \"top\">";


            content += "<table border = 1 cellpadding=\"8\" ><tr bgcolor=\"#333367\" >"
                    + "<td colspan = 2 align=\"center\" class=\"titlebox12white\">SECTION STEP</td></tr>";
            content += "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">STEP NAME</td>"
                    + "<td align=\"center\" class=\"titlebox12white\">DAYS</td></tr>";
            for (int i = 0; i < listserv.size(); i++) {
                valS =
                        listserv.get(i);
                content += "<tr><td>" + valS.getNameS()
                        + "</td>" + "<td align=\"center\">" + valS.getDaysS() + "</td></tr>";
            }

            content += "</table>";
            content += "</td><td valign = \"top\">";


            content += "<table border = 1 cellpadding=\"8\"><tr bgcolor=\"#333367\" >"
                    + "<td colspan = 2 align=\"center\" class=\"titlebox12white\">FAL STEP</td></tr>";
            content += "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">STEP NAME</td>"
                    + "<td align=\"center\" class=\"titlebox12white\">DAYS</td></tr>";
            for (int i = 0; i < listfal.size(); i++) {
                valF = listfal.get(i);
                content += "<tr><td>" + valF.getNameF()
                        + "</td>" + "<td align=\"center\">" + valF.getDaysF() + "</td></tr>";
            }

            content += "</table>";
            content += "</td><td valign = \"top\">";
            content += "<table border = 1 cellpadding=\"8\"><tr bgcolor=\"#333367\" >"
                    + "<td colspan = 2 align=\"center\" class=\"titlebox12white\">DELIVERY STEP</td></tr>";
            content += "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">STEP NAME</td>"
                    + "<td align=\"center\" class=\"titlebox12white\">DAYS</td></tr>";

            for (int i = 0; i < listdel.size(); i++) {
                valD = listdel.get(i);
                content += "<tr><td>" + valD.getNameD() + "</td>" + "<td align=\"center\">"
                        + valD.getDaysD() + "</td></tr>";
            }


            content += "</table>";
            content += "</td></tr>";

            content += "</table>";
            out.println(content);


        } finally {
            out.close();
        }


    }   // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

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
