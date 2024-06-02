package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Menu;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/menus")
@AllArgsConstructor
public class MenuController extends AbstractController<Menu> {

    private final MenuService menuService;

    @Override
    protected AbstractService<Menu> getService() {
        return menuService;
    }

    @GetMapping("/position/{positionName}")
    public ResponseEntity<Menu> findByPositionName(@PathVariable String positionName) {
        Menu menu = menuService.findByPositionName(positionName);

        if (menu == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(menu);
    }
}
