package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.Buyers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyersRepository extends JpaRepository<Buyers, Integer> {
    Buyers findByPhoneNumber(String phoneNumber);

}
