package com.example.commerce.Service;

import com.example.commerce.Component.ShoppingComponent;
import com.example.commerce.Dto.CardProductDto;
import com.example.commerce.Dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShoppingServiceImpl implements ShoppingService {

    @Autowired
    ShoppingComponent shoppingComponent;

    public Long createCart(){
        return shoppingComponent.createCart();
    }

    public void addProduct(CardProductDto dto) {
        shoppingComponent.addProduct(dto);
    }

    public void deleteProduct(Long cardId, Long productId){
        shoppingComponent.deleteProduct(cardId, productId);
    }

    public void checkout(Long cartId) {
        shoppingComponent.checkout(cartId);
    }

    public CartDto find(long id) {
        return shoppingComponent.find(id);
    }
}
