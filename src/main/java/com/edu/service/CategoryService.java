package com.edu.service;

import java.util.List;

import com.edu.dao.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    Category getCategoryById(Integer categoryId);
    Category createCategory(Category category);
    void deleteCategory(Integer categoryId);
}
