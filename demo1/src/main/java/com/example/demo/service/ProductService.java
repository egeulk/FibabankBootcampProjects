package com.example.demo.service;

import com.example.demo.java.Product;

import java.util.List;

public interface ProductService {

    Product find(long productId);

    List<Product> findAll();

    void createProduct(Product product);

    void updateProduct(Product product);

    void deleteProduct(long productId);

}
