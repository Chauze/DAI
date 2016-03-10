/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Hib_util.HibernateUtil_airbus;
import Work.*;
import Work_define.changeformat_date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;
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
public class Service_availability extends HttpServlet {

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


        //this servlet allow to get the availablity of a resource
        Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
        sh.beginTransaction();


        String idres = request.getParameter("idres");
        String serv = request.getParameter("serv");
        String loc = request.getParameter("loc");
        changeformat_date reverse_date = new changeformat_date();
        String content = null;

        if ("Secretary".equals(serv)) {
            Query q = sh.createQuery("from Secretary as s where s.statusSec!='blocked' "
                    + "and s.idSec=" + idres + " and s.location=" + loc);


            List<Secretary> Sec = (List<Secretary>) q.list();
            Set<AllocateS> listAldl = Sec.get(0).getAllocateSs();
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">"
                    + Sec.get(0).getFirstNameSec() + " - " + Sec.get(0).getLastNameSec().toUpperCase() + "</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Customer</td>"
                    + "<td class=\"titlebox12white\">From</td>"
                    + "<td class=\"titlebox12white\">To</td></tr>";


            if (!Sec.isEmpty()) {
                if (!listAldl.isEmpty()) {
                    for (AllocateS allocateS : listAldl) {
                        if ("inprogress".equals(allocateS.getStatusS())) {
                            content += "<TR bgcolor=\"#FAAC58\">";

                        } else if ("plan".equals(allocateS.getStatusS())) {
                            content += "<tr bgcolor=\"#C3E3FA\" >";

                        } else {
                            content += "<tr>";
                        }


                        content += "<td>" + allocateS.getOwner().getFullName() + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getId().getDateStartS().toString()) + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getDateEndS().toString()) + "</td>"
                                + "</tr>";

                    }
                } else {
                    content += "<tr><td align=\"center\" colspan=\"3\">NO ASSIGNEMENTS</td></tr>";
                }
            }

            content += "</tr>";

            content += "</table>";
        }

        if ("Hostess".equals(serv)) {
            Query q = sh.createQuery("from Hostess as s where s.statusHos!='blocked' "
                    + "and s.idHos=" + idres + " and s.location=" + loc);


            List<Hostess> Sec = (List<Hostess>) q.list();
            Set<AllocateH> listAldl = Sec.get(0).getAllocateHs();
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">"
                    + Sec.get(0).getFirstNameHos() + " - " + Sec.get(0).getLastNameHos().toUpperCase() + "</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Customer</td>"
                    + "<td class=\"titlebox12white\">From</td>"
                    + "<td class=\"titlebox12white\">To</td></tr>";


            if (!Sec.isEmpty()) {
                if (!listAldl.isEmpty()) {
                    for (AllocateH allocateS : listAldl) {
                        if ("inprogress".equals(allocateS.getStatusH())) {
                            content += "<TR bgcolor=\"#FAAC58\">";

                        } else if ("plan".equals(allocateS.getStatusH())) {
                            content += "<tr bgcolor=\"#C3E3FA\" >";

                        } else {
                            content += "<tr>";
                        }

                        content += "<td>" + allocateS.getOwner().getFullName() + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getId().getDateStartH().toString()) + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getDateEndH().toString()) + "</td>"
                                + "</tr>";

                    }
                } else {
                    content += "<tr><td align=\"center\" colspan=\"3\">NO ASSIGNEMENTS</td></tr>";
                }
            }

            content += "</tr>";

            content += "</table>";
        }

        if ("Car".equals(serv)) {
            Query q = sh.createQuery("from Car as s where s.statusCar!='blocked' "
                    + "and s.idC=" + idres + " and s.location=" + loc);

            List<Car> Sec = (List<Car>) q.list();
            Set<AllocateC> listAldl = Sec.get(0).getAllocateCs();
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">"
                    + Sec.get(0).getBrand() + " - " + Sec.get(0).getModel() + "</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Customer</td>"
                    + "<td class=\"titlebox12white\">From</td>"
                    + "<td class=\"titlebox12white\">To</td></tr>";


            if (!Sec.isEmpty()) {
                if (!listAldl.isEmpty()) {
                    for (AllocateC allocateS : listAldl) {
                        if ("inprogress".equals(allocateS.getStatusC())) {
                            content += "<TR bgcolor=\"#FAAC58\">";

                        } else if ("plan".equals(allocateS.getStatusC())) {
                            content += "<tr bgcolor=\"#C3E3FA\" >";

                        } else {
                            content += "<tr>";
                        }


                        content += "<td>" + allocateS.getOwner().getFullName() + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getId().getDateStartC().toString()) + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getDateEndC().toString()) + "</td>"
                                + "</tr>";

                    }
                } else {

                    content += "<tr><td align=\"center\" colspan=\"3\">NO ASSIGNEMENTS</td></tr>";
                }
            }

            content += "</tr>";

            content += "</table>";
        }

        if ("Office".equals(serv)) {
            Query q = sh.createQuery("from Office as s where s.statusOff!='blocked' "
                    + "and s.codeO=" + idres + " and s.location=" + loc);


            List<Office> Sec = (List<Office>) q.list();
            Set<AllocateO> listAldl = Sec.get(0).getAllocateOs();
            content = "<table class=\"sizetable2\" border=\"1\">"
                    + "<tr align=\"center\" bgcolor=\"#333367\">"
                    + "<td colspan=\"3\" class=\"titlebox12white\">"
                    + Sec.get(0).getBuilding() + "</td>"
                    + "</tr>"
                    + "<tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\">Customer</td>"
                    + "<td class=\"titlebox12white\">From</td>"
                    + "<td class=\"titlebox12white\">To</td></tr>";


            if (!Sec.isEmpty()) {
                if (!listAldl.isEmpty()) {
                    for (AllocateO allocateS : listAldl) {
                        if ("inprogress".equals(allocateS.getStatusO())) {
                            content += "<TR bgcolor=\"#FAAC58\">";

                        } else if ("plan".equals(allocateS.getStatusO())) {
                            content += "<tr bgcolor=\"#C3E3FA\" >";

                        } else {
                            content += "<tr>";
                        }


                        content += "<td>" + allocateS.getOwner().getFullName() + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getId().getDateStartO().toString()) + "</td>"
                                + "<td>" + reverse_date.change_date_reverse(allocateS.getDateEndO().toString()) + "</td>"
                                + "</tr>";

                    }
                } else {

                    content += "<tr><td align=\"center\" colspan=\"3\">NO ASSIGNEMENTS</td></tr>";
                }
            }

            content += "</tr>";

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
