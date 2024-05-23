package com.verwee.CoffeeShop.service.impl;

import com.verwee.CoffeeShop.model.Menu;
import com.verwee.CoffeeShop.repository.MenuRepository;
import com.verwee.CoffeeShop.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
    @AllArgsConstructor
    public class MenuServiceImpl implements MenuService {

    private final MenuRepository menuRepository;

        @Override
        public List<Menu> findAll() {
            return menuRepository.findAll();
        }



    @Override
        public Menu save(Menu menu) {
            return (Menu) menuRepository.save(menu);
        }

        @Override
        public Menu update(Menu menu) {
            return (Menu) menuRepository.save(menu);
        }

    @Override
    public void deleteById(Integer Id) {

    }


        @Override
        public Menu findByPositionName(String positionName) {
            return menuRepository.findByPositionName(positionName);
        }
    }

