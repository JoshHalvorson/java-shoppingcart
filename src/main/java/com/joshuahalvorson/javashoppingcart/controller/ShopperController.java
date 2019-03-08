package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.ShopperRepository;
import com.joshuahalvorson.javashoppingcart.model.Shopper;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ShopperController {
    @Autowired
    ShopperRepository shopperRepository;

    @ApiOperation(value = "Add new shopper", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added shopper"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/shopper")
    public Shopper addShopper(@RequestBody Shopper shopper){
        return shopperRepository.save(shopper);
    }
}
