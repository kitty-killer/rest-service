package com.verwee.CoffeeShop.service;

import java.util.List;

public abstract interface AbstractService<T> {

    public abstract List<T> findAll();

    public abstract T save(T entity);

    public abstract T update(T entity);

    public abstract void deleteById(Integer Id);
}

