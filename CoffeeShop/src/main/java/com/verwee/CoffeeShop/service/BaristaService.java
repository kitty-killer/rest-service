package com.verwee.CoffeeShop.service;

import com.verwee.CoffeeShop.model.Barista;

public interface BaristaService extends AbstractService<Barista> {
    Barista findByEmail(String email);


}
