
let name = "request" + "=";
let cookies = document.cookie
let decodedCookie = decodeURIComponent(cookies);
let ca = decodedCookie.split(';');

for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
        c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {

        let message=(c.substring(name.length, c.length));
        var etqP = document.createElement("p");
        document.getElementById("response").appendChild(etqP);
        etqP.innerHTML=message;

    }
}
console.log("");

function mostrarImagen() {

}
function deleteCookie() {
    debugger
    alert("hola")

    document.cookie = "password=; expires=Thu, 01 Jan 1970 00:00:00 UTC; path=/;";
};




