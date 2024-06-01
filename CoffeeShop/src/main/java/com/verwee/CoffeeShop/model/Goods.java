package com.verwee.CoffeeShop.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Data
    @Entity
    @Table(name = "goods")

    public class Goods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    @Column(unique = true)
    private String name;
    private Float coasts;
    private Integer quantity;
    private String ingredients;
    @ManyToOne
    @JoinColumn(name = "barista_id")
    private Barista barista;

    @ManyToOne
    @JoinColumn(name = "buyer_id")
    private Buyers buyer;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "menu_id")
    private Menu menu;
}



