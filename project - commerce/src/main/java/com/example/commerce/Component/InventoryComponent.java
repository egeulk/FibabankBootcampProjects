package com.example.commerce.Component;

import com.example.commerce.Entity.Category;
import com.example.commerce.Entity.Product;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class InventoryComponent {

    private RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8081/inventory";

    @GetMapping("/commerce/inventory/categories")
    public List<Category> getAllCategories() {
        List<Category> allCategories = restTemplate.getForObject(url + "/categories", List.class );
        return allCategories;
    }


    public List<Category> getProductsFromCategory(long categoryId) {
        String request = url + "/products/" + categoryId;
        List<Category> categoryProducts = restTemplate.getForObject(request, List.class );
        return categoryProducts;
    }

    public Product getProductFromId(long id) {
        String request = url + "/products/" + id;
        Product product = restTemplate.getForObject(request, Product.class );
        return product;
    }
}
