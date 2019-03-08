package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.ShopperRepository;
import com.joshuahalvorson.javashoppingcart.model.Shopper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    ShopperRepository shopperRepository;

    @ApiOperation(value = "Get all shoppers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received shoppers"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/admin/shoppers")
    public List<Shopper> getAllShoppers(){
        return shopperRepository.findAll();
    }

    @ApiOperation(value = "Update shopper by shopperid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated shopper"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PutMapping("/admin/shopper/{shopperid}")
    public Shopper updateShopper(@RequestBody Shopper newShopper, @PathVariable long shopperid) throws URISyntaxException{
        Optional<Shopper> shopperToUpdate = shopperRepository.findById(shopperid);
        if (shopperToUpdate.isPresent()) {
            newShopper.setShopperId(shopperid);
            shopperRepository.save(newShopper);
            return newShopper;
        }
        return null;
    }

    @ApiOperation(value = "Delete shopper by shopperid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted shopper"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/admin/shopper/{shopperid}")
    public Shopper deleteShopperById(@PathVariable long shopperid) {
        var foundShopper = shopperRepository.findById(shopperid);
        if (foundShopper.isPresent()) {
            shopperRepository.deleteById(shopperid);
            return foundShopper.get();
        }
        return null;
    }
}
