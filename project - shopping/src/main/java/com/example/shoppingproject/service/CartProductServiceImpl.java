package com.example.shoppingproject.service;

import com.example.shoppingproject.dto.CardProductDto;
import com.example.shoppingproject.entity.CartProduct;
import com.example.shoppingproject.repository.CartProductRepository;
import com.example.shoppingproject.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartProductServiceImpl implements CartProductService{

    private CartProductRepository cartProductRepository;
    @Autowired
    public CartProductServiceImpl(CartProductRepository cartProductRepository){
        this.cartProductRepository = cartProductRepository;
    }

    @Override
    public CardProductDto delete(long cartId, long productId) {
        CartProduct cartProduct = cartProductRepository.findByCartAndCartProductId(cartId, productId).get(0);
        cartProductRepository.delete(cartProduct);
        return cartToDto(cartProduct);
    }

    public void add(CardProductDto dto) {
        CartProduct cartProduct = dtoToCart(dto);
        cartProductRepository.save(cartProduct);
    }

    private CardProductDto cartToDto(CartProduct cartProduct){
        CardProductDto dto = new CardProductDto(cartProduct.getCart(), cartProduct.getProductId(), cartProduct.getSalesQuantity(), cartProduct.getSalesPrice());
        dto.setCartProductId(cartProduct.getCartProductId());
        return dto;
    }

    private CartProduct dtoToCart(CardProductDto cardProductDto){
        CartProduct cardProduct = new CartProduct(cardProductDto.getCart(), cardProductDto.getProductId(), cardProductDto.getSalesQuantity(), cardProductDto.getSalesPrice());
        cardProduct.setCartProductId(cardProductDto.getCartProductId());
        return cardProduct;
    }
}
