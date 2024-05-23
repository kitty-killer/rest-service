package com.verwee.CoffeeShop.controller;

import com.verwee.CoffeeShop.service.AbstractService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public abstract class AbstractController<T> {

    protected abstract AbstractService<T> getService();

    @GetMapping
    public List<T> findAll() {

        return getService().findAll();
    }

    @PostMapping("save")
    public String save(@RequestBody T entity) {
        getService().save(entity);
        return "Данные успешно сохранены!";
    }

    @PutMapping("update")
    public T update(@RequestBody T entity) {

        String s = "Данные обнавлены";
        return getService().update(entity);
    }

    @DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable ("id") int id) {

        getService().deleteById(id);
        return "удаление успешно!!!";
    }
}

