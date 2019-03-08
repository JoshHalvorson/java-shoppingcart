package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.ShopperRepository;
import com.joshuahalvorson.javashoppingcart.model.Shopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShopperController {
    @Autowired
    ShopperRepository shopperRepository;

    @PostMapping("/shopper")
    public Shopper addShopper(@RequestBody Shopper shopper){
        return shopperRepository.save(shopper);
    }
}
