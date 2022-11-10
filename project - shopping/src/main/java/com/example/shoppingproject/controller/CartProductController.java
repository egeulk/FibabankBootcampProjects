package com.example.shoppingproject.controller;

import com.example.shoppingproject.dto.CardProductDto;
import com.example.shoppingproject.service.CartProductService;
import com.example.shoppingproject.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/shopping")
public class CartProductController {

    private CartProductService cartProductService;

    @Autowired
    public CartProductController(CartProductService cartProductService){
        this.cartProductService = cartProductService;
    }


    @DeleteMapping("/cart/{cartId}/remove/{productId}")
    public void removeFromCard(@PathVariable("cartId") long cartId, @PathVariable("productId")
    long productId){
        cartProductService.delete(cartId, productId);
    }

    @PostMapping("/cart/add")
    public void addToCard(CardProductDto cardProductDto){
        cartProductService.add(cardProductDto);
    }

}
