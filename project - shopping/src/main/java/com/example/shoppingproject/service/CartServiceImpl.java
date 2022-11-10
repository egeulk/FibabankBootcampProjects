package com.example.shoppingproject.service;

import com.example.shoppingproject.dto.CardProductDto;
import com.example.shoppingproject.dto.CartDto;
import com.example.shoppingproject.entity.Cart;
import com.example.shoppingproject.entity.CartProduct;
import com.example.shoppingproject.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService{

    private CartRepository cartRepository;

    @Autowired
    public CartServiceImpl(CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }

    @Override
    public long createCart() {
        Cart newCart = new Cart();
        cartRepository.save(newCart);
        return newCart.getCartId();
    }

    @Override
    public void checkout(long cartId) {
        Cart secilmisKart = cartRepository.findById(cartId).get();
        secilmisKart.setCartStatus(Cart.status.BITMIS);
        cartRepository.save(secilmisKart);
    }

    public CartDto find(long cartId){
        Cart cart = cartRepository.findById(cartId).get();
        return CartToDto(cart);
    }

    private CartDto CartToDto(Cart cart){
        CartDto cartDto = new CartDto();
        cartDto.setCartStatus(cart.getCartStatus());
        cartDto.setCustomerName(cart.getCustomerName());
        cartDto.setTotalAmount(cart.getTotalAmount());
        cartDto.setCartId(cart.getCartId());
        cartDto.setCustomerName(cart.getCustomerName());
        return cartDto;
    }



}
