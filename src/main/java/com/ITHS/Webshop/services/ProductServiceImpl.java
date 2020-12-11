package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.models.Product;
import com.ITHS.Webshop.repositories.CategoryRepository;
import com.ITHS.Webshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(int id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product getByName(String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }

    @Override
    public Product create(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product update(Product product) {
        return null;
    }

    @Override
    public List<Product> getProductsByCategory(int categoryId) {
        Category category = categoryRepository.getOne(categoryId);
        Set<Product> products = category.getProducts();
        List<Product> productList = new ArrayList<>();
        productList.addAll(products);
        return productList;
    }
}
