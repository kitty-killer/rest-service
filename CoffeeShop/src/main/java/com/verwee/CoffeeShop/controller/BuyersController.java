package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Buyers;
import com.verwee.CoffeeShop.model.Goods;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.BuyersService;
import com.verwee.CoffeeShop.service.GoodsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/buyers")
@AllArgsConstructor
public class BuyersController extends AbstractController<Buyers> {

    private final BuyersService buyersService;

    private final GoodsService goodsService;
    @Override
    protected AbstractService<Buyers> getService() {
        return buyersService;
    }

    @GetMapping("/phone/{phoneNumber}")
    public ResponseEntity<Buyers> findByPhoneNumber(@PathVariable String phoneNumber) {
        Buyers buyer = buyersService.findByPhoneNumber(phoneNumber);
        if (buyer == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(buyer);
    }

    @GetMapping("/{buyerId}/popular-item")
    public ResponseEntity<Map<String, Object>> getPopularItemByBuyer(@PathVariable Integer buyerId) {
        Optional<Buyers> optionalBuyer = buyersService.findById(buyerId);
        if (optionalBuyer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Buyers buyer = optionalBuyer.get();
        List<Goods> goodsList = goodsService.findByBuyer(buyer);

        // Находим наиболее популярный товар и его количество
        Optional<Map.Entry<String, Integer>> maxEntry = goodsList.stream()
                .collect(Collectors.groupingBy(Goods::getName, Collectors.summingInt(Goods::getQuantity)))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue());

        if (maxEntry.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        String popularItem = maxEntry.get().getKey();
        int quantity = maxEntry.get().getValue();

        // Формируем ответ
        Map<String, Object> result = new HashMap<>();
        result.put("itemName", popularItem);
        result.put("quantity", quantity);

        return ResponseEntity.ok(result);
    }

    @GetMapping("/top-buyers")
    public ResponseEntity<List<Buyers>> findTopBuyers(@RequestParam int threshold) {
        List<Buyers> topBuyers = buyersService.findAll()
                .stream()
                .filter(buyer -> buyer.getSale() > threshold)
                .collect(Collectors.toList());

        if (topBuyers.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(topBuyers);
    }
    @GetMapping("/total-sales")
    public int getTotalSales() {
        // Вычисление общей суммы скидок всех покупателей
        return buyersService.findAll()
                .stream()
                .mapToInt(Buyers::getSale)
                .sum();
    }




}
