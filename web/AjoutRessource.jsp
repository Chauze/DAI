<%@page import="Work.Location"%>
<%@page import="Work_define.ServicesBD"%>
<%@page import="Work.Services"%>
<%@page import="java.util.List"%>
<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevent caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Add a resource</title>
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

        <div id="center_body">
            <div id="body_airbus" >
                <div align="center">
                    Services : <select onchange="processXML() & hide() & hide1()" id="servselect">

                        <option>---</option>
                        <%
                            List<Services> listserv = ServicesBD.getServices();
                            Services services;

                            for (int i = 0; i < listserv.size(); i++) {
                                services = (Services) listserv.get(i);
                                out.print("<option value=" + services.getIdServ() + ">" + services.getNameServ() + "</option>");
                            }
                        %>
                    </select>

                    <br>
                    <br>

                    <div id="ser" style ="display:none">
                        Location : <select onchange="processXML() & hide1()" id="sselect" >

                            <%
                                List<Location> listLoc = ServicesBD.getLocation();
                                Location loc;

                                for (int i = 0; i < listLoc.size(); i++) {
                                    loc = (Location) listLoc.get(i);
                                    out.print("<option value=" + loc.getIdL() + ">" + loc.getNameL()
                                            + "</option>");
                                }
                            %>
                        </select>
                    </div>


                    <br/>
                    <br/>
                    <table cellpadding="10">
                        <tr valign="top">
                            <td valign="top" class="sizetable2"> <div id="tabl" ></div></td>
                            <td valign="top" class="sizetable2"><div id ="recapi" onchange="" style ="display:block" ></div> </td>
                        </tr>
                    </table>

                </div>
            </div>
        </div>

        <script  type="text/javascript" src="./Javascript/httprequest.js"></script>
        <script  type="text/javascript" src="./Javascript/add_resource.js"></script>
    </body>
</html>
