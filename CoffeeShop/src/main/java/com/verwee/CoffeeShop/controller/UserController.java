package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.model.MyUser;
import com.verwee.CoffeeShop.service.AbstractService;
import com.verwee.CoffeeShop.service.impl.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/users")
@AllArgsConstructor
public class UserController extends AbstractController<MyUser> {

    private final UserServiceImpl service;

    @Override
    protected AbstractService<MyUser> getService() {
        return service;
    }


}
