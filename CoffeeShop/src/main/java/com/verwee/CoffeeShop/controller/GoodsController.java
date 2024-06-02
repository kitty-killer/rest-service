package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Goods;
import com.verwee.CoffeeShop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/goods")
public class GoodsController extends AbstractController<Goods> {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @Override
    protected GoodsService getService() {
        return goodsService;
    }
    @GetMapping("/most-popular")
    public Goods findMostPopular() {
        return goodsService.findMostPopular();
    }
    @GetMapping("/low-stock")
    public ResponseEntity<List<Goods>> findGoodsWithLowStock(@RequestParam int threshold) {
        List<Goods> lowStockGoods = goodsService.findGoodsWithLowStock(threshold);

        if (lowStockGoods.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(lowStockGoods);
    }
}
