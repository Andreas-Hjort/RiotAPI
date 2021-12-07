package com.example.demo.repositories;

import com.example.demo.models.Champion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChampionsRepo extends JpaRepository<Champion,Long> {
    String url = "https://ddragon.leagueoflegends.com/cdn/11.18.1/data/en_US/champion.json";
    String apikey = "?api_key=RGAPI-4165caf8-ecd6-46bf-b650-dbeb1b0994c7";



}

