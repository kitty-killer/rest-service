package com.verwee.CoffeeShop.service.impl;

import com.verwee.CoffeeShop.model.Buyers;
import com.verwee.CoffeeShop.repository.BuyersRepository;
import com.verwee.CoffeeShop.service.BuyersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BuyersServiceImpl implements BuyersService {

    private final BuyersRepository buyersRepository;

    @Override
    public List<Buyers> findAll() {
        return buyersRepository.findAll();
    }

    @Override
    public Buyers save(Buyers buyer) {
        return buyersRepository.save(buyer);
    }

    @Override
    public Buyers update(Buyers buyer) {
        return buyersRepository.save(buyer);
    }

    @Override
    public void deleteById(Integer Id) {
        buyersRepository.deleteById(Id);
    }

    @Override
    public Buyers findByPhoneNumber(String phoneNumber) {
        return buyersRepository.findByPhoneNumber(phoneNumber);
    }
}
