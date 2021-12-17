package com.example.demo.repositories;


import com.example.demo.models.Match;
import org.springframework.data.jpa.repository.JpaRepository;

   public interface MatchesRepository extends JpaRepository<Match,Long> {
}
