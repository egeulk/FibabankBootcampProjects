package com.example.shoppingproject.repository;

import com.example.shoppingproject.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {
}
