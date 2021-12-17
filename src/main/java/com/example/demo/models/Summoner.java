package com.example.demo.models;


import lombok.Data;

import javax.persistence.*;

@Data
@Table(name="summoners")
@Entity
public class Summoner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String summonerId;

    @Column
    private String accountId;

    @Column(nullable = true)
    private String puuId;

    @Column
    private String name;

}

