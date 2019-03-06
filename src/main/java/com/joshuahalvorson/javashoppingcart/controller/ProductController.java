package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.CartRepository;
import com.joshuahalvorson.javashoppingcart.Repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Cart;
import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    CartRepository cartRepository;

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

    @PostMapping("/cart/add/{productid}")
    public Product addProductToCart(@RequestHeader int quantity, @PathVariable long productid){
        cartRepository.addProductToCart(productid, quantity);
        return productRepository.findById(productid).orElseThrow();
    }

    @GetMapping("/cart")
    public List<Cart> getCart(){
        List<Cart> tempList = cartRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }
}
