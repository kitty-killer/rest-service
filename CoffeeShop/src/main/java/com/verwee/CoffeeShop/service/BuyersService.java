package com.verwee.CoffeeShop.service;

import com.verwee.CoffeeShop.model.Buyers;

public interface BuyersService extends AbstractService<Buyers> {
    Buyers findByPhoneNumber(String phoneNumber);
}
