package com.example.demo.controllers;

import com.example.demo.models.Summoner;
import com.example.demo.repositories.SummonersRepo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URL;
import java.util.List;

@RestController
public class Summoners {

   @Autowired
    SummonersRepo summoners;

   @GetMapping("/summoners")
   public List<Summoner> showAllSummoners(){
       return summoners.findAll();
   }

    @GetMapping("/summoners/{id}")
    public Summoner showSummonerById(@PathVariable String id){
        return summoners.findById(id).get();
    }

    @DeleteMapping("/summoners{id}")
    public String deleteSummonerById(@PathVariable String id){
       summoners.deleteById(id);
       return "Summoner was deleted";
    }

    @PostMapping("/summoners")
    public String addSummoner(@RequestBody Summoner newSummoner){
        summoners.save(newSummoner);
       return newSummoner + " was added!";
    }

    @PatchMapping("/summoners/{id}")
    public String updateSummonerInfo(@PathVariable String id, @RequestBody Summoner summonerToPatch){
        return summoners.findById(id).map(foundSummoner ->{
            if(summonerToPatch.getAccountId()!=null)foundSummoner.setAccountId(summonerToPatch.getAccountId());
            if(summonerToPatch.getName()!=null)foundSummoner.setName(summonerToPatch.getName());
            if(summonerToPatch.getProfileIconId()!=-1)foundSummoner.setProfileIconId(summonerToPatch.getProfileIconId());
            if(summonerToPatch.getRevisionDate()!=-1)foundSummoner.setRevisionDate(summonerToPatch.getRevisionDate());
            if(summonerToPatch.getSummonerLevel()!=-1)foundSummoner.setSummonerLevel(summonerToPatch.getSummonerLevel());
            summoners.save(foundSummoner);
            return "Summoner was updated!";
        }).orElse("Summoner was not updated! :(");
    }

    @GetMapping("/summoners/import")
    public String importSummonersToDB(){
        for(int i = 0; i < summoners.usernames.length; i++) {

            try {
                ObjectMapper objectMapper = new ObjectMapper();
                Summoner summonerToSave = objectMapper.readValue(new URL(summoners.url +
                        summoners.usernames[i] + summoners.apikey),Summoner.class);
                summoners.save(summonerToSave);

            } catch (IOException e) {
                e.printStackTrace();
                return "Error! " + e;
            }
        }
        return "Summoners was imported to database";
    }
}
