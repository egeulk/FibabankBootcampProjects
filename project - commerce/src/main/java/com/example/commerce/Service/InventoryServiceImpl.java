package com.example.commerce.Service;

import com.example.commerce.Component.InventoryComponent;
import com.example.commerce.Entity.Category;
import com.example.commerce.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryServiceImpl implements InventoryService{
    @Autowired
    InventoryComponent inventoryComponent;


    public List<Category> getAllCategories() {
        return inventoryComponent.getAllCategories();
    }

    public List<Category> getProductsFromCategory(long categoryId) {
        return inventoryComponent.getProductsFromCategory(categoryId);
    }

    public Product getProductFromId(long id) {
        return inventoryComponent.getProductFromId(id);
    }
}
