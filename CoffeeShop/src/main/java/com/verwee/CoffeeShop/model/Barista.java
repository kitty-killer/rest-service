package com.verwee.CoffeeShop.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "baristas")
public class Barista {
    @Id
    @GeneratedValue
    private Integer Id;

    @Column(unique = true)
    private String email;

    private String FIO;

    private String job_tittle;

}
