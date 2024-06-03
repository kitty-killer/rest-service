package com.verwee.CoffeeShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "baristas")
public class Barista {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;

    @Column(unique = true)
    private String email;

    
    private Integer sallary;// добавление нового поля в бд о зарплате баристы 

    private String FIO;

    private String job_tittle;
    @OneToMany(mappedBy = "barista")
    @JsonIgnore
    private List<Goods> goodsList;

}
