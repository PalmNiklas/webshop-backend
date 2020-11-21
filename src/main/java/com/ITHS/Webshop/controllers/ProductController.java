package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.models.Product;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.CategoryRepository;
import com.ITHS.Webshop.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping
    public List<Product> list() {
        return productRepository.findAll();
    }

    @GetMapping
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Product get(@PathVariable String name) {
        return productRepository.findByNameContainsIgnoreCase(name);
    }

    @GetMapping
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable int id) {
        return productRepository.getOne(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody final Product product) {
        categoryRepository.saveAll(product.getCategories());
        return productRepository.saveAndFlush(product);
    }

}
