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




