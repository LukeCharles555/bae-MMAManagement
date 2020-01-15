function getFighter() {
    axios.get('/fighterapp/fighters')
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
            let deleteTd = document.createElement('td');

            tr.setAttribute('name', fighter.firstName + " " + fighter.lastName);

            tr.setAttribute('height', fighter.height);

            tr.setAttribute('weight', fighter.weight);

            tr.setAttribute('fighterID', parseInt(fighter.fighterID));

            tr.addEventListener('click', () =>
            window.location = 
            "FighterStats.html");

            let firstName = fighter.firstName.toString();
            let lastName = fighter.lastName.toString();
            let height = fighter.height.toString();
            let weight = fighter.weight.toString();
            let fighterId = parseInt(fighter.fighterID);
            sessionStorage.setItem('fighterID', fighterId);

            nameTd.innerText = (firstName.charAt(0).toUpperCase() + firstName.substring(1)) + " " + (lastName.charAt(0).toUpperCase() + lastName.substring(1));
            heightTd.innerText = height.charAt(0).toUpperCase() + height.substring(1);
            weightTd.innerText = weight.charAt(0).toUpperCase() + weight.substring(1);
            deleteTd.innerHTML = '<button id="deleteBtn" onclick="deleteFighter()">Delete</button>';

            table.appendChild(tr);
            tr.appendChild(nameTd);
            tr.appendChild(heightTd);
            tr.appendChild(weightTd);
            tr.appendChild(deleteTd);

        })
        })
}

function login() {
    axios.get('/managerapp/manager')
    .then(response => {

        response.data.forEach(manager => {

            let typedUsername = document.getElementById("username");
            let typedPassword = document.getElementById("password");

            if (typedUsername.value===manager.username.toString() && typedPassword.value===manager.password.toString()) {
                window.location.replace("FighterApp.html");
                console.log(sessionStorage.setItem('managerID',manager.managerID));
            } else {
                window.alert("Please enter a valid username and password");
            }
        }).catch(err => console.error(err))
    })
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
        axios.patch('/managerapp/update/' + sessionStorage.getItem('managerID'), newFighter)
        .then(response =>
            console.log(response)
        )
        .catch(error =>
            console.log(error)
        );
    }
}

function capitaliseWord(word) {
    return word.charAt(0).toUpperCase() + word.substring(1).toLowerCase();
}

function showFighterInApp() {
    axios.get('/managerapp/manager/' + sessionStorage.getItem('managerID'))
    .then(response => {

        response.data.fighters.forEach(fighter => {
            let list = document.getElementById("fightersList");
            let li = document.createElement("li");

            li.innerText = capitaliseWord(fighter.firstName) + " " + capitaliseWord(fighter.lastName);

            list.appendChild(li);

        }).catch(err => console.error(err))
    })
}

function signOut() {
    let answer = window.confirm("Are you sure you want to sign out?");
    if (answer) {
        window.location.replace("index.html");
    }
}

function showManagerInApp() {
    axios.get('/managerapp/manager')
    .then(response => {

        response.data.forEach(manager => {
            let list = document.getElementById("managerList");
            let li = document.createElement("li");
            let br = document.createElement("br");

            li.setAttribute('username', manager.username);

            let username = manager.username.toString();

            li.innerText = (username.toString());
            li.appendChild(br);
            list.appendChild(li);

        })
    })
}

// function buttonEventListener() {
//     let deleteAnswer = window.confirm("Are you sure you want to delete this fighter?");
//     if (deleteAnswer) {
//         sessionStorage.setItem('fighterID', fighters.fighterID)
//         deleteFighter()
//     }

//     document.getElementById("deleteBtn").addEventListener("click", deleteAnswer);
// }

// function clickDelete() {
//     window.sessionStorage.setItem('fighterID', fighterId);
//     deleteFighter();
// }

function deleteFighter() {

    let deleteAnswer = window.confirm("Are you sure you want to delete this fighter?");
    if (deleteAnswer) {
        axios.delete('/fighterapp/fighters/' + sessionStorage.getItem('fighterID'))
        .then(response => {
            console.log(response)
        })    
    }
   
}
     





