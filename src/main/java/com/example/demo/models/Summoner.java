package com.example.demo.models;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
}
