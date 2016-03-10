function emailForm(frst,last,mail,from,msn,town,typ_air,nomDel,idspec,idstep,phase){

    update_mail(msn,idspec,idstep,phase);
    var subject = nomDel+ " - "+ typ_air+" " +msn;
                        
    var   body_message = "Dear "+frst+" "+last.toString().toUpperCase()+", %0D%0D You will can inspect the " +typ_air+" (" +msn+") in " +town+" on "+from+" for the " +nomDel+" Step.%0D%0D Best Regards.%0D%0DAIRBUS.";

    var mailto_link = 'mailto:'+mail+'?subject='+subject+'&body='+body_message;
    win = window.open(mailto_link,'emailWindow');
    if (win && win.open &&!win.closed) win.close();
}
                        

function emailFormb(frst,last,mail,from,to,msn,town,typ_air,nomDel,idspec,idstep,phase){

    update_mail(msn,idspec,idstep,phase);
    var subject = nomDel+ " - "+ typ_air+" " +msn;
                        
    var   body_message = "Dear "+frst+" "+last.toString().toUpperCase()+", %0D%0D You will can inspect the " +typ_air+" (" +msn+") in " +town+" from "+from+" to "+to+" for the " +nomDel+" Step.%0D%0D Best Regards.%0D%0DAIRBUS.";

    var mailto_link = 'mailto:'+mail+'?subject='+subject+'&body='+body_message;
    var win = window.open(mailto_link,'emailWindow');
    if (win && win.open &&!win.closed) win.close();
}