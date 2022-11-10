package com.example.demo.resource;

import com.example.demo.java.Product;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable("id") long productId){
        Product product = productService.find(productId);
        return product;
    }

    @PostMapping("/product")
    public Product postProduct(@RequestBody Product product){
        product.setProductId(301);
        productService.createProduct(product);
        return product;
    }

    @PutMapping("/product")
    public void putProduct(@RequestBody Product product){
        productService.updateProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") long productId){
        productService.deleteProduct(productId);
    }

    @GetMapping("/products")
    public List<Product> getProducts(){
        return productService.findAll();
    }
}
