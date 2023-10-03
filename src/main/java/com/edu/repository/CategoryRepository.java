package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.dao.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
    // You can add custom query methods if needed
}
