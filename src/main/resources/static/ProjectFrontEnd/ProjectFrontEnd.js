const firstName = document.getElementById("firstName");
const secondName = document.getElementById("secondName");
const height = document.getElementById("height");
const weight = document.getElementById("weight");

function submit() {
    let ul = document.getElementById("fightersList");
    let li = document.getElementById("li");
    li.appendChild(document.createTextNode(firstName + " " + secondName));
    ul.appendChild(li);
}