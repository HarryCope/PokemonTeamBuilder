
const pokeUrl = "http://localhost:8080/home";
const editTeamRemovePokemon = document.querySelector("#editTeamRemovePokemon");
const addPokemonToTeamSelect = document.querySelector("#addPokemonToTeamSelect");
const editPokemonSelect = document.querySelector("#editPokemonSelect");
const modal = document.querySelector('#my-modal');
const addButton = document.getElementById('#add-button');
const closeButton = document.querySelector('.close');
const addPokemon = document.querySelector('.btn btn-primary');
//const pokemonListItem = document.querySelector("#tdlAccordionFlush");

const newPokemonName = document.getElementById('newPokemonName');
const newPokemonType = document.getElementById('newPokemonType');
const newPokemonLevel = document.getElementById('newPokemonLevel');
const newPokemonHeldItem = document.getElementById('newPokemonHeldItem');


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
            for (var i = 0; i < data.length; i++) {
                var div = document.createElement("div");
                div.innerHTML = 'Name: ' + data[i].name + ' ' + data[i].type + ' ' + data[i].level + ' ' + data[i].heldItem;
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
    const editPokemonId = editPokemonSelect.value;
    const editPokemonName = editPokemonName.value;
    const editPokemonType = editPokemonType.value;
    const editPokemonLevel = editPokemonLevel.value;
    const editPokemonHeldItem = editPokemonHeldItem.value;

    let data = {
        "name": editPokemonName,
        "type": editPokemonType,
        "level": editPokemonLevel,
        "heldItem": editPokemonHeldItem
    }

    fetch(`${pokeUrl}/updatePokemon/${editPokemonId}`, {
        method: "PUT",
        body: JSON.stringify(data),
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => response.json())
        .then(model => {
            console.log(model)
            refresh();
        })
        .catch(err => console.error(`error ${err}`));
};

const deletePokemon = () => {
    const editPokemonId = editPokemonSelect.value;

    fetch(`${pokeUrl}/delete/${editPokemonId}`, {
        method: "DELETE",
        headers: {
            "Content-Type": "application/json"
        }
    })
        .then(response => console.log(response))
        .then(() => {
            console.log("Delete successful");
            refresh();
        })
        .catch(err => console.error(`error ${err}`));
};
