const queryString = window.location.search;
const URLParams = new URLSearchParams(queryString);
const matchId = URLParams.get("matchId");
const divElement = document.getElementById("matches-div");

fetch(baseURL+"/matches/"+matchId)
    .then(response => response.json())
    .then(result => {
        document.getElementById("summoner-name").innerText = result.summonerName;
        document.getElementById("win").innerText = result.win;
        document.getElementById("kills").innerText = result.kills;
        document.getElementById("deaths").innerText = result.deaths;
        document.getElementById("matchId").innerText = result.matchId;
    })

