package com.ITHS.Webshop.controllers;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.repositories.CategoryRepository;
import com.ITHS.Webshop.services.CategoryServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryService;

    @GetMapping
    public List<Category> list() {
        return categoryService.getAllProducts();
    }

    @GetMapping
    @RequestMapping(value ="{id}", method = RequestMethod.GET)
    public Category get(@PathVariable int id) {
        return categoryService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category create(@RequestBody final Category category) {
        return categoryService.create(category);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Category update(int id, Category category) {
        //TODO: Add validation that all attributes are passed in, otherwise return a 400 bad payload
        return categoryService.update(id, category);
    }
}
