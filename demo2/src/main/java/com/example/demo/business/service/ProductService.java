package com.example.demo.business.service;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.data.entity.Product;

import java.util.List;

public interface ProductService {

    long create(ProductDto productDto);

    void update(ProductDto productDto);

    ProductDto find(long productId);

    List<ProductDto> findAll();

    void delete(long productId);
}
