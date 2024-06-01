package com.verwee.CoffeeShop.repository;

import com.verwee.CoffeeShop.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository <MyUser,Integer> {
    Optional<MyUser> findByName(String username);

}
