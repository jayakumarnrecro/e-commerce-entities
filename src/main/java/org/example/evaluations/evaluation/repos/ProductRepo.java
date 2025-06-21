package org.example.evaluations.evaluation.repos;

import org.example.evaluations.evaluation.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {
} 