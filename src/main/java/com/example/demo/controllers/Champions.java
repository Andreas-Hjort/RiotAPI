package com.example.demo.controllers;



import com.example.demo.repositories.ChampionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Champions {

    @Autowired
    ChampionsRepo championsRepo;

    @GetMapping("/champFront/import")
    public String (){


    }
}
