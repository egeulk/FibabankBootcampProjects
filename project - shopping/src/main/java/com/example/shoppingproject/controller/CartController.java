package com.example.shoppingproject.controller;

import com.example.shoppingproject.dto.CardProductDto;
import com.example.shoppingproject.dto.CartDto;
import com.example.shoppingproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class CartController {

    private CartService cartService;

    @Autowired
    public CartController(CartService cartService){
        this.cartService = cartService;
    }

    @GetMapping("/cart/create")
    public long createCart(){
        return cartService.createCart();
    }

    @GetMapping("/checkout/{cartId}")
    public void checkout(@PathVariable("cartId") long cartId){
        cartService.checkout(cartId);
    }

    @GetMapping("/cart/find")
    public CartDto findTheCart(long id){
        return cartService.find(id);
    }
}
