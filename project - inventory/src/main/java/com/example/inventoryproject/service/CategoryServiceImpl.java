package com.example.inventoryproject.service;

import com.example.inventoryproject.Repository.CategoryRepository;
import com.example.inventoryproject.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService{

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Category> getAllCategories() {
        Iterable<Category> categories = categoryRepository.findAll();
        List<Category> returnedList = new ArrayList<Category>();
        for(Category category : categories){
            returnedList.add(category);
        }
        return returnedList;

    }
}
