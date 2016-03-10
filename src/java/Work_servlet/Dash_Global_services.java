/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Work_servlet;

import Work.Owner;
import Work_define.Dash_BD;
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
public class Dash_Global_services extends HttpServlet {

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


        changeformat_date datechange = new changeformat_date();
        String from, to;

        String date_begin = request.getParameter("date_begin");
        String date_end = request.getParameter("date_end");

        date_begin = datechange.change_date(date_begin);
        date_end = datechange.change_date(date_end);


        //CAR
        List<Object[]> lstservicesC;
        //check if the date has been defined in order to call a different function with differents parameters
        if (!"".equals(date_begin) && date_begin != null) {
            
            lstservicesC = Dash_BD.dash_filter_date("Car", idloc, date_begin, date_end);
        } else {

            lstservicesC = Dash_BD.dash_filter_nodate("Car", idloc);
        }

        String content = "<table class=\"sizetable3\" border=\"1\">"
                + "<tr bgcolor=\"#6593b5\">"
                + "<td></td>"
                + "<td class=\"titlebox12white\">Customer</td>"
                + "<td class=\"titlebox12white\">From...to</td>"
                + "<td class=\"titlebox12white\">Name</td>"
                + "<td class=\"titlebox12white\">Phone & Mobile</td>"
                + "<td class=\"titlebox12white\">Brand</td>"
                + "<td class=\"titlebox12white\">Model</td>"
                + "<td class=\"titlebox12white\">Registration</td>"
                + "<td class=\"titlebox12white\">Building</td>"
                + "</tr>";


        int nb_sec = lstservicesC.size();
        content += "<tr>";
        if (nb_sec > 0) {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_sec + "\" class=\"titlebox12white\"";
        } else {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"";
        }
        content += "align=center >C<br/>A<br/>R</td>";

        if (!lstservicesC.isEmpty()) {

            String color = "";
            for (Object[] row : lstservicesC) {
                if (row[7] != null) {
                    if ("inprogress".equals(row[7].toString())) {

                        color = "bgcolor=\"#FAAC58\"";

                    } else {

                        color = "bgcolor=\"#C3E3FA\"";
                    }
                } else {
                    color = "";
                }


                List<Owner> nameow;
                if (row[8] != null) {
                    nameow = ServicesBD.getIDowner(Integer.parseInt(row[8].toString()));
                    content += "<td  " + color + ">" + nameow.get(0).getFullName() + "<br/> </td>";
                } else {
                    content += " <td  " + color + "  align=\"center\">-</td>";
                }

                if (row[4] != null) {
                    from = datechange.change_date_reverse(row[4].toString());
                    to = datechange.change_date_reverse(row[5].toString());

                    content += "<td " + color + " align=\"center\"> " + from + "<br/>" + to + "</td>";
                } else {
                    content += "<td " + color + " align=\"center\"> - </td>";
                }

                content += "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + ">" + row[0] + "</td>"
                        + "<td " + color + ">" + row[1].toString().toUpperCase() + "</td>"
                        + "<td " + color + ">" + row[2] + "</td>"
                        + "<td " + color + " align=\"center\">-</td>";


                content += "</tr>";
            }
        } else {
            content += "<td align=\"center\" colspan=\"9\">NO AVAILABILITIES</td></tr>";
        }



        //HOSTESS
        List<Object[]> lstservicesH;
        if (!"".equals(date_begin) && date_begin != null) {

            lstservicesH = Dash_BD.dash_filter_date("Hostess", idloc, date_begin, date_end);
        } else {

            lstservicesH = Dash_BD.dash_filter_nodate("Hostess", idloc);
        }



        int nb_secH = lstservicesH.size();
        content += "<tr>";
        if (nb_secH > 0) {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_secH + "\" class=\"titlebox12white\"";
        } else {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"";
        }
        content += "<td align=center >H<br/>O<br/>S<br/>T<br/>E<br/>S<br/>S</td>";

        if (!lstservicesH.isEmpty()) {

            String color = "";
            for (Object[] row : lstservicesH) {
                if (row[7] != null) {
                    if ("inprogress".equals(row[7].toString())) {

                        color = "bgcolor=\"#FAAC58\"";

                    } else {

                        color = "bgcolor=\"#C3E3FA\"";
                    }
                } else {
                    color = "";
                }


                List<Owner> nameow;
                if (row[8] != null) {
                    nameow = ServicesBD.getIDowner(Integer.parseInt(row[8].toString()));
                    content += "<td  " + color + ">" + nameow.get(0).getFullName() + "<br/> </td>";
                } else {
                    content += " <td  " + color + "  align=\"center\">-</td>";
                }


                if (row[4] != null) {
                    from = datechange.change_date_reverse(row[4].toString());
                    to = datechange.change_date_reverse(row[5].toString());
                    content += "<td " + color + " align=\"center\"> " + from + "<br/>" + to + "</td>";
                } else {
                    content += "<td " + color + " align=\"center\"> - </td>";
                }

                content += "<td " + color + ">" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                        + "<td " + color + ">" + row[2] + "<br/>" + row[3] + "</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>";


                content += "</tr>";
            }
        } else {
            content += "<td align=\"center\" colspan=\"9\">NO AVAILABILITIES</td></tr>";
        }



//OFFICE

        List<Object[]> lstservicesO;
        if (!"".equals(date_begin) && date_begin != null) {

            lstservicesO = Dash_BD.dash_filter_date("Office", idloc, date_begin, date_end);
        } else {

            lstservicesO = Dash_BD.dash_filter_nodate("Office", idloc);
        }



        int nb_sescO = lstservicesO.size();
        content += "<tr>";
        if (nb_sescO > 0) {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_sescO + "\" class=\"titlebox12white\"";
        } else {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"";
        }
        content += " align=center >O<br/>F<br/>F<br/>I<br/>C<br/>E</td>";



        if (!lstservicesO.isEmpty()) {

            String color = "";
            for (Object[] row : lstservicesO) {
                if (row[4] != null) {
                    if ("inprogress".equals(row[4].toString())) {

                        color = "bgcolor=\"#FAAC58\"";

                    } else {

                        color = "bgcolor=\"#C3E3FA\"";
                    }
                } else {
                    color = "";
                }


                List<Owner> nameow;
                if (row[5] != null) {
                    nameow = ServicesBD.getIDowner(Integer.parseInt(row[5].toString()));
                    content += "<td  " + color + ">" + nameow.get(0).getFullName() + "<br/> </td>";
                } else {
                    content += " <td  " + color + " align=\"center\">-</td>";
                }


                if (row[1] != null) {
                    from = datechange.change_date_reverse(row[1].toString());
                    to = datechange.change_date_reverse(row[2].toString());
                    content += "<td " + color + " align=\"center\"> " + from + "<br/>" + to + "</td>";
                } else {
                    content += "<td " + color + " align=\"center\"> - </td>";
                }

                content += "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + ">" + row[0] + "</td>";



                content += "</tr>";
            }
        } else {
            content += "<td align=\"center\" colspan=\"9\">NO AVAILABILITIES</td></tr>";
        }

        //SECRETARY

        List<Object[]> lstservices;
        if (!"".equals(date_begin) && date_begin != null) {

            lstservices = Dash_BD.dash_filter_date("Secretary", idloc, date_begin, date_end);
        } else {

            lstservices = Dash_BD.dash_filter_nodate("Secretary", idloc);
        }

        int nb_secS = lstservices.size();

        content += "<tr>";
        if (nb_secS > 0) {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_secS + "\" class=\"titlebox12white\"";
        } else {
            content += "<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"";
        }
        content += " align=center >S<br/>E<br/>C<br/>R<br/>E<br/>T<br/>A<br/>R<br/>Y</td>";




        if (!lstservices.isEmpty()) {

            String color = "";
            for (Object[] row : lstservices) {
                if (row[7] != null) {
                    if ("inprogress".equals(row[7].toString())) {

                        color = "bgcolor=\"#FAAC58\"";

                    } else {

                        color = "bgcolor=\"#C3E3FA\"";
                    }
                } else {
                    color = "";
                }


                List<Owner> nameow;
                if (row[8] != null) {
                    nameow = ServicesBD.getIDowner(Integer.parseInt(row[8].toString()));
                    content += "<td  " + color + ">" + nameow.get(0).getFullName() + "<br/> </td>";
                } else {
                    content += " <td  " + color + " align=\"center\">-</td>";
                }

                if (row[4] != null) {
                    from = datechange.change_date_reverse(row[4].toString());
                    to = datechange.change_date_reverse(row[5].toString());
                    content += "<td " + color + " align=\"center\"> " + from + "<br/>" + to + "</td>";
                } else {
                    content += "<td " + color + " align=\"center\"> - </td>";
                }

                content += "<td " + color + ">" + row[0] + "<br/>" + row[1].toString().toUpperCase() + "</td>"
                        + "<td " + color + ">" + row[2] + "<br/>" + row[3] + "</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>"
                        + "<td " + color + " align=\"center\">-</td>";


                content += "<tr>";
            }
        } else {
            content += "<td align=\"center\" colspan=\"9\">NO AVAILABILITIES</td>";
        }


        content += "</table>";

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
