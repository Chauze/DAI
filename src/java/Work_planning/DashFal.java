/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_planning;

import Work.Aircraft;
import Work.InspectDeliv;
import Work.InspectFal;
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

/**
 *
 * @author Fast
 */
public class DashFal extends HttpServlet {

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

        String ty = request.getParameter("type");
        int air = Integer.parseInt(request.getParameter("num"));
        String begin = request.getParameter("start");
        String dend = request.getParameter("end");

        changeformat_date datechange = new changeformat_date();
        String dateS = datechange.change_date(begin);
        String dateE = datechange.change_date(dend);

        String content = "<table cellpadding=5 border=1><tr bgcolor=\"#333367\">"
                + "<td class=\"titlebox12white\">owner</td>"
                + "<td class=\"titlebox12white\">operator</td>"
                + "<td class=\"titlebox12white\">aircraft</td>"
                + "<td class=\"titlebox12white\">msn</td>"
                + "<td class=\"titlebox12white\">phase type</td>"
                + "<td class=\"titlebox12white\">STEP</td>"
                + "<td class=\"titlebox12white\">From..to</td>"
                + "<td class=\"titlebox12white\">mail send</td>"
                + "<td class=\"titlebox12white\">inspected</td>"
                + "<td class=\"titlebox12white\">inspector</td>"
                + "<td class=\"titlebox12white\">Com's</td>"
                + "</tr>";

        //check if the customer and the aircraft type have been selected.
        if (air != 0 && !ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachComb(air, ty);
            for (int i = 0; i < ow.size(); i++) {

                int msn = ow.get(i).getMsn();


                List<InspectFal> ins;
                ins = PlanInspecBd.searchF(msn, dateS, dateE);

                List<InspectSection> ins1;
                ins1 = PlanInspecBd.searchS(msn, dateS, dateE);

                List<InspectDeliv> ins2;
                ins2 = PlanInspecBd.searchD(msn, dateS, dateE);

                int nbre = ins.size() + ins1.size() + ins2.size();


                content += "<tr>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getIcaoCode() + " </td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getOwner().getIcaoCode() + "</td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getAircraftType() + "</td>"
                        + "<td rowspan=" + nbre + ">" + msn + "</td>"
                        + "<td rowspan=" + ins1.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Section</td>";

                for (int z = 0; z < ins1.size(); z++) {
                    String nomdel = ins1.get(z).getSection().getNameS();

                    Date start = ins1.get(z).getDateStartS();
                    Date end = ins1.get(z).getDateEndS();
                    String nom = ins1.get(z).getInspector().getLastNameI();
                    String prenom = ins1.get(z).getInspector().getFirstNameI();
                    String stat = ins1.get(z).getStatusSect();
                    String com = ins1.get(z).getComments();
                    String mail = ins1.get(z).getMailS();
                    Date dmail = ins1.get(z).getDateIns();




                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());


                    content += "<td>" + nomdel + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + to + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";


                }

                content += "<td rowspan=" + ins.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Fal</TD>";
                for (int y = 0; y < ins.size(); y++) {
                    Date start = ins.get(y).getStart();
                    Date end = ins.get(y).getEnd();
                    String loc = ins.get(y).getLocation().getNameL();
                    String nom = ins.get(y).getInspector().getLastNameI();
                    String prenom = ins.get(y).getInspector().getFirstNameI();
                    String stat = ins.get(y).getStatusFal();
                    String com = ins.get(y).getComments();
                    String nameFal = ins.get(y).getFal().getNameF();
                    String mail = ins.get(y).getMailF();
                    Date dmail = ins.get(y).getDateIns();

                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());
                    content +=
                            "<td>" + nameFal + "<br>" + loc + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }


                content += "<td rowspan=" + ins2.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Delivery</td>";
                for (int x = 0; x < ins2.size(); x++) {
                    String nomdel = ins2.get(x).getDelivery().getNameD();
                    int idfal = ins2.get(x).getDelivery().getIdD();
                    String ville = ins2.get(x).getLocation().getNameL();

                    Date datef = ins2.get(x).getId().getDatedev();
                    String mail = ins2.get(x).getMailD();
                    String nom = ins2.get(x).getInspector().getLastNameI();
                    String prenom = ins2.get(x).getInspector().getFirstNameI();
                    String stat = ins2.get(x).getStatusDel();
                    String com = ins2.get(x).getComments();
                    String loc = ins2.get(x).getLocation().getNameL();
                    Date dmail = ins2.get(x).getDateIns();

                    String from = datechange.change_date_reverse(datef.toString());



                    content +=
                            "<td>" + nomdel + "<br>" + ville + "</td>"
                            + "<td>" + datef + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + from + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }



            }
            content += "</tr></table>";

        }
        if (air != 0 && ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachIcao(air);
            for (int i = 0; i < ow.size(); i++) {

                int msn = ow.get(i).getMsn();

                List<InspectFal> ins;
                ins = PlanInspecBd.searchF(msn, dateS, dateE);
                List<InspectSection> ins1;
                ins1 = PlanInspecBd.searchS(msn, dateS, dateE);
                List<InspectDeliv> ins2;
                ins2 = PlanInspecBd.searchD(msn, dateS, dateE);
                int nbre = ins.size() + ins1.size() + ins2.size();


                content += "<tr>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getIcaoCode() + " </td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getOwner().getIcaoCode() + "</td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getAircraftType() + "</td>"
                        + "<td rowspan=" + nbre + ">" + msn + "</td>"
                        + "<td rowspan=" + ins1.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Section</td>";

                for (int z = 0; z < ins1.size(); z++) {
                    String nomdel = ins1.get(z).getSection().getNameS();

                    Date start = ins1.get(z).getDateStartS();
                    Date end = ins1.get(z).getDateEndS();
                    String nom = ins1.get(z).getInspector().getLastNameI();
                    String prenom = ins1.get(z).getInspector().getFirstNameI();
                    String stat = ins1.get(z).getStatusSect();
                    String com = ins1.get(z).getComments();
                    String mail = ins1.get(z).getMailS();
                    Date dmail = ins1.get(z).getDateIns();

                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());


                    content +=
                            "<td>" + nomdel + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";


                }

                content += "<td rowspan=" + ins.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Fal</TD>";
                for (int y = 0; y < ins.size(); y++) {
                    Date start = ins.get(y).getStart();
                    Date end = ins.get(y).getEnd();
                    String loc = ins.get(y).getLocation().getNameL();
                    String nom = ins.get(y).getInspector().getLastNameI();
                    String prenom = ins.get(y).getInspector().getFirstNameI();
                    String stat = ins.get(y).getStatusFal();
                    String com = ins.get(y).getComments();
                    String nameFal = ins.get(y).getFal().getNameF();
                    String mail = ins.get(y).getMailF();
                    Date dmail = ins.get(y).getDateIns();


                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());


                    content +=
                            "<td>" + nameFal + "<br>" + loc + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }


                content +=
                        "<td rowspan=" + ins2.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Delivery</td>";
                for (int x = 0; x < ins2.size(); x++) {
                    String nomdel = ins2.get(x).getDelivery().getNameD();
                    int idfal = ins2.get(x).getDelivery().getIdD();
                    String ville = ins2.get(x).getLocation().getNameL();
 
                    Date datef = ins2.get(x).getId().getDatedev();
                    String mail = ins2.get(x).getMailD();
                    String nom = ins2.get(x).getInspector().getLastNameI();
                    String prenom = ins2.get(x).getInspector().getFirstNameI();
                    String stat = ins2.get(x).getStatusDel();
                    String com = ins2.get(x).getComments();
                    String loc = ins2.get(x).getLocation().getNameL();
                    Date dmail = ins2.get(x).getDateIns();

                    String from = datechange.change_date_reverse(datef.toString());

                    content +=
                            "<td>" + nomdel + "<br>" + loc + "</td>"
                            + "<td>" + from + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }

            }
            content += "</tr></table>";

        }


        if (air == 0 && !ty.isEmpty()) {
            List<Aircraft> ow;
            ow = PlanInspecBd.seachDetail(ty);

            for (int i = 0; i < ow.size(); i++) {

                int msn = ow.get(i).getMsn();

                List<InspectFal> ins;
                ins = PlanInspecBd.searchF(msn, dateS, dateE);
                List<InspectSection> ins1;
                ins1 = PlanInspecBd.searchS(msn, dateS, dateE);
                List<InspectDeliv> ins2;
                ins2 = PlanInspecBd.searchD(msn, dateS, dateE);
                int nbre = 0;



                content += "<tr>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getIcaoCode() + " </td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getOwner().getOwner().getIcaoCode() + "</td>"
                        + "<td rowspan=" + nbre + ">" + ow.get(i).getAircraftType() + "</td>"
                        + "<td rowspan=" + nbre + ">" + msn + "</td>"
                        + "<td rowspan=" + ins1.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Section</td>";

                for (int z = 0; z < ins1.size(); z++) {
                    String nomdel = ins1.get(z).getSection().getNameS();

                    Date start = ins1.get(z).getDateStartS();
                    Date end = ins1.get(z).getDateEndS();
                    String nom = ins1.get(z).getInspector().getLastNameI();
                    String prenom = ins1.get(z).getInspector().getFirstNameI();
                    String stat = ins1.get(z).getStatusSect();
                    String com = ins1.get(z).getComments();
                    String mail = ins1.get(z).getMailS();
                    Date dmail = ins1.get(z).getDateIns();

                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());

                    content +=
                            "<td>" + nomdel + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";


                }

                content += "<td rowspan=" + ins.size() + ">Fal</TD>";
                for (int y = 0; y < ins.size(); y++) {
                    Date start = ins.get(y).getStart();
                    Date end = ins.get(y).getEnd();
                    String loc = ins.get(y).getLocation().getNameL();
                    String nom = ins.get(y).getInspector().getLastNameI();
                    String prenom = ins.get(y).getInspector().getFirstNameI();
                    String stat = ins.get(y).getStatusFal();
                    String com = ins.get(y).getComments();
                    String nameFal = ins.get(y).getFal().getNameF();
                    String mail = ins.get(y).getMailF();
                    Date dmail = ins.get(y).getDateIns();

                    String from = datechange.change_date_reverse(start.toString());
                    String to = datechange.change_date_reverse(end.toString());


                    content +=
                            "<td>" + nameFal + "<br>" + loc + "</td>"
                            + "<td> " + from + "<br>" + to + "</td>";
                    if ("sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }


                content +=
                        "<td rowspan=" + ins2.size() + " align=center class=\"titlebox12white\" bgcolor='#F69100'>Delivery</td>";
                for (int x = 0; x < ins2.size(); x++) {
                    String nomdel = ins2.get(x).getDelivery().getNameD();
                    int idfal = ins2.get(x).getDelivery().getIdD();
                    String ville = ins2.get(x).getLocation().getNameL();
                    Date datef = ins2.get(x).getId().getDatedev();
                    String mail = ins2.get(x).getMailD();
                    String nom = ins2.get(x).getInspector().getLastNameI();
                    String prenom = ins2.get(x).getInspector().getFirstNameI();
                    String stat = ins2.get(x).getStatusDel();
                    String com = ins2.get(x).getComments();
                    String loc = ins2.get(x).getLocation().getNameL();
                    Date dmail = ins2.get(x).getDateIns();
                    content +=
                            "<td>" + nomdel + "<br>" + loc + "</td>"
                            + "<td>" + datef + "</td>";
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "<br>" + dmail + "</td>";
                    }
                    if (!"sent".equals(mail)) {
                        content += "<td>" + mail + "</td>";
                    }
                    content += "<td>" + stat + "</td>"
                            + "<td>" + nom + "<br>" + prenom + "</td>"
                            + "<td>" + com + "</td>"
                            + "</tr>";
                }


            }
            content += "</tr></table>";


        }


        if (air == 0 && ty.isEmpty()) {
            out.println(content);
        } else {
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
