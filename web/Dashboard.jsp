<%@page import="Work.Services"%>
<%@page import="Work_define.ServicesBD"%>
<%@page import="Work.Location"%>
<%@page import="Work.Location"%>
<%@page import="java.util.List"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
   "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Dashboard</title>
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


        <div id="body_airbus" >

            <div align="center" >
                <table cellpadding="20">
                    <tr valign="top">
                        <td>
                            <table  border="1">
                                <tr bgcolor="#333367">
                                    <td class="titlebox12white">Legend</td>
                                </tr>

                                <tr>
                                    <td>Available</td>

                                </tr>

                                <tr bgcolor="#FAAC58">
                                    <td>Processing</td>

                                </tr>
                                <tr bgcolor="#C3E3FA" >
                                    <td>Planned</td>

                                </tr>
                            </table>
                        </td>

                        <td>
                            <form name="completeAuto" method="" action="">
                                Location : <select onchange="processXML()" id="locateselect">
                                    <%
                                        List<Location> listsloc = ServicesBD.getLocation();
                                        Location loc;

                                        for (int i = 0; i < listsloc.size(); i++) {
                                            loc = (Location) listsloc.get(i);
                                            out.print("<option value='" + loc.getIdL() + "'>" + loc.getNameL() + "</option>");
                                        }
                                    %>
                                </select>


                                Services : <select onchange="processXML()" id="servselect">
                                    <option>--</option>
                                    <%
                                        List<Services> listserv = ServicesBD.getServices();
                                        Services services;

                                        for (int i = 0; i < listserv.size(); i++) {
                                            services = (Services) listserv.get(i);
                                            out.print("<option value=" + services.getIdServ() + ">" + services.getNameServ() + "</option>");
                                        }
                                    %>
                                </select>
                                <br/> <br/>

                                From : <input size="8" id="date_begin" type="text" name="date_begin" value=""/>
                                <a href="javascript:NewCal('date_begin','ddmmyyyy')"><img src="calandar3.gif" width="16" height="16" border="0" alt="Pick a date"></a>

                                To : <input id="date_end" size="8" type="text" name="date_end" value=""/> 
                                <a href="javascript:NewCal('date_end','ddmmyyyy')"><img src="calandar3.gif" width="16" height="16" border="0" alt="Pick a date"></a>

                                <input type="button" class="input3" value="" onclick="processXML()"/>

                            </form>
                        </td>
                    </tr>
                </table>
                <br/>

                <script type="text/Javascript">
                    function processXML()
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

                        // Requête au serveur avec les paramètres éventuels.
                        var select = document.getElementById('servselect');
                        var val2 = select.options[select.selectedIndex].text;
               
                        var location = document.getElementById('locateselect');
                        var idloc= location.options[location.selectedIndex].value;
                
                
                        var begin = document.getElementById('date_begin').value;
                        var end = document.getElementById('date_end').value;
                      
                        var url,params;  
                        if(begin == "" && end == "" ){
                 
                            begin  = '01-01-1900';
                            end  = '01-01-2900';    
                        }
                        else{
                
                        }
               
                        if (val2 == "--"){
                            url = "./Dash_Global_services";
                            params = "?locat="+idloc+"&date_begin="+begin+"&date_end="+end+"";
                             
                        }else{
                            url = "./Dash_services";
                            params = "?nameserv="+val2+"&locat="+idloc+"&date_begin="+begin+"&date_end="+end+"";
                           
                        }
                            
                        xhr.open("GET",url+params,true);   
                        xhr.send(null);
                    }
                </script>

                <script  type="text/javascript" src="./Javascript/Calendar.js"></script>
                <script  type="text/javascript" src="./Javascript/httprequest.js"></script>

            </div>

            <div class="sizetable3" id="lnom">
            </div>

        </div>  </div>
</body>

</html>