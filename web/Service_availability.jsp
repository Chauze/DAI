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
        <title>eSite - 1024_hometype0</title>
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

        <link rel="stylesheet" href="css/ms-template.css" type="text/css">
    </head>

    <body bgcolor="#FFFFFF" background="html/claflib/bgdefault.gif" leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" onLoad="MM_preloadImages('html/claflib/closeesite_ro.gif','html/claflib/contact_ro.gif')">
        <%@include file="header.html" %>
        <noscript>Your browser does not support script</noscript>

        <div id="center_body">
            <div id="body_airbus" >
                <div align="center">

                    <script type="text/JavaScript">  
          
        
                    </script>


                    <table cellpadding="10">

                        <tr valign="top">
                            <td>
                                <table  border="1">
                                    <tr bgcolor=\"#333367\">
                                        <td class="titlebox12white">Legend</td>
                                    </tr>



                                    <TR bgcolor="#FAAC58">
                                        <td>Processing</td>

                                    </tr>
                                    <tr bgcolor="#C3E3FA" >
                                        <td>Planned</td>

                                    </tr>
                                </table>
                            </td>

                            <td>
                                <form name="completeAuto" method="" action="">

                                    Services : <select onchange="clearfield() & processXML()" id="servselect">
                                        <%
                                            List<Services> listserv = ServicesBD.getServices();
                                            Services services;

                                            for (int i = 0; i < listserv.size(); i++) {
                                                services = (Services) listserv.get(i);
                                                out.print("<option value=" + services.getIdServ() + ">" + services.getNameServ() + "</option>");
                                            }
                                        %>  

                                    </select>
                                    <br/><br/> 
                                    Location : <select onchange="clearfield() & processXML()" id="locateselect">
                                        <%
                                            List<Location> listsloc = ServicesBD.getLocation();
                                            Location loc;

                                            for (int i = 0; i < listsloc.size(); i++) {
                                                loc = (Location) listsloc.get(i);
                                                out.print("<option value='" + loc.getIdL() + "'>" + loc.getNameL() + "</option>");
                                            }
                                        %>
                                    </select><br/> <br/> 

                                    Name : <input type="text" name="customer" id="rechercheID" onkeyup="findowner()" value="" onfocus="this.value='';" /><br/>   
                                    <div id="conteneur">
                                    </div>

                                    <br/>



                                </form>
                            </td>
                        </tr></table>
                                    
                    <div class="sizetable2" id="lnom">
                    </div>

                </div>
            </div>
        </div>

        <script  type="text/javascript" src="./Javascript/httprequest.js"></script>
        <script  type="text/javascript" src="./Javascript/Service_availability.js"></script>
    </body>

</html>