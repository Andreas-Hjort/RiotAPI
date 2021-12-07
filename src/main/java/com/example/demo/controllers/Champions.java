package com.example.demo.controllers;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Table(name = "champions")
@Entity
@Getter @Setter
public class Champions {

    @Id
    @Column
    private Long championId;

    @Column
    private String championName;

    @Column
    private String championTitle;

    @Column
    private String championDesc;
}
