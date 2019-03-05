package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.ShopperRepository;
import com.joshuahalvorson.javashoppingcart.model.Product;
import com.joshuahalvorson.javashoppingcart.model.Shopper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.Optional;

@RestController
public class AdminController {
    @Autowired
    ShopperRepository shopperRepository;

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
