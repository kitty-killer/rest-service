package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Order;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/orders")
@AllArgsConstructor
public class OrderController extends AbstractController<Order> {

    private final OrderService orderService;

    @Override
    protected AbstractService<Order> getService() {
        return orderService;
    }
}
