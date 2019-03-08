package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Get all products", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received products"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/products")
    public List<Product> getAllProducts(){
        List<Product> tempList = productRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @ApiOperation(value = "Get product by name", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/products/{productname}")
    public Product getProductByName(@PathVariable String productname){
        Product foundProduct = productRepository.findByProductName(productname);
        if(foundProduct != null){
            return foundProduct;
        }
        return null;
    }
}
