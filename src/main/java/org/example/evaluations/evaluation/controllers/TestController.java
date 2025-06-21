package org.example.evaluations.evaluation.controllers;

import org.example.evaluations.evaluation.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/test")
public class TestController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories-products-images")
    public List<String> testGetNamesOfAllCategoriesAndLinkedProductsAndTheirImages() {
        return categoryService.getNamesOfAllCategoriesAndLinkedProductsAndTheirImages();
    }

    @GetMapping("/categories-subcategories")
    public List<String> testGetNamesOfAllCategoriesAndTheirSubCategories() {
        return categoryService.getNamesOfAllCategoriesAndTheirSubCategories();
    }
} 