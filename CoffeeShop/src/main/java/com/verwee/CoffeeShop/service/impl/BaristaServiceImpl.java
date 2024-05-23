package com.verwee.CoffeeShop.service.impl;

import com.verwee.CoffeeShop.model.Barista;
import com.verwee.CoffeeShop.repository.BaristaRepository;
import com.verwee.CoffeeShop.service.BaristaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BaristaServiceImpl implements BaristaService {
    private final BaristaRepository baristaRepository;

    @Override
    public List<Barista> findAll() {
        return baristaRepository.findAll();
    }

    @Override
    public Barista save(Barista barista) {
        return baristaRepository.save(barista);
    }
    @Override
    public Barista update(Barista barista) {
        return baristaRepository.save(barista);
    }

    @Override
    public void deleteById(Integer Id) {
        baristaRepository.deleteById(Id);
    }

    @Override
    public Barista findByEmail(String email) {
        return baristaRepository.findByEmail(email);
    }
}
