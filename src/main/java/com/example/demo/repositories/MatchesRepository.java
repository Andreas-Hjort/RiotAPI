package com.example.demo.repositories;


import com.example.demo.controllers.Matches;
import com.example.demo.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
   public interface MatchesRepository extends JpaRepository<Match,Long> {

    String apikey = "&api_key=RGAPI-0987dd10-4fa1-4377-a0e3-16cdeebf7619";
    String startAndCount = "/ids?start=0&count=2";
    String url = "https://europe.api.riotgames.com/lol/match/v5/matches/by-puuid/";

}
