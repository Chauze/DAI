/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Work.InspectSection;
import Work_define.changeformat_date;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PlanSec extends HttpServlet {

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
        int msn = Integer.parseInt(request.getParameter("msn"));
        String Del = "Section";

        
        
        
        //this servlet allow to get the list of step an the section phase
        List<InspectSection> ins;
        ins = PlanInspecBd.searchSE(msn);

        String content = "<table border= \"1\">"
                + " <tr bgcolor='#F69100' class=\"titlebox12white\" align='center' >"
                + "<td >Section</td></tr>";


        for (int i = 0; i < ins.size(); i++) {
            String nomfal = ins.get(i).getSection().getNameS();
            int idfal = ins.get(i).getSection().getIdS();

            Date datef = ins.get(i).getDateProdEnd();
            Date dated = ins.get(i).getDateProdStart();

            Date start = ins.get(i).getDateStartS();
            Date end = ins.get(i).getDateEndS();

            String loc = ins.get(i).getSection().getLocation().getNameL();
            String nom = ins.get(i).getInspector().getLastNameI();
            String prenom = ins.get(i).getInspector().getFirstNameI();
            String stat = ins.get(i).getStatusSect();
            String com = ins.get(i).getComments();


            changeformat_date datechange = new changeformat_date();
            String from, to, start_ins, end_ins;

            from = datechange.change_date_reverse(dated.toString());
            to = datechange.change_date_reverse(datef.toString());


            start_ins = datechange.change_date_reverse(start.toString());
            end_ins = datechange.change_date_reverse(end.toString());

            String mail = ins.get(i).getInspector().getEmailI();

            String typ_air = ins.get(i).getAircraft().getAircraftType();

            int idspec = ins.get(i).getInspector().getIdI();
            int idstep = ins.get(i).getSection().getIdS();

            String date_ins = "";
            if (ins.get(i).getDateIns() != null) {
                date_ins = ins.get(i).getDateIns().toString();
            }
            String date_mail = datechange.change_date_reverse(date_ins);


            content += "<tr><td><table class='sizetable3' border=4>"
                    + "<tr align=center >"
                    + "<td class=\"titlebox12white\" bgcolor=\"#333367\" colspan=6>" + nomfal + " (" + loc + ")</td>"
                    + "</tr><tr bgcolor=\"#6593b5\">"
                    + "<td class=\"titlebox12white\" >Production</td>"
                    + "<td class=\"titlebox12white\" >Inspection</td>"
                    + "<td class=\"titlebox12white\">Inspector</td>"
                    + "<td class=\"titlebox12white\" >Status</td>"
                    + "<td class=\"titlebox12white\">Comments</td>"
                    + "<td class=\"titlebox12white\" >Mail</td>"
                    + "</tr>"
                    + "<tr>"
                    + "<td width=\"10\">" + from + " <br/> " + to + "</td>";


            if ("Inspected".equals(stat)) {
                content += "<td><input size='10' type=text disabled=disabled id=\"sta" + i + "\" value='" + start_ins + "'>"
                        + "<br/><input size='10'  disabled=disabled type=text id=\"end" + i + "\" value='" + end_ins + "'></td>"
                        + "<td>" + nom + "<br/>" + prenom + "</td>"
                        + "<td>Inspected</td>"
                        + "<td><textarea  disabled =disabled name = \"com\" id=\"com" + i + "\">" + com + "</textarea></td>"
                        + "<td><form name=\"form2\" method=\"post\" action=\"\">"
                        + "Sent on " + date_mail + ""
                        + " </form></td></tr>";
            }


            if (!"Inspected".equals(stat)) {
                content += "<form name=\"form3\">"
                        + "<td><input size='10' type=text id=\"sta" + i + "\" value=" + start_ins + "></br>"
                        + "<input size='10'  type=text id=\"end" + i + "\" value=" + end_ins + "><br/>"
                        + "<input type='button' onclick= \"updateDa('sta" + i + "','end" + i + "','" + Del + "','" + idfal + "','" + msn + "')\" value='update'></form>"
                        + "</td>"
                        + "<td>" + nom + "<br/>" + prenom + "</td>"
                        + "<td><select id=\"select" + i + "\"><option>---</option>"
                        + "<option>Inspected</option>"
                        + "<option>Not inspected</option></select></td>"
                        + "<form name=\"form1\"  >"
                        + "<td ><textarea  name = \"com\" id=\"com" + i + "\"></textarea><br/>"
                        + "<br/><input type='button'  value='ok' onclick= \"updateCom('select" + i + "','com" + i + "','" + Del + "','" + idfal + "','" + msn + "')\">"
                        + "</form></td><td>";
                if (!"".equals(date_ins)) {
                    content += "Sent on " + date_mail + "<br/>";
                }
                
                //allow to send email thanks to outlook
                content += "<input type=\"button\" onclick=\"emailFormb('" + nom + "','" + prenom + "','" + mail + "','" + start_ins + "','" + end_ins + "',"
                        + "'" + msn + "','" + loc + "','" + typ_air + "','" + nomfal + "','" + idspec + "','" + idstep + "','" + Del + "')\" value=\"SEND MAIL\"></td>"
                        + "</tr>";
            }

            content += "</tr></table></td>";
        }

        content += "</td></tr></table>";
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
