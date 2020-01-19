function readAll() {
    axios.get('/fighterapp/fighters')
    .then(response => {console.log(response.data); makeTable(response.data);});
}

function makeTable(data) {
            let fighters = data;
            let table =
            document.getElementById("tableBody");

            for (let x=0; x < fighters.length; x++) {
                let tr = 
                document.createElement('tr');
                let nameTd = 
                document.createElement('td');
                let heightTd =
                document.createElement('td');
                let weightTd = 
                document.createElement('td');
                let deleteTd = document.createElement('td');
                let editTd = document.createElement('td');

                const fighterName=document.createTextNode(fighters[x].firstName + " " + fighters[x].lastName);
                nameTd.appendChild(fighterName);
                tr.appendChild(nameTd);

                const fighterHeight=document.createTextNode(fighters[x].height);
                heightTd.appendChild(fighterHeight);
                tr.appendChild(heightTd);

                const fighterWeight=document.createTextNode(fighters[x].weight);
                weightTd.appendChild(fighterWeight);
                tr.appendChild(weightTd);

                const deleteBtn = document.createElement('button');
                const editBtn = document.createElement('button');
                deleteBtn.className = 'btn btn-danger';
                editBtn.className = 'btn btn-edit';
                editBtn.id = 'editBtn';
                deleteBtn.type="button";
                editBtn.type='button';
                deleteBtn.addEventListener('click', () => deleteFighterValue(fighters[x].fighterID));
                editBtn.addEventListener('click', () => popFunction(fighters[x].fighterID));
                deleteBtn.innerHTML='Delete Fighter';
                editBtn.innerHTML = 'Edit Fighter';
                deleteTd.appendChild(deleteBtn);
                editTd.appendChild(editBtn);
                tr.appendChild(deleteTd);
                tr.appendChild(editBtn);

                table.appendChild(tr);

            }
        
        
}

function validationCheck() {
    axios.get("/managerapp/manager")
    .then(response => {console.log(response.data); login(response.data);});
}

function login(data) {
    let manager = data;
    let typedUsername = document.getElementById("username");
    let typedPassword = document.getElementById("password");

        for (x=0; x < manager.length; x++)

            if (typedUsername.value===manager[x].username.toString() && typedPassword.value===manager[x].password.toString()) {
                window.location.replace("FighterApp.html");
                console.log(sessionStorage.setItem('managerID',manager[x].managerID));
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
    axios.get('http://localhost:8181/managerapp/manager')
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

function deleteFighter(data) {
    let fighterID = data;
    let deleteFighterFormDiv = document.getElementById("myDeleteFighterForm");

    const deleteFighterForm = document.createElement("form");
    deleteFighterForm.addEventListener('submit', () => deleteFighterValue(fighterID));

    const youSureCheck = document.createElement("h2");
    youSureCheck.innerHTML = "Are you sure you want to delete this fighter?";
    deleteFighterForm.appendChild(youSureCheck);

    const deleteFighterNow = document.createElement("button");
    deleteFighterNow.className = "btn btn-danger";
    deleteFighterNow.type = "submit";
    deleteFighterNow.innerHTML = "DELETE";
    deleteFighterForm.appendChild(deleteFighterNow);

    const closeDeleteFighterWindow = document.createElement("button");
    closeDeleteFighterWindow.className = "btn btn-danger";
    closeDeleteFighterWindow.type = "button";
    closeDeleteFighterWindow.innerHTML = "Close";
    closeDeleteFighterWindow.addEventListener("click", () => deleteFighterFormDiv.removeChild(deleteFighterForm));
   
}

function deleteFighterValue(data) {
    let fighterID = data;
    let confirmMessage = window.confirm("Are you sure you want to delete this fighter?");

    if (confirmMessage) {
        axios.delete('/fighterapp/fighters/' + fighterID)
        .then(response => { console.log(response); })
        window.location = window.location;
    } else {}
    
}

function editFighterValue() {
    let editButton = document.getElementById("editBtn");
    editButton.onclick='popFunction()';

}

function popFunction(data) {

    let fighterID = data;
    let inputWeight=prompt('Enter new weight here');
    inputWeight = parseInt(inputWeight);
    inputWeight = {
        weight: inputWeight
    }
    
    if(inputWeight) {
        axios.patch('/fighterapp/update/' + fighterID, inputWeight)
        .then(response =>
            console.log(response)
        )
        .catch(error =>
            console.log(error)
        );
    }
}


     





