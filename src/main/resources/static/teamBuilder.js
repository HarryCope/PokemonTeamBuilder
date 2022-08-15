
const pokeUrl = "http://localhost:8080/home";
const editTeamRemovePokemon = document.querySelector("#editTeamRemovePokemon");
const addPokemonToTeamSelect = document.querySelector("#addPokemonToTeamSelect");
const editPokemonSelect = document.querySelector("#editPokemonSelect");
const modal = document.querySelector('#my-modal');
const addButton = document.getElementById('#add-button');
const closeButton = document.querySelector('.close');
const addPokemon = document.querySelector('.btn btn-primary');

const newPokemonName = document.getElementById('newPokemonName');
const newPokemonType = document.getElementById('newPokemonType');
const newPokemonLevel = document.getElementById('newPokemonLevel');
const newPokemonHeldItem = document.getElementById('newPokemonHeldItem');

const editPokemonId = document.getElementById('updatePokemonId');
const editPokemonName = document.getElementById('updatePokemonName');
const editPokemonType = document.getElementById('updatePokemonType');
const editPokemonLevel = document.getElementById('updatePokemonLevel');
const editPokemonHeldItem = document.getElementById('updatePokemonHeldItem');

const deletePokemonId = document.getElementById('deletePokemonId');

const readPokemon = () => {
	
	fetch(`${pokeUrl}/getPokemon`)
            .then(function (response) {
                return response.json();
            })
            .then(function (data) {				
                appendData(data);
            })
            .catch(function (err) {
                console.log('error: ' + err);
            });
        function appendData(data) {
            var mainContainer = document.getElementById("myData");
            mainContainer.textContent = '';
            for (var i = 0; i < data.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = 'Name: ' + data[i].name + '  Type: ' + data[i].type + '  Level: ' + data[i].level + '  Held Item: ' + data[i].heldItem;
                mainContainer.appendChild(div);
                }
                }
               };
    

const createPokemon = () => {
    const newPokemonNameCreate = newPokemonName.value;
    const newPokemonTypeCreate = newPokemonType.value;
    const newPokemonLevelCreate = newPokemonLevel.value;
    const newPokemonHeldItemCreate = newPokemonHeldItem.value;

    let data = {
        "name": newPokemonNameCreate,
        "type": newPokemonTypeCreate,
        "level": newPokemonLevelCreate,
        "heldItem": newPokemonHeldItemCreate
    }
    console.log(data)

    fetch(`${pokeUrl}/createPokemon`, {
        method: "POST",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model);
            readPokemon();
        })
        .catch(err => console.error(`error ${err}`));
};

const updatePokemon = () => {
    const editPokemonIdUpdate = editPokemonId.value;
    const editPokemonNameUpdate = editPokemonName.value;
    const editPokemonTypeUpdate = editPokemonType.value;
    const editPokemonLevelUpdate = editPokemonLevel.value;
    const editPokemonHeldItemUpdate = editPokemonHeldItem.value;

    let data = {
        "name": editPokemonNameUpdate,
        "type": editPokemonTypeUpdate,
        "level": editPokemonLevelUpdate,
        "heldItem": editPokemonHeldItemUpdate
    }

    fetch(`${pokeUrl}/updatePokemon/${editPokemonIdUpdate}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model)
            readPokemon();
        })
        .catch(err => console.error(`error ${err}`));
};

const deletePokemon = () => {
    const editPokemonIdDelete = deletePokemonId.value;

    fetch(`${pokeUrl}/deletePokemon/${editPokemonIdDelete}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => console.log(response))
        .then(() => {
            console.log("Deleted pokemon successfully");
            readPokemon();
        })
        .catch(err => console.error(`error ${err}`));
};
