package com.example.demo.service;

import com.example.demo.java.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Override
    public Product find(long productId) {
        Product product = new Product(productId, "Masa", 2453);
        System.out.println("Urun bulundu: " + product.getProductId() + product.getProductName() + product.getSalesPrice());
        return product;
    }

    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<Product>();
        products.add(new Product(301, "Cep Telefonu", 1450));
        products.add(new Product(302, "Dizustu Bilgisayar", 6575));
        products.add(new Product(303, "Masaustu Bilgisayar", 3490));
        return products;
    }

    @Override
    public void createProduct(Product product) {
        System.out.println("urun eklendi" + product.getProductId() + product.getProductName() + product.getSalesPrice());
    }

    @Override
    public void updateProduct(Product product) {
        System.out.println("urun guncellendi" + product.getProductId() + product.getProductName() + product.getSalesPrice());
    }

    @Override
    public void deleteProduct(long productId) {
        System.out.println("urun silindi" + productId);
    }
}
