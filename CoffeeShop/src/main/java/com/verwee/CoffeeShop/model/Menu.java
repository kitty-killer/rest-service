package com.verwee.CoffeeShop.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Entity
@Table(name = "menus")

public class Menu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer Id;
    private String positionName;
    @OneToMany(mappedBy = "menu")
    @JsonIgnore
    private List<Goods> goodsList;

}
