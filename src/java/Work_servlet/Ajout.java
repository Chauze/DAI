/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Khadija
 */
public class Ajout extends HttpServlet {

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

        String name = request.getParameter("nameserv");

        //this servlet allow to create the form oor adding a resource
        if ("Secretary".equals(name)) {

            String content =
                    "<br/><form id='form_check' name='form1'>"
                    + "<table border='1' cellpadding='6'>"
                    + "<tr>"
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">First Name :</td>"
                    + "<td><input type='text' name='nameC' id='iname'></td>"
                    + "</tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\" >Last Name : </td>"
                    + "<td><input type='text' name='last' id='ilast'></td>"
                    + " </tr>"
                    + "<tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\" >Phone : </td>"
                    + " <td><input type='text' name='phone' id='iphone'></td>"
                    + " </tr>"
                    + "<tr> "
                    + " <td bgcolor=\"#6593b5\"  class=\"titlebox12white\" >Fax : </td>"
                    + " <td><input type='text' name='fax' id='ifax'></td>"
                    + " </tr>"
                    + "<tr> "
                    + " <td  bgcolor=\"#6593b5\"  class=\"titlebox12white\" >Mobile : </td>"
                    + " <td><input type='text' name='mob' id='imob'></td>"
                    + " </tr>"
                    + "<tr > "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\" >Email : </td>"
                    + " <td><input type='text' name='mail' id='imail'></td>"
                    + " </tr>"
                    + "</table>"
                    + " <input type='button'  value='Add' onclick= 'processSEC() & hide2()'>"
                    + "</form>";

            out.println(content);

        }

         if ("Hostess".equals(name)) {

            String content =
                    "<form id='form_check' name='form1'  >"
                    + "<table border='1' cellpadding='6'>"
                    + "<tr>"
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">First Name :</td>"
                    + "<td><input type='text' name='nameC' id='iname'></td>"
                    + "</tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Last Name : </td>"
                    + "<td><input type='text' name='last' id='ilast'></td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Phone : </td>"
                    + "<td><input type='text' name='phone' id='iphone'></td>"
                    + "</tr>"
                    + "<tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\">Fax : </td>"
                    + " <td><input type='text' name='fax' id='ifax'></td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Mobile : </td>"
                    + " <td><input type='text' name='mob' id='imob'></td>"
                    + " </tr>"
                    + "<tr> "
                    + "<td bgcolor=\"#6593b5\" class=\"titlebox12white\">Email : </td>"
                    + " <td><input type='text' name='mail' id='imail'></td>"
                    + " </tr>"
                    + "</table>"
                    + " <input type='button'  value='Add' onclick= 'processSEC() & hide2() '>"
                    + "</form>";

            out.println(content);

        }

         
        if ("Car".equals(name)) {
            String content =
                    "<form name='form1'>"
                    + "<table cellpadding='6' border='1'>"
                    + " <tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\">Registration :</td>"
                    + "<td><input type='text' name='nameC' id='iname'></td>"
                    + "  </tr>"
                    + " <tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\">Model :</td>"
                    + "<td><input type='text' name='model' id='imodel'></td>"
                    + "  </tr>"
                    + " <tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\">Brand :</td>"
                    + "<td><input type='text' name='brand' id='ibrand'></td>"
                    + "  </tr>"
                    + "</table>"
                    + " <input type='button'  value='Add' onclick= 'processCAR() & hide2()'>"
                    + "</form>";
            out.println(content);
        }

        if ("Office".equals(name)) {
            String content =
                    "<form name='form1' '>"
                    + "<table border='1'>"
                    + " <tr> "
                    + " <td bgcolor=\"#6593b5\" class=\"titlebox12white\">Building :</td>"
                    + "<td><input type='text' name='nameC' id='iname'></td>"
                    + "  </tr>"
                    + "</table>"
                    + " <input type='button'  value='Add' onclick='processOFF() & hide2()'>"
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
