package com.verwee.CoffeeShop.service;

import com.verwee.CoffeeShop.model.Buyers;

import java.util.List;
import java.util.Optional;

public interface BuyersService extends AbstractService<Buyers> {
    Buyers findByPhoneNumber(String phoneNumber);
        List<Buyers> findAll();
        Optional<Buyers> findById(Integer id);

    }


