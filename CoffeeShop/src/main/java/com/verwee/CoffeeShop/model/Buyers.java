package com.verwee.CoffeeShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
    @Entity
    @Table(name = "bayers")

    public class Buyers {
        @jakarta.persistence.Id
        @GeneratedValue
        private Integer Id;
        @Column(unique = true)
        private String phoneNumber;
        private String FIO;
        private Integer sale;

}
