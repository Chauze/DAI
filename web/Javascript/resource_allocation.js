
function processXML()
{
    var check = check_date();
                
    var check_field_owner = check_field_own();
    if (check==true && check_field_owner==true){

        // Objet XMLHttpRequest.
        var xhr = getXMLHttpRequest();

        // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
        xhr.onreadystatechange = function()
        {
            // Si l'on a tout reçu et que la requête http s'est bien passée.
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

        var url = "./Allocate_services";
        var params = "?nameserv="+val2+"&locat="+idloc+"&date_begin="+begin+"&date_end="+end+"";

        xhr.open("GET",url+params,true);   
        xhr.send(null);
    }
                
    if (check==false){
        alert("Field date Empty");
    }
                          
    if(check_field_owner==false){
        alert("Field Customer Empty");
    }
                    
}

function bookadd(idres)
{
    var check = check_date();
    if (check==true){

        var select = document.getElementById('servselect');
        var val2 = select.options[select.selectedIndex].text;
        var begin = document.getElementById('date_begin').value;
        var end = document.getElementById('date_end').value;
        var nameown = document.forms['completeAuto'].rechercheID.value;

        var xhr = getXMLHttpRequest();
        xhr.onreadystatechange = function()
        {
            if (xhr.readyState == 4 && xhr.status == 200)
            {  
                refresh_booking(nameown);	
            }
        }

        var url = "./Saving_services";
        var params = "?&nameserv="+val2+"&date_begin="+begin+
        "&date_end="+end+"&res="+idres+"&own="+nameown;

        xhr.open("GET",url+params,true);   
        xhr.send(null);
    }else{
        alert("Field date empty");
    }
}


function bookremove(idres,nameown,val2,status,end)
{
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            if(status != "plan"){
                refresh_booking(nameown);
            }

            else{
                refresh_booking_owner(nameown);
            }
        }
    }

    var url = "./Delete_book";
    var params = "?res="+idres+"&own="+nameown+"&nameserv="+val2+"&status="+status+"&date_end="+end;

    xhr.open("GET",url+params,true);   
    xhr.send(null);

}


function refresh_booking(nameown)
{
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  

            var texte = xhr.responseText;
            var Box = document.getElementById("recap_booking");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("recap_booking");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	

            processXML();

        }
    }

    var url = "./Refresh_saving";
    var params = "?own="+nameown;

    xhr.open("GET",url+params,true);   
    xhr.send(null);

}


function refresh_booking_owner(nameown)
{
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  

            var texte = xhr.responseText;
            var Box = document.getElementById("recap_booking");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("recap_booking");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
        }
    }

    var url = "./Refresh_saving";
    var params = "?own="+nameown;

    xhr.open("GET",url+params,true);   
    xhr.send(null);

}

function findowner()
{
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {  

            var texte = xhr.responseText;
            var Box = document.getElementById("conteneur");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("conteneur");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
        }
    }

    var nameowner = document.forms['completeAuto'].rechercheID.value;

    var url = "./Find_owner";
    var params = "?own="+nameowner;

    xhr.open("GET",url+params,true);   
    xhr.send(null);

}

function confirm_booking()
{
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            refresh_booking_owner(nameownerd);
        }
    }

    var nameownerd = document.forms['completeAuto'].rechercheID.value;

    var url = "./Confirmation";
    var params = "?own="+nameownerd;

    xhr.open("GET",url+params,true);   
    xhr.send(null);
}

function setfield(varstring){
    document.forms['completeAuto'].rechercheID.value = varstring;

    var Box = document.getElementById("conteneur");

    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }

    refresh_booking_owner(varstring);

}

function clearfield(){
    document.forms['completeAuto'].rechercheID.value = '';
    var Box = document.getElementById("lnom");

    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }

    var Box = document.getElementById("recap_booking");

    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
}

function check_field(){
    var nameown = document.forms['completeAuto'].rechercheID.value;

    if(nameown ==''){
        return (false);
    }
    else return (true);

}

function check_date(){
                
    var begin = document.getElementById('date_begin').value;
    var end = document.getElementById('date_end').value;
                
    if(begin == '' || end == ''){

        return (false);
    }
    else return (true);
                
}
function check_field_own(){
    var nameown = document.forms['completeAuto'].rechercheID.value;
                
    if(nameown ==''){
        return (false);
    }
    else return (true);
}