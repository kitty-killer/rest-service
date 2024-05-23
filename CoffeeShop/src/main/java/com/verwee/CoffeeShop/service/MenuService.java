package com.verwee.CoffeeShop.service;

import com.verwee.CoffeeShop.model.Menu;

public interface MenuService extends AbstractService<Menu> {
    Menu findByPositionName(String positionName);
}
