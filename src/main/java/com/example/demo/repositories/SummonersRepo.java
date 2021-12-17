package com.example.demo.repositories;

import com.example.demo.models.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonersRepo extends JpaRepository<Summoner, String> {

    String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    String apikey = "?RGAPI-0987dd10-4fa1-4377-a0e3-16cdeebf7619";
    String[] usernames = {"EFFED UR B SUP", "Hjortyy", "Raiden Shogun C2", "Dzukill",
            "DMONEY1917", "ClintSheeshwood", "Mr Leslie Chow", "thebausffs"};
}
