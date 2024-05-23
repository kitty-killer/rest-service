package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.Barista;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.BaristaService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/baristas")
@AllArgsConstructor
public class BaristaController extends AbstractController<Barista> {

    private final BaristaService BaristaService;
    @Override
    protected AbstractService<Barista> getService() {
        return BaristaService;
    }
    @GetMapping("/{Email}")
    public Barista findByEmail(@PathVariable String Email) {
        return BaristaService.findByEmail(Email);
    }

}
