package com.example.inventoryproject.controller;

import com.example.inventoryproject.Repository.CategoryRepository;
import com.example.inventoryproject.entity.Product;
import com.example.inventoryproject.service.CategoryService;
import com.example.inventoryproject.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products/{categoryId}")
    public List<Product> getProductsByCategory(@PathVariable("categoryId") long categoryId){
        return productService.findByCategory(categoryId);
    }

    @GetMapping("/product/{id}")
    public Product getProductsById(@PathVariable("id") long id){
        return productService.findById(id);
    }
}
