package com.example.demo.repositories;

import com.example.demo.models.Summoner;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SummonersRepo extends JpaRepository<Summoner, String> {

    String url = "https://euw1.api.riotgames.com/lol/summoner/v4/summoners/by-name/";
    String apikey = "?api_key=RGAPI-0987dd10-4fa1-4377-a0e3-16cdeebf7619";
    String[] usernames = {"erificeret","weedsexlover","death%20by%20arne","dinger%20of%20dongs",
            "kristian%20stoltz","Dawho","denhvem","arnearnearnearne",
            "bigfatbich", "act%20like%20baws"};
}
