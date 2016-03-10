//update statuts mail in BD
function update_mail(msn,idspec,idstep,phase){
     
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
                
    {                
        if (xhr.readyState == 4 && xhr.status == 200)
        {                         
                          
                                              
        }
    }

    xhr.open("GET","./Update_mail?step="+idstep+"&msn="+msn+"&inspector="+idspec+"&phase="+phase,true);   
    xhr.send(null);     

}


function processXML (msn,tab)
{
    hide_div();
                        
    show(tab);

    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
                 
                
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            var texte = xhr.responseText;


            var Box = document.getElementById(tab);

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement(tab);
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
                            
        }
    }

              
    xhr.open("GET","./PlanFal?msn="+msn+"",true);
               
                  
    xhr.send(null);
                
                
            
}
                
function updateCom(var_sel,var_com,del,id,msn)
{

    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
                
    {
        
        if (xhr.readyState == 4 && xhr.status == 200)
        {  

				
        }
    }
            
               
    var x = document.getElementById(var_com).value;
    var select = document.getElementById(var_sel);
    var val2 = select.options[select.selectedIndex].text;
              
              
    xhr.open("GET","./UpdateCom?st="+val2+"&com="+x+"&phase="+del+"&idph="+id+"&msn="+msn+"",true);       
    xhr.send(null);        
}


//hide all the div
function hide_div() {
                         
    var i = 0;
 
    while (document.getElementById("tab"+i)){
                            
        document.getElementById("tab"+i).style.display='none';                  
 
        i++
    }
}

//display a div
function show(tab){
    document.getElementById(tab).style.display='block';
}
      
      
function updateDa(st,ed,del,id,msn)
{

    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()       
    { 
        if (xhr.readyState == 4 && xhr.status == 200)
        {  			
        }
    }
               
    var x = document.getElementById(st).value;
    var y = document.getElementById(ed).value;
                       
    xhr.open("GET","./Saving_date_inspection?start="+x+"&phase="+del+"&idph="+id+"&end="+y+"&msn="+msn,true);    
    xhr.send(null);      
}

function processDel (msn,tab)
{
    hide_div(); 
    show(tab);
    var xhr = getXMLHttpRequest();
                 

    xhr.onreadystatechange = function()
                 
                
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
            var texte = xhr.responseText;


            var Box = document.getElementById(tab);

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement(tab);
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);				
        }
    }

                         
    xhr.open("GET","./PlanDel?msn="+msn+"",true);      
    xhr.send(null);        
}
            
function processSect (msn,tab)
{
    hide_div();
                        
    show(tab);
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()  
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
                          
            var texte = xhr.responseText;


            var Box = document.getElementById(tab);

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement(tab);
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
                        
				
        }
    }

    xhr.open("GET","./PlanSec?msn="+msn+"",true);        
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
 
    var url = "./FindOwner";
    var params = "?own="+nameowner;
                
    xhr.open("GET",url+params,true);   
    xhr.send(null);
}
                    
           
function processPlan ()
{
    hide_div();
                        
    show(tab);
    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
  
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
                          
            var texte = xhr.responseText;

            var Box = document.getElementById("bra");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("bra");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);				
        }
    }
         
    xhr.open("GET","./Plan",true);         
    xhr.send(null); 
}

function findtype()
{
    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
    {

        if (xhr.readyState == 4 && xhr.status == 200)
        {  
                       
            var texte = xhr.responseText;
            var Box = document.getElementById("conteneur1");
                        
            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("conteneur1");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
                        
        }
    }

    var nameowner = document.forms['completeAuto2'].rechercheID1.value;
                
   
    var url = "./FindType";
    var params = "?own="+nameowner;
                
    xhr.open("GET",url+params,true);   
    xhr.send(null);
}
            
            
function setfield(varstring,varid){

    var xhr = getXMLHttpRequest();

    xhr.onreadystatechange = function()
                
    {                
        if (xhr.readyState == 4 && xhr.status == 200)
        {                         
                          
            var texte = xhr.responseText;


            var Box = document.getElementById("bra");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("bra");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	
                            
              
        }
    }
                 
  
    var str = document.forms['completeAuto2'].rechercheID1.value ;

    xhr.open("GET","./PlanId?num="+varid+"&type="+str+"",true);   
    xhr.send(null);     
                        
}
            
function setfield1(){

    var xhr = getXMLHttpRequest();
    xhr.onreadystatechange = function()
                
    {                
  
        if (xhr.readyState == 4 && xhr.status == 200)
        {                         
                          
            var texte = xhr.responseText;
            var Box = document.getElementById("bra");

            while (Box.firstChild) {
                Box.removeChild(Box.firstChild);
            }

            var Ndiv = document.createElement("bra");
            Ndiv.innerHTML = texte;
            Box.appendChild(Ndiv);	    
        }
    }

    var e = document.forms['completeAuto'].rechercheID.name;
    
    var typ = document.forms['completeAuto2'].rechercheID1.value ;
    
    if(e!='customer'){
                
               
    }else{
        e=0;
    }
                
 
    xhr.open("GET","./PlanId?num="+e+"&type="+typ+"",true);   
    xhr.send(null);     
                        
}
            
 
function fix_field(varstring,varid){
    //nom client
    document.forms['completeAuto'].rechercheID.value = varstring;
    document.forms['completeAuto'].rechercheID.name = varid;
               
    var Box = document.getElementById("conteneur");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
                    
    setfield(varstring,varid);       
}
            
                      
function fix_fieldtype(varstring){
    cleartype();
    //nom client
    document.forms['completeAuto2'].rechercheID1.value = varstring;
          
    var Box = document.getElementById("conteneur1");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
                    
    setfield1();       
}
            
function clearn(){
    //nom client
    document.forms['completeAuto'].rechercheID.value = '';
    document.forms['completeAuto'].rechercheID.name = 0;
             
    var Box = document.getElementById("conteneur");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
                    
                     
}
            
function cleartype(){
    //nom client
    document.forms['completeAuto2'].rechercheID1.value = '';
    document.forms['completeAuto2'].rechercheID1.name = 0;
             
    var Box = document.getElementById("conteneur1");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
                    
                     
}