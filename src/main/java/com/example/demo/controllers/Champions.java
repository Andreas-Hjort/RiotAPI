package com.example.demo.controllers;



import com.example.demo.models.Champion;
import com.example.demo.repositories.ChampionsRepo;
import org.jsoup.internal.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.util.List;

@RestController
public class Champions {

    @Autowired
    ChampionsRepo championsRepo;

    @GetMapping("/champFront/import")
    public String championsImport(){

        try{
           String connectChampions = Jsoup.connect(championsRepo.url).ignoreContentType(true).get().toString();
           int count = StringUtils.countOccurrencesOf(connectChampions, "name");

           for (int i = 0; i < count; i++ ){
               Champion champion = new Champion();

               String loadedChampName = connectChampions.substring(connectChampions.indexOf("name")+8,
                       connectChampions.indexOf("")-2);
               champion.setChampionName(loadedChampName);

               Long loadedChampId = Long.parseLong(connectChampions.substring(connectChampions.indexOf("id")+7,connectChampions.indexOf("")-1));
               champion.setChampionId(loadedChampId);

               String loadedchampTitle = connectChampions.substring(connectChampions.indexOf("title")+9,
                       connectChampions.indexOf("")-1);
               champion.setChampionTitle(loadedchampTitle);

               connectChampions = connectChampions.substring(connectChampions.indexOf("desc")+10);
               championsRepo.save(champion);
           }
        }catch (IOException e){
            e.printStackTrace();
        }

        return "Done";
    }

    @GetMapping("/showchampions.html")
    public List<Champion> findAllMatches(){
        return championsRepo.findAll();
    }

    @GetMapping("/showchampions/{id}")
    public Champion findMatchById(@PathVariable long id){
        return championsRepo.findById(id).get();
    }

    @DeleteMapping("/showchampions/{id}")
    public void deleteById(@PathVariable long id){
        championsRepo.deleteById(id);
    }

    @PatchMapping("/showchampions/{id}")
    public String updateChampionsInfo(@PathVariable Long id, @RequestBody Champion championToPatch){
        return championsRepo.findById(id).map(foundChampion ->{
            if(championToPatch.getChampionId()!=null)foundChampion.setChampionId(championToPatch.getChampionId());
            if(championToPatch.getChampionName()!=null)foundChampion.setChampionName(championToPatch.getChampionName());
            if(championToPatch.getChampionTitle()!=null)foundChampion.setChampionTitle(championToPatch.getChampionTitle());
            championsRepo.save(foundChampion);
            return "champion was patched";
        }).orElse("champion was not patched");
    }
}
