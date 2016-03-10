/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Hib_util.HibernateUtil_airbus;
import Work.*;
import Work_define.ServicesBD;
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
public class Update extends HttpServlet {

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

        //this servlet allow to save the resource added

        int numberS = Integer.parseInt(request.getParameter("idserv"));
        String nameS = request.getParameter("nameserv");
        String nameC = request.getParameter("nameC");
        int numberL = Integer.parseInt(request.getParameter("idloc"));

        int numberC;

        Location loc;
        List<Location> lstQteCar = ServicesBD.getidloc2(numberL);
        loc = (Location) lstQteCar.get(0);

        Services loce;
        List<Services> lstQteCare = ServicesBD.getidServi2(numberS);
        loce = (Services) lstQteCare.get(0);



        if ("Secretary".equals(nameS)) {
            numberC = ServicesBD.last_id("Secretary");
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            String last = request.getParameter("last");
            String phone = request.getParameter("phone");
            String fax = request.getParameter("fax");
            String mobile = request.getParameter("mob");
            String mail = request.getParameter("mail");
            String status = "free";
            Secretary nvSec = new Secretary();
            nvSec.setIdSec(numberC);
            nvSec.setLocation(loc);
            nvSec.setServices(loce);
            nvSec.setFirstNameSec(nameC);
            nvSec.setLastNameSec(last);
            nvSec.setPhoneSec(phone);
            nvSec.setFaxSec(fax);
            nvSec.setMobileSec(mobile);
            nvSec.setEmailSec(mail);
            nvSec.setStatusSec(status);
            sh.save(nvSec);
            sh.getTransaction().commit();
            String content = "<form name='form2'>"
                    + "<table border='1' class=\"sizetable2\" cellpadding='6'>"
                    + "<tr align=\"center\" bgcolor=\"#333367\"><td colspan=\"2\" "
                    + "class=\"titlebox12white\">RECAP</td></tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">IDSecretary : </td>"
                    + " <td>" + numberC + "</td>"
                    + " </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">First Name :</td>"
                    + "<td>" + nameC + "</td>"
                    + "  </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Last Name : </td>"
                    + " <td >" + last + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Phone : </td>"
                    + " <td >" + phone + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Fax : </td>"
                    + " <td >" + fax + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Mobile : </td>"
                    + " <td >" + mobile + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Email : </td>"
                    + " <td >" + mail + "</td>"
                    + " </tr>"
                    + "</table>"
                    + "<br><br>"
                    + "</form>";

            out.println(content);
        }

        if ("Hostess".equals(nameS)) {
            numberC = ServicesBD.last_id("Hostess");
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            String last = request.getParameter("last");
            String phone = request.getParameter("phone");
            String fax = request.getParameter("fax");
            String mobile = request.getParameter("mob");
            String mail = request.getParameter("mail");
            String status = "free";

            Hostess nvSec = new Hostess();
            nvSec.setIdHos(numberC);
            nvSec.setLocation(loc);
            nvSec.setServices(loce);
            nvSec.setFirstNameHos(nameC);
            nvSec.setLastNameHos(last);
            nvSec.setPhoneHos(phone);
            nvSec.setFaxHos(fax);
            nvSec.setMobileHos(mobile);
            nvSec.setEmailHos(mail);
            nvSec.setStatusHos(status);
            sh.save(nvSec);
            sh.getTransaction().commit();
           String content = "<form name='form2'>"
                    + "<table border='1' class=\"sizetable2\" cellpadding='6'>"
                    + "<tr align=\"center\" bgcolor=\"#333367\"><td colspan=\"2\" "
                    + "class=\"titlebox12white\">RECAP</td></tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">IDSecretary : </td>"
                    + " <td>" + numberC + "</td>"
                    + " </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">First Name :</td>"
                    + "<td>" + nameC + "</td>"
                    + "  </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Last Name : </td>"
                    + " <td >" + last + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Phone : </td>"
                    + " <td >" + phone + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Fax : </td>"
                    + " <td >" + fax + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Mobile : </td>"
                    + " <td >" + mobile + "</td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Email : </td>"
                    + " <td >" + mail + "</td>"
                    + " </tr>"
                    + "</table>"
                    + "<br><br>"
                    + "</form>";

            out.println(content);

        }

        if ("Office".equals(nameS)) {
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();
            numberC = ServicesBD.last_id("Office");
            String status = "free";
            Office nvOff = new Office();
            nvOff.setCodeO(numberC);
            nvOff.setLocation(loc);
            nvOff.setServices(loce);
            nvOff.setBuilding(nameC);
            nvOff.setStatusOff(status);
            sh.save(nvOff);
            sh.getTransaction().commit();
           String content = "<form name='form2'>"
                    + "<table border='1' class=\"sizetable2\" cellpadding='6'>"
                    + "<tr align=\"center\" bgcolor=\"#333367\"><td colspan=\"2\" "
                    + "class=\"titlebox12white\">RECAP</td></tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">IDOffice : </td>"
                    + " <td >" + numberC + "</td>"
                    + " </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Building :</td>"
                    + "<td>" + nameC + "</td>"
                    + "  </tr>"
                    + "</table>"
                    + "<br><br>"
                    + "</form>";

            out.println(content);


        }


        if ("Car".equals(nameS)) {
            numberC = ServicesBD.last_id(nameS);
            Session sh = HibernateUtil_airbus.getSessionFactory().getCurrentSession();
            sh.beginTransaction();

            String status = "free";
            String model = request.getParameter("model");
            String brand = request.getParameter("brand");


            Car nvCar = new Car();
            nvCar.setIdC(numberC);
            nvCar.setLocation(loc);
            nvCar.setServices(loce);
            nvCar.setRegistration(nameC);
            nvCar.setModel(model);
            nvCar.setBrand(brand);
            nvCar.setStatusCar(status);
            sh.save(nvCar);
            sh.getTransaction().commit();

            String content = "<form name='form2'>"
                    + "<table border='1' class=\"sizetable2\" cellpadding='6'>"
                    + "<tr align=\"center\" bgcolor=\"#333367\"><td colspan=\"2\" "
                    + "class=\"titlebox12white\">RECAP</td></tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">IDCar : </td>"
                    + " <td >" + numberC + "</td>"
                    + " </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Registration :</td>"
                    + "<td>" + nameC + "</td>"
                    + "  </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Model :</td>"
                    + "<td>" + model + "</td>"
                    + "  </tr>"
                    + " <tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Brand :</td>"
                    + "<td>" + brand + "</td>"
                    + "  </tr>"
                    + "</table>"
                    + "<br><br>"
                    + "</form>";
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
