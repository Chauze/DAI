<%
    response.setHeader("Cache-Control", "no-cache"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevent caching at the proxy server
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN"
    "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
    <head>
        <title>Inspection</title>
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
            <div align="center">



                <form name="completeAuto" method="" action="">
                    Customer : <input type="text" name="customer" id="rechercheID" onkeyup="findowner()" value=""  onclick="clearn() & fix_field('',0)" /><br/>   
                    <div id="conteneur">
                    </div>
                </form>
                <br/>

                <form name="completeAuto2" method="" action="">
                    Type : <input type="text" name="customer1" id="rechercheID1" onkeyup="findtype()" value=""  onclick="cleartype() & fix_fieldtype('')" /><br/>   
                    <div id="conteneur1">
                    </div>
                </form>
                <br/>

                From : <input size="8" id="date_begin" type="text" name="date_begin" value=""/>
                <a href="javascript:NewCal('date_begin','ddmmyyyy')"><img src="calandar3.gif" width="16" height="16" border="0" alt="Pick a date"></a>

                To : <input id="date_end" size="8" type="text" name="date_end" value=""/> 
                <a href="javascript:NewCal('date_end','ddmmyyyy')"><img src="calandar3.gif" width="16" height="16" border="0" alt="Pick a date"></a>
                <input type="button" class="input3" onclick="setfield3()" value=""/>

                <br/> <br/>
                <div id="bra"></div>


            </div>

        </div>
        <script  type="text/javascript" src="./Javascript/Calendar.js"></script>
        <script  type="text/javascript" src="./Javascript/httprequest.js"></script>
        <script  type="text/javascript" src="./Javascript/Dashinsp.js"></script>

    </body>

</html>