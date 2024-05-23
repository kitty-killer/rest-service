package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository <Menu, Integer>{
Menu findByPositionName (String positionName);
}
