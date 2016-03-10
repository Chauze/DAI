function processXML ()
{

    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            var texte = xhr.responseText;
            var Box = document.getElementById("tabl");
                        
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("tabl");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);

        }
    }

    var select = document.getElementById('servselect');
    var val2 = select.options[select.selectedIndex].text;

    xhr.open("GET","./Ajout?nameserv="+val2,true);
    xhr.send(null);
}

function hide(){
    document.getElementById("ser").style.display = 'block';
}
                        
function hide1(){
    document.getElementById("recapi").style.display = 'none';
              
}
                        
function hide2(){
    document.getElementById("recapi").style.display = 'block';
}

function processSEC ()
{

    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  

            var texte = xhr.responseText;

            var Box = document.getElementById("recapi");
            
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }
            
            var Ndiv = document.createElement("recapi");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);
            processXML();
        }
    }

    var select = document.getElementById('servselect');
    var number = select.options[select.selectedIndex].value;
    var name = select.options[select.selectedIndex].text;

    var select1 = document.getElementById('sselect');
    var numberL = select1.options[select1.selectedIndex].value;

    var sel1 = document.forms['form1'].iname.value;
    var sel2 = document.forms['form1'].ilast.value;
    var sel3 = document.forms['form1'].iphone.value;
    var sel4 = document.forms['form1'].ifax.value;
    var sel5 = document.forms['form1'].imob.value;
    var sel6 = document.forms['form1'].imail.value;
                
   
    xhr.open("GET","./Update?idserv="+number+"&nameserv="+name+"&idloc="+numberL+"&nameC="+sel1+
        "&last="+sel2+"&phone="+sel3+"&fax="+sel4+"&mob="+sel5+"&mail="+sel6,true);

    xhr.send(null);
}
                    
function processCAR ()
{
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            var texte = xhr.responseText;

            var Box = document.getElementById("recapi");
                        
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("recapi");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);
                        
        }
    }

    var select = document.getElementById('servselect');
                
    var number = select.options[select.selectedIndex].value;
    var name = select.options[select.selectedIndex].text;
    var select1 = document.getElementById('sselect');
                
    var numberL = select1.options[select1.selectedIndex].value;
    
    var sel1 = document.forms['form1'].iname.value;
    var sel2 = document.forms['form1'].imodel.value;
    var sel3 = document.forms['form1'].ibrand.value;
                    
              
    xhr.open("GET","./Update?idserv="+number+"&nameserv="+name+"&idloc="+numberL+"&nameC="+sel1+"&model="+sel2+"&brand="+sel3,true);
                    
                  
               
                  
    xhr.send(null);
                
                
            
}
            
function processOFF ()
{
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
                 
    {
        if (xhr.readyState == 4 && xhr.status == 200)
        {  
                          
            var texte = xhr.responseText;
            var Box = document.getElementById("recapi");
                        
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("recapi");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);
                        

        }
    }

    var select = document.getElementById('servselect');
    var number = select.options[select.selectedIndex].value;
    var name = select.options[select.selectedIndex].text;
    var select1 = document.getElementById('sselect');
    var numberL = select1.options[select1.selectedIndex].value;
    var sel1 = document.forms['form1'].iname.value;

    xhr.open("GET","./Update?idserv="+number+"&nameserv="+name+"&idloc="+numberL+"&nameC="+sel1,true);
    xhr.send(null);

}