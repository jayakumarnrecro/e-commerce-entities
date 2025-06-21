package org.example.evaluations.evaluation.services;

import org.example.evaluations.evaluation.models.Category;
import org.example.evaluations.evaluation.repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<String> getNamesOfAllCategoriesAndLinkedProductsAndTheirImages() {
        // Use a single query with JOIN FETCH to get all data efficiently
        List<Category> categories = categoryRepo.findAllCategoriesWithProductsAndImages();
        
        List<String> result = new ArrayList<>();
        
        for (Category category : categories) {
            // Add category title
            result.add(category.getTitle());
            
            // Add product names and their image descriptive names
            if (category.getProductList() != null) {
                for (var product : category.getProductList()) {
                    result.add(product.getName());
                    
                    if (product.getImages() != null) {
                        for (var image : product.getImages()) {
                            if (image.getDescriptiveName() != null) {
                                result.add(image.getDescriptiveName());
                            }
                        }
                    }
                }
            }
        }
        
        return result;
    }

    public List<String> getNamesOfAllCategoriesAndTheirSubCategories() {
        List<String> result = new ArrayList<>();
        
        // Get all category IDs first
        List<Long> allCategoryIds = categoryRepo.findAll().stream()
                .map(category -> category.getId())
                .collect(Collectors.toList());
        
        // Process in batches of 3
        int batchSize = 3;
        for (int i = 0; i < allCategoryIds.size(); i += batchSize) {
            int endIndex = Math.min(i + batchSize, allCategoryIds.size());
            List<Long> batchIds = allCategoryIds.subList(i, endIndex);
            
            // Fetch categories with subcategories for this batch
            List<Category> categories = categoryRepo.findCategoriesWithSubCategoriesByIds(batchIds);
            
            for (Category category : categories) {
                // Add category title
                result.add(category.getTitle());
                
                // Add subcategory names
                if (category.getSubCategories() != null) {
                    for (var subCategory : category.getSubCategories()) {
                        result.add(subCategory.getName());
                    }
                }
            }
        }
        
        return result;
    }
}
