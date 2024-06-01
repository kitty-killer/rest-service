package com.verwee.CoffeeShop.service.impl;

import com.verwee.CoffeeShop.model.Buyers;
import com.verwee.CoffeeShop.model.Goods;
import com.verwee.CoffeeShop.repository.GoodsRepository;
import com.verwee.CoffeeShop.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class GoodsServiceImpl implements GoodsService {

    private final GoodsRepository goodsRepository;

    @Override
    public List<Goods> findAll() {
        return goodsRepository.findAll();
    }

    @Override
    public Goods save(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public Goods update(Goods goods) {
        return goodsRepository.save(goods);
    }

    @Override
    public void deleteById(Integer Id) {
        goodsRepository.deleteById(Id);
    }

    @Override
    public Goods findMostPopular() {
        return goodsRepository.findAll()
                .stream()
                .max(Comparator.comparingInt(Goods::getQuantity))
                .orElse(null);
    }
    @Override
    public List<Goods> findByBuyer(Buyers buyer) {
        return goodsRepository.findByBuyer(buyer);
    }
    @Override
    public List<Goods> findGoodsWithLowStock(int threshold) {
        return goodsRepository.findAll()
                .stream()
                .filter(goods -> goods.getQuantity() < threshold)
                .collect(Collectors.toList());
    }
}
