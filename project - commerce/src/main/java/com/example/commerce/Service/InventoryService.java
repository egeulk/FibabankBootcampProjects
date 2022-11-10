package com.example.commerce.Service;

import com.example.commerce.Entity.Category;
import com.example.commerce.Entity.Product;

import java.util.List;

public interface InventoryService {

    public List<Category> getAllCategories();

    public List<Category> getProductsFromCategory(long categoryId);

    public Product getProductFromId(long id);

}
