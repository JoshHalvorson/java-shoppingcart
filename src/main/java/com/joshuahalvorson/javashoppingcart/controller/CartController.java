package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.CartRepository;
import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Cart;
import com.joshuahalvorson.javashoppingcart.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartRepository cartRepository;

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Add new product to cart", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/cart/add/{productid}")
    public Product addProductToCart(@RequestHeader int quantity, @PathVariable long productid){
        cartRepository.addProductToCart(productid, quantity);
        return productRepository.findById(productid).orElseThrow();
    }

    @ApiOperation(value = "Delete product from cart", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/cart/remove/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepository.findById(productid);
        if (foundProduct.isPresent()) {
            cartRepository.removeProductFromCart(productid);
            return foundProduct.get();
        }
        return null;
    }

    @ApiOperation(value = "Get all carts", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received carts"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/cart")
    public List<Cart> getCart(){
        List<Cart> tempList = cartRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }
}
