
let name = "username" + "=";
let name1 = "role" + "=";
let cookies = document.cookie
let decodedCookie = decodeURIComponent(cookies);
let ca = decodedCookie.split(';');
var aux=0;
for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    let part = c.split('=');
    if(part[0]===" username"||part[0]===" password"){
        aux++;
    }

}
if(aux==2){
    for(let i = 0; i <ca.length; i++) {
        let c = ca[i];
        while (c.charAt(0) == ' ') {
            c = c.substring(1);
            let value =(c.substring(name1.length));
            if(value==1||value==2){
                if(value==1){
                    let url=(location.href);
                    window.location.href = url+"UserForm.html";
                }else{
                    let url=(location.href);
                    window.location.href = url+"OficialForm.html";
                }
            }
        }
    }
}



