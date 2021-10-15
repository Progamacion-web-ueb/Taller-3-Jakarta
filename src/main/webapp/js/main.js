


let name = "request" + "=";
let cookies = document.cookie
let decodedCookie = decodeURIComponent(cookies);
let ca = decodedCookie.split(';');
let userName;

for(let i = 0; i <ca.length; i++) {
    let c = ca[i];

    let part = c.split('=');
    if(part[0]===" username"){
        userName=part[1]
    }

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

let part = userName.split('@');
    userName=part[0];

let part1 = userName.split('"');
userName=part1[1];

let a = document.createElement("a");
document.getElementById("userName").appendChild(a);
a.innerHTML= "Usuario "+userName;

let h1 = document.createElement("h1");
document.getElementById("header-username").appendChild(h1);
h1.innerHTML= "Usuario "+userName;

function deleteCookie() {
    let key1="password";
    document.cookie = key1 + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    let key2="username";
    document.cookie = key2 + '=;expires=Thu, 01 Jan 1970 00:00:01 GMT;';
    let url=(location.href);
    console.log(url);
    let part = url.split('/');
    console.log(part);
    url=part[0]+"//"+part[2]+"/"+part[3]+"/";
    window.location.href = url;
}






