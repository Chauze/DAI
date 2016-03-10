function processXML()
{
                    
    var check = check_field();
                    
    if (check ==true){
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
        var val2 = select.options[select.selectedIndex].text;
               
        var location = document.getElementById('locateselect');
        var idloc= location.options[location.selectedIndex].value;
        var idres =  document.forms['completeAuto'].rechercheID.name;

        var url ="./Service_availability";
        var params ="?idres="+idres+"&loc="+idloc+"&serv="+val2;
              
        xhr.open("GET",url+params,true);   
        xhr.send(null);
    }
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

    var location = document.getElementById('locateselect');
    var idloc= location.options[location.selectedIndex].value;
                    
    var select = document.getElementById('servselect');
    var val2 = select.options[select.selectedIndex].text;
                    
    var nameowner = document.forms['completeAuto'].rechercheID.value;
               
    var url = "./Find_resource";
 
                    
    var params = "?name="+nameowner+"&serv="+val2+"&loc="+idloc;
                
    xhr.open("GET",url+params,true);   
    xhr.send(null);
            
}
                    
                    
function setfield(varstring,varid){
    document.forms['completeAuto'].rechercheID.value = varstring;
    document.forms['completeAuto'].rechercheID.name = varid;
                     
    var Box = document.getElementById("conteneur");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
    processXML();
}
                
function clearfield(){
    document.forms['completeAuto'].rechercheID.value = '';
    var Box = document.getElementById("lnom");
                        
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