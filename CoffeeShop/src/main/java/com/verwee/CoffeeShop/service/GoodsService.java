package com.verwee.CoffeeShop.service;

import com.verwee.CoffeeShop.model.Buyers;
import com.verwee.CoffeeShop.model.Goods;

import java.util.List;

public interface GoodsService extends AbstractService<Goods> {
    Goods findMostPopular();
    List<Goods> findGoodsWithLowStock(int threshold);
    List<Goods> findByBuyer(Buyers buyer);

}
