package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
