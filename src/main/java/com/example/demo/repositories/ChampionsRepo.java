package com.example.demo.repositories;

import com.example.demo.models.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepo extends JpaRepository<Champion,Long> {
    String url = "https://ddragon.leagueoflegends.com/cdn/11.18.1/data/en_GB/champion.json";
    String apikey = "?RGAPI-0987dd10-4fa1-4377-a0e3-16cdeebf7619";



}
