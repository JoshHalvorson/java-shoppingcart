package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.OrderRepository;
import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.repository.SupplierRepository;
import com.joshuahalvorson.javashoppingcart.model.Order;
import com.joshuahalvorson.javashoppingcart.model.Product;
import com.joshuahalvorson.javashoppingcart.model.Supplier;
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

    @PostMapping("/shopkeeper/supplier")
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
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

    @DeleteMapping("/shopkeeper/supplier/{supplierid}")
    public Supplier deleteSupplierById(@PathVariable long supplierid) {
        var foundSupplier = supplierRepository.findById(supplierid);
        if (foundSupplier.isPresent()) {
            supplierRepository.deleteById(supplierid);
            return foundSupplier.get();
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

    @GetMapping("/shopkeeper/suppliers")
    public List<Supplier> getAllSuppliers(){
        List<Supplier> tempList = supplierRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @PutMapping("/shopkeeper/supplier/{supplierid}")
    public Supplier updateSupplierById(@RequestBody Supplier newSupplier, @PathVariable long supplierid) throws URISyntaxException {
        Optional<Supplier> supplierToUpdate = supplierRepository.findById(supplierid);
        if (supplierToUpdate.isPresent()) {
            newSupplier.setSupplierId(supplierid);
            supplierRepository.save(newSupplier);
            return newSupplier;
        }
        return null;
    }

}
