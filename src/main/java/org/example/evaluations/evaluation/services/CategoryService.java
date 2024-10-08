package org.example.evaluations.evaluation.services;

import org.example.evaluations.evaluation.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<String> getNamesOfAllCategoriesAndLinkedProductsAndTheirImages() {
        return null;
    }

    public List<String> getNamesOfAllCategoriesAndTheirSubCategories() {
        return null;
    }
}
