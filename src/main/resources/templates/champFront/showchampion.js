const tbodyElement = document.getElementById("champions-tbody");

fetch(baseURL+"/showchampions")
    .then(response => response.json())
    .then(result => {
        result.map(champions => createTable(champions));
    });


function createTable() {
    const cardElement = document.createElement("tr");
    cardElement.innerHTML = `
        <td>champions.championId.toString()</td>
        <td>champions.championName.toString()</td>
        <td>champions.championTitle.toString()</td>  
    `;

    tbodyElement.appendChild(cardElement);
}