package com.example.demo.controllers;

import com.example.demo.repositories.ChampionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.demo.models.Champion;
import com.example.demo.models.Summoner;
import com.example.demo.repositories.MatchesRepository;
import com.example.demo.repositories.SummonersRepo;
import com.example.demo.repositories.MatchesRepository;
@RestController
public class Champions {

    @Autowired
    ChampionsRepo champions;


    @GetMapping("/champions")
    public Iterable<Champion> getChampion() {
        return champions.findAll();
    }

    @GetMapping("/champions/{id}")
    public Champion getChampion(@PathVariable Long id) {
        return champions.findById(id).get();
    }

    @PostMapping("/champions")
    public Champion addChampion(@RequestBody Champion newChampion) {
        return champions.save(newChampion);
    }

    @PutMapping("/champions/{id}")
    public String updateChampion(@PathVariable Long id, @RequestBody Champion championToUpdate) {
        if (champions.existsById(id)) {
            championToUpdate.setId(id);
            champions.save(championToUpdate);
            return "Champion was updated";
        } else {
            return "Champion not found";
        }
    }

    @PatchMapping("/champions/{id}")
    public String patchChampion(@PathVariable Long id, @RequestBody Champion championToUpdate) {
        return champions.findById(id).map(foundChampion -> {
            if (championToUpdate.getChampionId() != null) foundChampion.setChampionId(championToUpdate.getChampionId());
            if (championToUpdate.getChampionName() != null)
                foundChampion.setChampionName(championToUpdate.getChampionName());
            if (championToUpdate.getChampionImage() != null)
                foundChampion.setChampionImage(championToUpdate.getChampionImage());
            champions.save(foundChampion);
            return "Champion updated";
        }).orElse("Champion not found");
    }

    @DeleteMapping("/champions/{id}")
    public void deleteChampion(@PathVariable Long id) {
        champions.deleteById(id);
    }

    @DeleteMapping("/champions/delete/all")
    public void deleteAllChampions() {
        champions.deleteAll();
    }
}
