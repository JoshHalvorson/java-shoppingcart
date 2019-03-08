package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> tempList = productRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }
    
    @GetMapping("/products/{productname}")
    public Product getProductByName(@PathVariable String productname){
        Product foundProduct = productRepository.findByProductName(productname);
        if(foundProduct != null){
            return foundProduct;
        }
        return null;
    }
}
