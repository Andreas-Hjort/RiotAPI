const tbodyElement = document.getElementById("champions-tbody");

fetch(baseURL+"/champions")
    .then(response => response.json())
    .then(result => {
        result.map(champions => createTable(champions));
    });


function createTable(champions) {
    const cardElement = document.createElement("tr");
    cardElement.innerHTML = `
        <td>${escapeHTML(champions.championId.toString())}</td>
        <td>${escapeHTML(champions.championName)}</td>
        <td>${escapeHTML(champions.championTitle)}</td>  
    `;

    tbodyElement.appendChild(cardElement);
}