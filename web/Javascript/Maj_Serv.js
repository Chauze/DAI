function autreprocessXML()
{
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
                    
    // On pr?se ce que l'on va faire quand on aura re?la r?nse du serveur.
    xhr.onreadystatechange = function()
    {
                  
        // Si l'on a tout re?et que la requ? http s'est bien pass?
        if (xhr.readyState == 4 && xhr.status == 200)
        {  

            var texte = xhr.responseText;

            var Box = document.getElementById("input_step");
                        
            //var Box = document.getElementById("shoutbox");
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("input_step");
            Ndiv.innerHTML = texte;

            Box.appendChild(Ndiv);
				
        }
    }


              
    var select = document.getElementById('statselect');
    var val2 = select.options[select.selectedIndex].text;              

    xhr.open("GET","./Const_service?nomserv="+val2,true);   

    xhr.send(null);
}
       
function processXML ()
{
                                              
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
                   
    // On pr?se ce que l'on va faire quand on aura re?la r?nse du serveur.
    xhr.onreadystatechange = function()
    {
                    
        // Si l'on a tout re?et que la requ? http s'est bien pass?
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
            document.getElementById("days_nouv").value = '';
				
        }
    }


    var select = document.getElementById('statselect2');
    var val = select.options[select.selectedIndex].value;
            
                       
    var val2 = select.options[select.selectedIndex].text;
    var val3 = document.getElementById('days_nouv').value;
                            
           
    xhr.open("GET","./Const_Station?idserv="+val+"&namstat="+val2+"&n_days="+val3+"",true);   
  
    xhr.send(null);
                        
}
                    
function isNumeric()
{
    var Data = document.getElementById("days_nouv").value;
    numChars = "0123456789";
    var isNum = true;
    var index = 0;
    while ((index < Data.length) && (isNum))
    {
        isNum = (numChars.indexOf(Data.charAt(index)) != -1);
        index ++;
    }
    if (!isNum)
    {
        window.alert("Type a number");
    }else{
        processXML();
    }
}

                    
function check_field(){
                               
    var namedown = document.getElementById("days_nouv").value;
                            
    if(namedown ==''){
        alert("Field Days empty");
    }else{
        isNumeric();
    }
}