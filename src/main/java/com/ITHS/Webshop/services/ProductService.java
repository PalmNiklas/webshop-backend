package com.ITHS.Webshop.services;

import com.ITHS.Webshop.models.Product;

import java.util.List;

public interface ProductService {

    public List<Product> getAllProducts();
    public  Product getById(int id);
    public Product getByName(String name);
    public List<Product> getProductsByCategory(int categoryId);
    public  Product create(Product product);
    public  Product update(Product product);

}
