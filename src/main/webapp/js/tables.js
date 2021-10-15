
let name1 = "tables" + "=";
let cookies1 = document.cookie
let decodedCookie1 = decodeURIComponent(cookies1);
let ca1 = decodedCookie1.split(';');
let value;

let cokieData = [ ];

for(let i = 0; i <ca1.length; i++) {
    let c = ca1[i];
    let parts = c.split('=');
    var aux;
    for(aux=1;aux<=100;aux++){
        if(parts[0]===" "+aux||parts[0]===""+aux){
           // while (c.charAt(0) == ' ') {
                c = c.substring(1);
                value =(c.substring(name.length));
                cokieData.push(value);

            //}
        }
    }
}
console.log(cokieData)
/*
let parte1 = value.split('=');
let valueDate=parte1[0];

console.log(parte1[1])
console.log(parte1[2])
*/
//uploads/17010.jpg

let url=(location.href);
let parteUrl = url.split('/Of');

var date;
var petName;
var image;
var urlPath=parteUrl[0]+"/uploads/";

function insertTables() {
    var size=(cokieData.length);
    var aux1;
    cokieData.forEach(function(item, index, array) {
        console.log(item, index)
        let parte1 = item.split('=');
        date=parte1[0];
        petName=parte1[1];
        image=urlPath+parte1[2];

        let td1 = document.createElement("td");
        let td2 = document.createElement("td");
        let td3 = document.createElement("td");
        let tr = document.createElement("tr");
        document.getElementById("tabla-Funcionario").appendChild(tr);
        tr.appendChild(td1);
        tr.appendChild(td2);
        tr.appendChild(td3);
        td1.innerHTML= date;
        td2.innerHTML= petName;
        td3.innerHTML= "<img id=\"imgDB\" src=\""+image+"\"/>";
    })
}




