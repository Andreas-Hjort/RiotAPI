package com.example.demo.controllers;

import com.example.demo.models.Summoner;
import com.example.demo.models.Match;
import com.example.demo.repositories.MatchesRepository;
import com.example.demo.repositories.SummonersRepo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
public class Matches {

    @Autowired
    MatchesRepository matchesRepository;

    @Autowired
    SummonersRepo summonersRepo;

    private static final String BASE_URL = "https://europe.api.riotgames.com/lol/match/v5/matches/";
    private static final String APIKEY = "&RGAPI-0987dd10-4fa1-4377-a0e3-16cdeebf7619";

    //finder alle summoners
    public String importMatches(){

        //finder alle summoners
        for (Summoner summoner : summonersRepo.findAll()) {

            try {
                //bruger Jsoup til at fetch riots api, hvor man kan få matchIds
                Document document = Jsoup.connect(matchesRepository.url + summoner.getPuuId()+
                        matchesRepository.startAndCount + matchesRepository.apikey).ignoreContentType(true).get();

                Elements elements = document.select("body");
                for (Element element: elements) {
                    String eri = element.toString().substring(element.toString().indexOf("[")+1,
                            element.toString().indexOf("]")-1);
                    eri=eri.replace("\"","");
                    String[] eris = eri.split(",");

                    //iterating through each match_id
                    for (String matchid : eris) {
                        String document1 = Jsoup.connect(BASE_URL + matchid + APIKEY).ignoreContentType(true).get().toString();

                        //iterating through each player in the match
                        for (int i = 0; i < 10; i++) {
                            Match match1 = new Match();

                            match1.setMatchId(matchid);
                            String summonerName = document1.substring(document1.indexOf("\"summonerName\":")+16
                                    ,document1.indexOf("\",\"teamEarlySurrendered\":"));
                            match1.setSummonerName(summonerName);

                            //Virker lortet?
                            int kills = Integer.parseInt(document1.substring(document1.indexOf("\"kills\":")+8,
                                    document1.indexOf(",\"lane\"")));
                            match1.setKills(kills);


                            int deaths = Integer.parseInt(document1.substring(document1.indexOf("\"deaths\":")+9,
                                    document1.indexOf(",\"detectorWardsPlaced\"")));
                            match1.setDeaths(deaths);

                            document1 = document1.substring(document1.indexOf("\"win\":")+6);
                            boolean win = Boolean.parseBoolean(document1.substring(0,document1.indexOf("}")));
                            match1.setWin(win);

                            // String puuid = document1.substring(document1.indexOf("\"puuid\":")+9,document1.indexOf("\",\"quadraKills"));
                            // match1.setPuuid(puuid);

                            matchesRepository.save(match1);

                        }

                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return "Did it work?";
    }

    @GetMapping("/matches")
    public List<Match> findAllMatches(){
        return matchesRepository.findAll();
    }

    @GetMapping("/matches/{id}")
    public Match findMatchById(@PathVariable long id){
        return matchesRepository.findById(id).get();
    }

    @DeleteMapping("/matches/{id}")
    public void deleteById(@PathVariable long id){
        matchesRepository.deleteById(id);
    }

    @PatchMapping("/matches/{id}")
    public String patchById(@PathVariable long id, @RequestBody Match matchToPatch){
        return matchesRepository.findById(id).map(foundMatch -> {
            if(matchToPatch.getDeaths()!=-1)foundMatch.setDeaths(matchToPatch.getDeaths());
            if(matchToPatch.getKills()!=-1)foundMatch.setKills(matchToPatch.getKills());
            if(matchToPatch.getSummonerName()!=null)foundMatch.setSummonerName(matchToPatch.getSummonerName());
            if(matchToPatch.isWin()==false)foundMatch.setWin(matchToPatch.isWin());
            matchesRepository.save(foundMatch);
            return "match has been patched";
        }).orElse("match has not been patched");
    }

    @PostMapping("/matches")
    public Match addMatch(@RequestBody Match newMatch){
        return matchesRepository.save(newMatch);
    }
}





