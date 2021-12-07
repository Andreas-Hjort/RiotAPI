package com.example.demo.repositories;

import com.example.demo.models.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonersRepo extends JpaRepository<Summoner, String> {

    String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    String apikey = "?api_key=RGAPI-4165caf8-ecd6-46bf-b650-dbeb1b0994c7";
    String[] usernames = {"Æggemeister3000", "Hjortyy", "Raiden Shogun C2", "Dzukill",
            "DMONEY1917", "ClintSheeshwood", "Mr Leslie Chow", "thebausffs"};
}
