package com.example.demo.repositories;

import com.example.demo.models.Champion;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ChampionsRepo extends JpaRepository<Champion,Long> {
}
