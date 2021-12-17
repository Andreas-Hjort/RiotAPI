package com.example.demo.controllers;

import com.example.demo.models.Summoner;
import com.example.demo.repositories.SummonersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Summoners {

    @Autowired
    SummonersRepo summoners;

    @GetMapping("/summoners")
    public Iterable<Summoner> getSummoner() {
        return summoners.findAll();
    }

    @GetMapping("/summoners/{id}")
    public Summoner getSummoner(@PathVariable String id) {
        return summoners.findById(id).get();
    }

    @PostMapping("/summoners")
    public Summoner addSummoner(@RequestBody Summoner newSummoner) {
        newSummoner.setId(null);
        return summoners.save(newSummoner);
    }

    @PutMapping("/summoner/{id}")
    public String updateSummoner(@PathVariable String id, @RequestBody Summoner summonerToUpdate){
        if(summoners.existsById(id)) {
            summonerToUpdate.setId(id);
            summoners.save(summonerToUpdate);
            return "Summoner was updated";
        } else {
            return "Summoner not found";
        }
    }

    @PatchMapping("/summoners/{id}")
    public String patchSummoner(@PathVariable String id, @RequestBody Summoner summonerToUpdate) {
        return summoners.findById(id).map( foundSummoner -> {
            if(summonerToUpdate.getSummonerId() != null) foundSummoner.setSummonerId(summonerToUpdate.getName());
            if(summonerToUpdate.getPuuId() != null) foundSummoner.setPuuId(summonerToUpdate.getPuuId());
            if(summonerToUpdate.getName() != null) foundSummoner.setName(summonerToUpdate.getName());
            summoners.save(foundSummoner);
            return "Summoner updated";
        }).orElse("Summoner not found");
    }

    @DeleteMapping("/summoner/{id}")
    public void deleteSummoner(@PathVariable String id) {
        summoners.deleteById(id);
    }

}