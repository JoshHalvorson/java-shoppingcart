package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    //TODO add product to cart by id
    
    @GetMapping("/products/{productname}")
    public Product getProductByName(@PathVariable String productname){
        Product foundProduct = productRepository.findByProductName(productname);
        if(foundProduct != null){
            return foundProduct;
        }
        return null;
    }
}
