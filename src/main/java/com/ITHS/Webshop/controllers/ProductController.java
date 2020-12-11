package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.models.Product;
import com.ITHS.Webshop.models.User;
import com.ITHS.Webshop.repositories.CategoryRepository;
import com.ITHS.Webshop.repositories.ProductRepository;
import com.ITHS.Webshop.services.OrderStatusService;
import com.ITHS.Webshop.services.ProductServiceImpl;
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
    private ProductServiceImpl productService;



    @GetMapping
    public List<Product> list() {
        return productService.getAllProducts();
    }

    @GetMapping
    @RequestMapping(value = "/cat/{categoryId}", method = RequestMethod.GET)
    public List<Product> listByCategory(@PathVariable int categoryId) {
        return productService.getProductsByCategory(categoryId);
    }

    @GetMapping
    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    public Product get(@PathVariable String name) {

        return productService.getByName(name);
    }

    @GetMapping
    @RequestMapping(value = "/id/{id}", method = RequestMethod.GET)
    public Product get(@PathVariable int id) {

        return productService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product create(@RequestBody final Product product) {
        return productService.create(product);
    }

}
