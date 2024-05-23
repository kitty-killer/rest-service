package com.verwee.CoffeeShop.model;

import jakarta.persistence.*;
import lombok.Data;


@Data
@Entity
@Table(name = "menus")

public class Menu {
    @Id
    @GeneratedValue
    private Integer Id;
    private String positionName;

}
