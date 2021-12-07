package com.example.demo.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Set;

@Data
@Table(name ="summoners")
@Entity
@Getter @Setter
public class Summoner {

    @Id
    @Column(nullable = false)
    private String id;

    @Column
    private String accountId;

    @Column
    private String puuId;

    @Column
    private String name;

    @Column
    private int profileIconId;

    @Column
    private long revisionDate;

    @Column
    private int summonerLevel;

    @JsonIgnore
    @OneToMany(mappedBy = "summoner",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Match> match;

}
