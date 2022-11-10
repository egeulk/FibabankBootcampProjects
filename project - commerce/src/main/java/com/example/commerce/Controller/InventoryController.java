package com.example.commerce.Controller;

import com.example.commerce.Entity.Category;
import com.example.commerce.Entity.Product;
import com.example.commerce.Service.InventoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryServiceImpl inventoryServiceImpl;

    @GetMapping("/commerce/inventory/categories")
    public List<Category> getCategories(){
        return inventoryServiceImpl.getAllCategories();
    }


    @GetMapping("/commerce/inventory/products/{categoryId}")
    public List<Category> getProductsFromCategory(@PathVariable("categoryId") long categoryId) {
        return inventoryServiceImpl.getProductsFromCategory(categoryId);
    }

    @GetMapping("/commerce/inventory/product/{id}")
    public Product getProductFromId(@PathVariable("id") long id) {
        return inventoryServiceImpl.getProductFromId(id);
    }









    }
