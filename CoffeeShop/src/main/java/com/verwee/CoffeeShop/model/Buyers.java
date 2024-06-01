package com.verwee.CoffeeShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
    @Entity
    @Table(name = "bayers")

    public class Buyers {
        @jakarta.persistence.Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)

        private Integer Id;
        @Column(unique = true)
        private String phoneNumber;
        private String FIO;
        private Integer sale;
    @OneToMany(mappedBy = "buyer")
    @JsonIgnore
    private List<Goods> goodsList;

}
