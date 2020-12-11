package com.ITHS.Webshop.repositories;

import com.ITHS.Webshop.models.Category;
import com.ITHS.Webshop.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface CategoryRepository extends JpaRepository<Category, Integer>, JpaSpecificationExecutor<Category> {

    Category findByNameContainsIgnoreCase(String name);
}