package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.models.Product;

import java.util.List;

public interface CategoryService {

    public List<Category> getAllProducts();
    public  Category getById(int id);
    public Category getByName(String name);
    public List<Category> getSubCategories(int id);
    public  Category create(Category category);
    public  Category update(int id, Category category);

}
