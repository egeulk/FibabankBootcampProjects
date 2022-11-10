package com.example.commerce.Service;

import com.example.commerce.Dto.CardProductDto;
import com.example.commerce.Dto.CartDto;

public interface ShoppingService {

    public Long createCart();

    public void addProduct(CardProductDto dto);

    public void deleteProduct(Long cardId, Long productId);

    public void checkout(Long cartId);

    public CartDto find(long id);
}
