package com.verwee.CoffeeShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
    @Entity
    @Table(name = "goods")

    public class Goods {
    @Id
    @GeneratedValue
    private Integer Id;
    @Column(unique = true)
    private String name;
    private Float coasts;
    private Integer quantity;
    private String ingredients;

}



