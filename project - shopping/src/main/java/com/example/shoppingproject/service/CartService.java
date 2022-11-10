package com.example.shoppingproject.service;

import com.example.shoppingproject.dto.CartDto;

public interface CartService {
    public long createCart();

    public void checkout(long cartId);

    public CartDto find(long cartId);
}
