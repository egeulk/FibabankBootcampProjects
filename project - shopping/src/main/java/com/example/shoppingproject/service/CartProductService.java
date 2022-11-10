package com.example.shoppingproject.service;

import com.example.shoppingproject.dto.CardProductDto;
import com.example.shoppingproject.entity.CartProduct;
import org.springframework.data.repository.CrudRepository;

public interface CartProductService {
    CardProductDto delete(long cartId, long productId);
    public void add(CardProductDto dto);

}
