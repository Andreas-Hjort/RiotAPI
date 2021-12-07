package com.example.demo.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.*;

@Data
@Table(name = "champions")
@Entity
@Getter @Setter
public class Champion {

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
