package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.model.OrderProductQuantity;
import com.joshuahalvorson.javashoppingcart.repository.OrderProductQuantityRepository;
import com.joshuahalvorson.javashoppingcart.repository.OrderRepository;
import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.repository.SupplierRepository;
import com.joshuahalvorson.javashoppingcart.model.Order;
import com.joshuahalvorson.javashoppingcart.model.Product;
import com.joshuahalvorson.javashoppingcart.model.Supplier;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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

    @Autowired
    OrderProductQuantityRepository orderProductQuantityRepository;

    @ApiOperation(value = "Add new product", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/shopkeeper/product")
    public Product addProduct(@RequestBody Product product){
        return productRepository.save(product);
    }

    @ApiOperation(value = "Add new supplier", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added supplier"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/shopkeeper/supplier")
    public Supplier addSupplier(@RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
    }

    @ApiOperation(value = "Update product by productid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
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

    @ApiOperation(value = "Delete product by productid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted product"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/shopkeeper/product/{productid}")
    public Product deleteProductById(@PathVariable long productid) {
        var foundProduct = productRepository.findById(productid);
        if (foundProduct.isPresent()) {
            productRepository.deleteById(productid);
            return foundProduct.get();
        }
        return null;
    }

    @ApiOperation(value = "Delete supplier by supplierid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully deleted supplier"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @DeleteMapping("/shopkeeper/supplier/{supplierid}")
    public Supplier deleteSupplierById(@PathVariable long supplierid) {
        var foundSupplier = supplierRepository.findById(supplierid);
        if (foundSupplier.isPresent()) {
            supplierRepository.deleteById(supplierid);
            return foundSupplier.get();
        }
        return null;
    }

    @ApiOperation(value = "Get all orders", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received orders"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/shopkeeper/orders")
    public List<Order> getAllOrders(){
        List<Order> tempList = orderRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @ApiOperation(value = "Get all suppliers", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received suppliers"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/shopkeeper/suppliers")
    public List<Supplier> getAllSuppliers(){
        List<Supplier> tempList = supplierRepository.findAll();
        if(tempList != null){
            return tempList;
        }
        return null;
    }

    @ApiOperation(value = "Update supplier by supplierid", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully updated supplier"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
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

    @ApiOperation(value = "Get order product quantity relation", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully received relation"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @GetMapping("/shopkeeper/order/{orderid}")
    public List<OrderProductQuantity> getOrderProductQuantity(@PathVariable long orderid){
        return orderProductQuantityRepository.findByOrderId(orderid);
    }

}
