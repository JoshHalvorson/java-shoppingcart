package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.CartRepository;
import com.joshuahalvorson.javashoppingcart.Repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Cart;
import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @PostMapping("/cart/add/{productid}")
    public Product addProductToCart(@RequestHeader int quantity, @PathVariable long productid){
        cartRepository.addProductToCart(productid, quantity);
        return productRepository.findById(productid).orElseThrow();
    }

    @DeleteMapping("/cart/remove/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepository.findById(productid);
        if (foundProduct.isPresent()) {
            cartRepository.removeProductFromCart(productid);
            return foundProduct.get();
        }
        return null;
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
