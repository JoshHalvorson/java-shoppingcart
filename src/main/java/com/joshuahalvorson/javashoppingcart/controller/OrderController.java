package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.repository.OrderProductQuantityRepository;
import com.joshuahalvorson.javashoppingcart.repository.OrderRepository;
import com.joshuahalvorson.javashoppingcart.repository.ProductRepository;
import com.joshuahalvorson.javashoppingcart.model.Order;
import com.joshuahalvorson.javashoppingcart.model.OrderProductQuantity;
import com.joshuahalvorson.javashoppingcart.model.Product;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductQuantityRepository orderProductQuantityRepository;

    @Autowired
    ProductRepository productRepository;

    @ApiOperation(value = "Add new order", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added order"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @ApiOperation(value = "Add relation for order, product, and quantity", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successfully added relation"),
            @ApiResponse(code = 401, message = "You are not authorized here"),
            @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
            @ApiResponse(code = 404, message = "The resource you were trying to reach is not found")
    })
    @PostMapping("/order/{orderid}/{productid}/{quantity}")
    public OrderProductQuantity addOrderProductQuantityRelationship(@PathVariable long orderid,
                                                                    @PathVariable long productid,
                                                                    @PathVariable int quantity){

        Product product = productRepository.findById(productid).orElseThrow();
        OrderProductQuantity orderProductQuantity = new OrderProductQuantity();
        orderProductQuantity.setOrderId(orderid);
        orderProductQuantity.setProduct(product);
        orderProductQuantity.setQuantity(quantity);
        return orderProductQuantityRepository.save(orderProductQuantity);
    }
}
