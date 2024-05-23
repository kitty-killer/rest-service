package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.Barista;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BaristaRepository extends JpaRepository<Barista,Integer> {
    Barista findByEmail(String email);

}
