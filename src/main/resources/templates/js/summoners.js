const tbodyElement = document.getElementById("summoner-tbody");

fetch(baseURL+"/summoners")
    .then(response => response.json())
    .then(result => {
        result.map(summoner => createTable(summoner));
    });


function createTable(summoner) {
    const cardElement = document.createElement("tr");
    cardElement.innerHTML = `
        <td>${escapeHTML(summoner.name)}</td>
        <td>${escapeHTML(summoner.accountId)}</td>
        <td>${escapeHTML(summoner.summonerLevel.toString())}</td>
        <td>${escapeHTML(summoner.puuid)}</td>
        <td>${escapeHTML(summoner.profileIconId.toString())}</td>
        <td>${escapeHTML(summoner.revisionDate.toString())}</td>
        
        
    `;

    tbodyElement.appendChild(cardElement);
}