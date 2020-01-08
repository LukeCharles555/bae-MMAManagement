fighterFirstName = document.getElementById("firstName");
fighterLastName = document.getElementById("secondName");
fighterHeight = document.getElementById("height");
fighterWeight = document.getElementById("weight");

function addNewFighter() {
    axios({
        method: 'post',
        url: 'http://localhost:8080/fighterapp/fighters',
        data: {
            firstName: fighterFirstName,
            lastName: fighterLastName,
            height: fighterHeight,
            weight: fighterWeight
        }
    });
}