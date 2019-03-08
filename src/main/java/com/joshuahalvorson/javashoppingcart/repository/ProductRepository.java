package com.joshuahalvorson.javashoppingcart.repository;

import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    public Product findByProductName(String name);
}
