function findowner()
{
                
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
                 
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
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
function findtype()
{
                
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
                 
    // On précise ce que l'on va faire quand on aura reçu la réponse du serveur.
    xhr.onreadystatechange = function()
    {
        // Si l'on a tout reçu et que la requête http s'est bien passée.
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
				 
    // Objet XMLHttpRequest.
    var xhr = getXMLHttpRequest();
                 
    // On prÃ©cise ce que l'on va faire quand on aura reÃ§u la rÃ©ponse du serveur.
    xhr.onreadystatechange = function()
                
    {                
        // Si l'on a tout reÃ§u et que la requÃªte http s'est bien passÃ©e.
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
    var start = document.getElementById('date_begin').value;
    var end = document.getElementById('date_end').value;
                
    if(start == "" && end == "" ){
                 
        start  = '01-01-1900';
        end  = '01-01-2900';    
    }
    else{
                
    }
           

    var str = document.forms['completeAuto2'].rechercheID1.value ;

      
    xhr.open("GET","./DashFal?num="+varid+"&type="+str+"&start="+start+"&end="+end+"",true);   
    xhr.send(null);     
                        
}
            
function setfield1(varstring){

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
    var start = document.getElementById('date_begin').value;
    var end = document.getElementById('date_end').value;
                
 
    if(e!='customer'){
    }else{
        e=0;
    }
    if(start == "" && end == "" ){
        start  = '01-01-1900';
        end  = '01-01-2900';    
    }
    else{
                
    }

    xhr.open("GET","./DashFal?type="+varstring+"&num="+e+"&start="+start+"&end="+end+"",true);   
    xhr.send(null);     
                        
}
            
function setfield3(){

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
    var start = document.getElementById('date_begin').value;
    var end = document.getElementById('date_end').value;
    var e = document.forms['completeAuto'].rechercheID.name;
    var str = document.forms['completeAuto2'].rechercheID1.value ;
               
    if(e!='customer'){
                
               
    }else{
        e=0;
                
    }
                
    if(start == "" && end == "" ){
                 
        start  = '01-01-1900';
        end  = '01-01-2900';    
    }
    else{
                
    }
           
           
    xhr.open("GET","./DashFal?num="+e+"&type="+str+"&start="+start+"&end="+end+"",true);   
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
    //nom client
    document.forms['completeAuto2'].rechercheID1.value = varstring;
               
    var Box = document.getElementById("conteneur1");
                        
    while (Box.firstChild) {
        Box.removeChild(Box.firstChild);
    }
                    
    setfield1(varstring);       
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
                    
function processXML()
{
    var check = check_date();
    if (check==true){
                            
        // Objet XMLHttpRequest.
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

        var select = document.getElementById('servselect');
        var val2 = select.options[select.selectedIndex].text;
               
        var location = document.getElementById('locateselect');
        var idloc= location.options[location.selectedIndex].value;
                

        var begin = document.getElementById('date_begin').value;
        var end = document.getElementById('date_end').value;

        var url = "./DashFal";
        var params = "?nameserv="+val2+"&locat="+idloc+"&date_begin="+begin+"&date_end="+end+"";
                
        xhr.open("GET",url+params,true);   
        xhr.send(null);
    }else{
                           
    }
                   
}
function check_date(){
    var nameown = document.forms['completeAuto'].rechercheID.value;
    var begin = document.getElementById('date_begin').value;
    var end = document.getElementById('date_end').value;
                        
    if(begin == '' || end == '' || nameown ==''){
         
        return (false);
    }
    else return (true);
}