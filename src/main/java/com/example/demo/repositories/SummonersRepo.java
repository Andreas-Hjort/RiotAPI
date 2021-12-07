package com.example.demo.repositories;

import com.example.demo.models.Summoner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SummonersRepo extends JpaRepository<Summoner, Long> {
}
