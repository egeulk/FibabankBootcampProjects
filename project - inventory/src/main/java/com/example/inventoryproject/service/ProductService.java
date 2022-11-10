package com.example.inventoryproject.service;

import com.example.inventoryproject.entity.Product;

import java.util.List;

public interface ProductService {

    public Product findById(Long id);

    public List<Product> findByCategory(Long categoryId);

}
