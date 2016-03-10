<%@page import="Work_define.changeformat_date"%>
<%@page import="Fonctions.consult_serv"%>
<%@page import="Work.Delivery"%>
<%@page import="Work.Fal"%>
<%@page import="Work.Section"%>
<%@page import="Work.Secretary"%>
<%@page import="Fonctions.service_bd"%>
<%@page import="java.util.List"%>
<%@page import="Work.Services"%>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevent caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Mails Delayed</title>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1">
        <!--specific Meta data to employee portal-->
        <meta name="Owner.corporateName" content="AIRBUS">
        <meta name="Aircraft.type" content="">
        <meta name="Aircraft.series" content="">
        <meta name="Aircraft.family" content="">
        <meta name="Rights" content="AIRBUS">
        <meta name="Type.category" content="eSite">
        <meta name="Type.aggregationLevel" content="collection">
        <meta name="Subject.keywords" content="">
        <meta name="Description" content="">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate">
        <meta http-equiv="Pragma" content="no-cache">
        <meta http-equiv="Expires" content="0">
        <link rel="stylesheet" href="css/ms-template.css" type="text/css">
    </head>

    <body bgcolor="#FFFFFF" background="html/claflib/bgdefault.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('html/claflib/closeesite_ro.gif','html/claflib/contact_ro.gif')">
        <%@include file="header.html" %>
        <noscript>Your browser does not support script</noscript>


        <div id="body_airbus" >

            <div align="center" >

                <div id="lnom">
                    <%
                    //call function
                         List<Object[]> lstStepF = consult_serv.get_steps_fal_delay();
                        List<Object[]> lstSttepD = consult_serv.get_steps_deliv_delay();
                        List<Object[]> lstStepS = consult_serv.get_steps_Section_delay();
                        changeformat_date datechange = new changeformat_date();


                        out.println("<table border=\"1\" cellpadding=\"5\">");
                        out.println("<tr bgcolor=\"#6593b5\">"
                                + "<td></td><td class=\"titlebox12white\">Owner</td>"
                                + "<td class=\"titlebox12white\">AIRCRAFT</td>"
                                + "<td class=\"titlebox12white\">MSN</td>"
                                + "<td class=\"titlebox12white\">STEP</td>  "
                                + "<td class=\"titlebox12white\">From</td>"
                                + "<td class=\"titlebox12white\"> To </td>"
                                + "<td class=\"titlebox12white\">Delay</td> </tr>");


                        int nb_secS = lstStepS.size();
                        out.println("<tr>");
                        if (nb_secS > 0) {
                            out.println("<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_secS + "\" class=\"titlebox12white\"");
                        } else {
                            out.println("<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"");
                        }
                        out.println("align=\"center\" >S<br/>E<br/>C<br/>T<br/>I<br/>O<br/>N</td>");
                        
                        if (!lstStepS.isEmpty()) {
                            for (Object[] row2 : lstStepS) {
                                out.println("<td>" + row2[0] + "</td>");
                                out.println("<td>" + row2[2] + "</td>");
                                out.println("<td>" + row2[1] + "</td>");
                                String from = datechange.change_date_reverse(row2[4].toString());
                                String to = datechange.change_date_reverse(row2[5].toString());
                                out.println("<td>" + row2[3] + "</td>");
                                out.println("<td> " + from + "</td>");
                                out.println("<td>" + to + "</td>");

                                out.println("<td>" + row2[6] + "</td>");

                                out.println("</tr>");
                            }
                        } else {
                            out.println("<td align=\"center\" colspan=\"7\">NO DELAYS</td>");
                        }


                        int nb_sec = lstStepF.size();
                        out.println("<tr>");
                        if (nb_sec > 0) {
                            out.println("<td width='50' bgcolor=\"#333367\" rowspan=\"" + nb_sec + "\" class=\"titlebox12white\"");
                        } else {
                            out.println("<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"");
                        }
                        out.println("align=center >F<br/>A<br/>L</td>");
                        if (!lstStepF.isEmpty()) {
                            for (Object[] row : lstStepF) {
                                out.println("<td>" + row[0] + "</td>");

                                out.println("<td>" + row[2] + "</td>");
                                out.println("<td>" + row[1] + "</td>");
                                String from = datechange.change_date_reverse(row[4].toString());
                                String to = datechange.change_date_reverse(row[5].toString());
                                
                                out.println("<td>" + row[3] + "</td>");
                                out.println("<td> " + from + "</td>");
                                out.println("<td>" + to + "</td>");

                                out.println("<td>" + row[6] + "</td>");

                                out.println("</tr>");
                            }
                        } else {
                            out.println("<td align=center colspan=7>NO DELAYS</td>");
                        }


                        int nb_secd = lstSttepD.size();
                        out.println("<tr>");
                        if (nb_secd > 0) {
                            out.println("<td width='50' bgcolor=\"#333367\"  rowspan=\"" + nb_secd + "\" class=\"titlebox12white\"");
                        } else {
                            out.println("<td width='50' bgcolor=\"#333367\" rowspan=\"1\" class=\"titlebox12white\"");
                        }
                        out.println("align=center >D<br/>E<br/>L<br/>I<br/>V<br/>E<br/>R<br/>Y</td>");
                        if (!lstSttepD.isEmpty()) {
                            for (Object[] row1 : lstSttepD) {
                                out.println("<td>" + row1[0] + "</td>");

                                out.println("<td>" + row1[2] + "</td>");
                                out.println("<td>" + row1[1] + "</td>");

                                String from = datechange.change_date_reverse(row1[4].toString());
                                String to = datechange.change_date_reverse(row1[5].toString());
                                out.println("<td>" + row1[3] + "</td>");
                                out.println("<td> " + from + "</td>");
                                out.println("<td> Empty </td>");
                                out.println("<td>" + row1[5] + "</td>");

                                out.println("</tr>");
                            }
                        } else {
                            out.println("<td align=center colspan=7>NO DELAYS</td>");
                        }

                        out.println("</table>");
                    %>

                </div>

            </div>
        </div>


    </body>

</html>