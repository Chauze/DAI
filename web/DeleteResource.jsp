<%@page import="Work.Services"%>
<%@page import="Work_define.ServicesBD"%>
<%@page import="Work.Location"%>
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
        <title>Delete a resource</title>
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
        <%@include file="/header.html" %>
        <noscript>Your browser does not support script</noscript>


        <div id="body_airbus" >
            <center>
                <form method="" action="">

                    <br/>   
                    Location : <select onchange="processXML()" id="locateselect">

                        <%
                            List<Location> listsloc = ServicesBD.getLocation();
                            Location loc;

                            for (int i = 0; i < listsloc.size(); i++) {
                                loc = (Location) listsloc.get(i);
                                out.print("<option value=" + loc.getIdL() + ">" + loc.getNameL() + "</option>");
                            }
                        %>
                    </select>


                    Services : <select onchange="processXML()" id="servselect">
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
                    <br/>
                </form>

                <script type="text/JavaScript">  
                    function processXML ()
                    {
                        var xhr = getXMLHttpRequest();
                        xhr.onreadystatechange = function()
                        {
      
                            if (xhr.readyState == 4 && xhr.status == 200)
                            {  
                       
                                var texte = xhr.responseText;
                                var Box = document.getElementById("lnom");
                        
                                while (Box.firstChild) {
                                    Box.removeChild(Box.firstChild);
                                }

                                var Ndiv = document.createElement("lnom");
                                Ndiv.innerHTML = texte;
                                Box.appendChild(Ndiv);	
                          
                            }
                        }

                        var select = document.getElementById('servselect');
                        var val = select.options[select.selectedIndex].value;
                        var val2 = select.options[select.selectedIndex].text;
               
                        var select2 = document.getElementById('locateselect');
                        var idloc= select2.options[select2.selectedIndex].value;

                  
                        var url = "./AllocateService";
                        var params = "?idserv="+val+"&nameserv="+val2+"&locat="+idloc+"";
                        xhr.open("GET",url+params,true);
                        xhr.send(null);
                    }
           

                    function deleteStoune (idsto,nomse)
                    {
 
                        var xhr = getXMLHttpRequest();
  
                        xhr.onreadystatechange = function()
                        {

                            if (xhr.readyState == 4 && xhr.status == 200)
                            {  
                       
                                var texte = xhr.responseText;
                                var Box = document.getElementById("rec");
                        
                        
                                while (Box.firstChild) {
                                    Box.removeChild(Box.firstChild);
                                }

                                var Ndiv = document.createElement("rec");
                                Ndiv.innerHTML = texte;
                                Box.appendChild(Ndiv);	
                                processXML();
                        
                            }
                        }

                        var url = "./DeleteRess?idsto="+idsto+"&nomse="+nomse+""; 

                        xhr.open("GET",url,true);
                        xhr.send(null);

                    }    
                </script>

                <div id="lnom"></div>

                <div id="rec"></div>

            </center>
        </div>
<script  type="text/javascript" src="./Javascript/httprequest.js"></script>
    </body>
</html>