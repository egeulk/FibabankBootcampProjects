package com.example.inventoryproject.service;

import com.example.inventoryproject.Repository.ProductRepository;
import com.example.inventoryproject.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{
    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product findById(Long id){
        Optional<Product> Sonuc = productRepository.findById(id);
        return Sonuc.get();
    }

    public List<Product> findByCategory(Long categoryId){
        return productRepository.findByCategory(categoryId);
    }
}
