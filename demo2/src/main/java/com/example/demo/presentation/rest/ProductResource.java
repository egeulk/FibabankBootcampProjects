package com.example.demo.presentation.rest;

import com.example.demo.business.dto.ProductDto;
import com.example.demo.business.service.ProductService;
import com.example.demo.data.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductResource {

    private ProductService productService;

    @Autowired
    public ProductResource(ProductService productService){
        this.productService=productService;
    }

    @GetMapping("/product/{id}")
    public ProductDto getProduct(@PathVariable("id") long productId){
        ProductDto product = productService.find(productId);
        return product;
    }

    @PostMapping("/product")
    public ProductDto postProduct(@RequestBody ProductDto product){
        long productId = productService.create(product);
        product.setProductId(productId);
        return product;
    }

    @PutMapping("/product")
    public void putProduct(@RequestBody ProductDto product){
        productService.update(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable("id") long productId){
        productService.delete(productId);
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts(){
        return productService.findAll();
    }
}
