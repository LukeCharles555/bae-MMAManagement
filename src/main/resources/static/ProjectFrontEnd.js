function getFighter() {
    axios.get('http://localhost:8080/fighterapp/fighters')
        .then(response => {
        
        response.data.forEach(fighter => {
            let table =
            document.getElementById("tableBody");
            let tr = 
            document.createElement('tr');
            let nameTd = 
            document.createElement('td');
            let heightTd =
            document.createElement('td');
            let weightTd = 
            document.createElement('td');

            tr.setAttribute('name', fighter.firstName + " " + fighter.lastName);

            tr.setAttribute('height', fighter.height);

            tr.setAttribute('weight', fighter.weight);

            tr.addEventListener('click', () =>
            window.location = 
            "FighterStats.html");

            let firstName = fighter.firstName.toString();
            let lastName = fighter.lastName.toString();
            let height = fighter.height.toString();
            let weight = fighter.weight.toString();

            nameTd.innerText = (firstName.charAt(0).toUpperCase() + firstName.substring(1)) + " " + (lastName.charAt(0).toUpperCase() + lastName.substring(1));
            heightTd.innerText = height.charAt(0).toUpperCase() + height.substring(1);
            weightTd.innerText = weight.charAt(0).toUpperCase() + weight.substring(1);

            table.appendChild(tr);
            tr.appendChild(nameTd);
            tr.appendChild(heightTd);
            tr.appendChild(weightTd);

        }).catch(err => console.error(err));
        })
}

function login() {
    let username = document.getElementById("username").value;
    let password = document.getElementById("password").value;

    if (username=='luke' && password=='password') {
        window.open("FighterApp.html");
    } else {
        window.alert("Please enter a valid username and password");
    }
}

function addNewFighter() {
    let fighterFirstName = document.getElementById("firstName");
    let fighterLastName = document.getElementById("secondName");
    let fighterHeight = document.getElementById("height");
    let fighterWeight = document.getElementById("weight");

    let newFighter = {
        firstName: fighterFirstName.value,
        lastName: fighterLastName.value,
        height: fighterHeight.value,
        weight: fighterWeight.value
    }
    
    if (fighterFirstName.value === "" || fighterLastName.value === "" || fighterHeight.value === "" || fighterWeight.value === "") {
        window.alert("Please make sure all fields are filled");
    } else {

        JSON.stringify(newFighter);
        axios.post('http://localhost:8080/fighterapp/fighters', newFighter)
        .then(response =>
            console.log(response)
        )
        .catch(error =>
            console.log(error)
        );
    }
}

function showFighterInApp() {
    axios.get('http://localhost:8080/fighterapp/fighters')
    .then(response => {

        response.data.forEach(fighter => {
            let list = document.getElementById("fightersList");
            let li = document.createElement("li");

            li.setAttribute('name', fighter.firstName + " " + fighter.lastName);

            let firstName = fighter.firstName.toString();
            let lastName = fighter.lastName.toString();

            li.innerText = (firstName.charAt(0).toUpperCase() + firstName.substring(1)) + " " + (lastName.charAt(0).toUpperCase() + lastName.substring(1));

            list.appendChild(li);

        }).catch(err => console.error(err))
    })
}




