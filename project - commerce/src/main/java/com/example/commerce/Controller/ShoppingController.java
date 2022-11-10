package com.example.commerce.Controller;

import com.example.commerce.Dto.CardProductDto;
import com.example.commerce.Dto.CartDto;
import com.example.commerce.Service.ShoppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class ShoppingController {

    @Autowired
    ShoppingService shoppingService;

    @GetMapping("/commerce/shopping/cart/create")
    public long createCart(){
        return shoppingService.createCart();
    }

    @PostMapping("/commerce/shopping/cart/add")
    public void addProduct(@RequestBody CardProductDto dto){
        shoppingService.addProduct(dto);
    }

    @DeleteMapping("/commerce/shopping/cart/{cartId}/remove/{productId}")
    public void deleteProduct(@PathVariable("cartId") long cartId, @PathVariable("productId") long productId){
        shoppingService.deleteProduct(cartId, productId);
    }

    @GetMapping("/commerce/shopping/checkout/{cartId}")
    public void checkoutCart(@PathVariable("cartId") long cartId){
        shoppingService.checkout(cartId);
    }

    @GetMapping("/commerce/shopping/cart/find/")
    public CartDto findCart(){
        return shoppingService.find(0);
    }
}
