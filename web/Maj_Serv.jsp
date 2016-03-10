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
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
<title>Parameter Deadline</title>
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

                        <form name="days_check" method="" action="">
                        Phase Type : <select  id="statselect" onchange="autreprocessXML()">
                            <option>---</option>
                            <%

                                out.print("<option value=\"Delivery\">Delivery</option>");
                                out.print("<option value=\"Fal\">Fal</option>");
                                out.print("<option value=\"Section\">Section</option>");
                            %>            
                        </select>
                    </form>

                    <div id="input_step">

                    </div>
                    <br/>
                    <div id="lnom">
                        <%
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
                                    + "<td align=\"cxenter\" class=\"titlebox12white\">DAYS</td></tr>";
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
                        %>

                    </div>
            </div>
        </div>

        <script  type="text/javascript" src="./Javascript/httprequest.js"></script>
        <script  type="text/javascript" src="./Javascript/Maj_Serv.js"></script>
    </body>

</html>