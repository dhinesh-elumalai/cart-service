package com.mykart.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mykart.cart.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long>{

}
