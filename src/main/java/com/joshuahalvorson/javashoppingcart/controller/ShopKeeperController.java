package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.OrderRepository;
import com.joshuahalvorson.javashoppingcart.Repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.Repository.SupplierRepository;
import com.joshuahalvorson.javashoppingcart.model.Order;
import com.joshuahalvorson.javashoppingcart.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

@RestController
public class ShopKeeperController {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    OrderRepository orderRepository;

    @PostMapping("/shopkeeper/product")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @PutMapping("/shopkeeper/product/{productid}")
    public Product updateProductById(@RequestBody Product newProduct, @PathVariable long productid) throws URISyntaxException {
        Optional<Product> productToUpdate = productRepository.findById(productid);
        if (productToUpdate.isPresent()) {
            newProduct.setProductId(productid);
            productRepository.save(newProduct);
            return newProduct;
        }
        return null;
    }

    @DeleteMapping("/shopkeeper/product/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepository.findById(productid);
        if (foundProduct.isPresent()) {
            productRepository.deleteById(productid);
            return foundProduct.get();
        }
        return null;
    }

    @GetMapping("/shopkeeper/orders")
    public List<Order> getAllOrders(){
        List<Order> tempList = orderRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

}
