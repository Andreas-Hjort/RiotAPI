package com.example.demo.repositories;


import com.example.demo.controllers.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
   public interface MatchesRepository extends JpaRepository<Matches,Long> {
    }
