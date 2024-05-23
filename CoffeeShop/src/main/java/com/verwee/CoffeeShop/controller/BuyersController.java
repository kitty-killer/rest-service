package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Buyers;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.BuyersService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/buyers")
@AllArgsConstructor
public class BuyersController extends AbstractController<Buyers> {

    private final BuyersService buyersService;

    @Override
    protected AbstractService<Buyers> getService() {
        return buyersService;
    }

    @GetMapping("/phone/{phoneNumber}")
    public Buyers findByPhoneNumber(@PathVariable String phoneNumber) {
        return buyersService.findByPhoneNumber(phoneNumber);
    }

    // Пример вычисляемого поля
    @GetMapping("/top-buyers")
    public List<Buyers> findTopBuyers(@RequestParam int threshold) {
        //  топ-покупатели - это те, у кого скидка выше заданного порога
        return buyersService.findAll()
                .stream()
                .filter(buyer -> buyer.getSale() > threshold)
                .collect(Collectors.toList());
    }




}
