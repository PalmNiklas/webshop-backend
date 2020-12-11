package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.repositories.CategoryRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> getAllProducts() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(int id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category getByName(String name) {
        return categoryRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public List<Category> getSubCategories(int id) {
        return null;
    }

    @Override
    public Category create(Category category) {
        return categoryRepository.saveAndFlush(category);
    }

    @Override
    public Category update(int id, Category category) {
        Category existingCategory = categoryRepository.getOne(id);
        BeanUtils.copyProperties(category, existingCategory, "id");
        return categoryRepository.saveAndFlush(existingCategory);
    }
}
