package org.example.evaluations.evaluation.repos;

import org.example.evaluations.evaluation.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    
    @Query("SELECT DISTINCT c FROM Category c " +
           "LEFT JOIN FETCH c.productList p " +
           "LEFT JOIN FETCH p.images i " +
           "WHERE c.state = 'ACTIVE'")
    List<Category> findAllCategoriesWithProductsAndImages();
    
    @Query("SELECT DISTINCT c FROM Category c " +
           "LEFT JOIN FETCH c.subCategories sc " +
           "WHERE c.state = 'ACTIVE'")
    List<Category> findAllCategoriesWithSubCategories();
    
    @Query("SELECT DISTINCT c FROM Category c " +
           "LEFT JOIN FETCH c.subCategories sc " +
           "WHERE c.state = 'ACTIVE' " +
           "AND c.id IN :categoryIds")
    List<Category> findCategoriesWithSubCategoriesByIds(@Param("categoryIds") List<Long> categoryIds);
}
