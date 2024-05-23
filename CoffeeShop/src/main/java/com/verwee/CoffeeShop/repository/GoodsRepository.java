package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.Goods;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GoodsRepository extends JpaRepository<Goods, Integer> {
}
