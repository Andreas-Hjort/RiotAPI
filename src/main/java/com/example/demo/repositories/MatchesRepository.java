package com.example.demo.repositories;


import com.example.demo.controllers.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
   public interface MatchesRepository extends JpaRepository<Matches,Long> {

    String apikey = "&api_key=RGAPI-4165caf8-ecd6-46bf-b650-dbeb1b0994c7";
    String startAndCount = "/ids?start=0&count=1";
    String url = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";

}
