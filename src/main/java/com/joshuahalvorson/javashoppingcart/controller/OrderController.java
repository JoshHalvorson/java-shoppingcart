package com.joshuahalvorson.javashoppingcart.controller;

import com.joshuahalvorson.javashoppingcart.Repository.OrderProductQuantityRepository;
import com.joshuahalvorson.javashoppingcart.Repository.OrderRepository;
import com.joshuahalvorson.javashoppingcart.model.Order;
import com.joshuahalvorson.javashoppingcart.model.OrderProductQuantity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {
    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderProductQuantityRepository orderProductQuantityRepository;

    @PostMapping("/order")
    public Order addOrder(@RequestBody Order order){
        return orderRepository.save(order);
    }

    @PostMapping("/order/{orderid}/{productid}/{quantity}")
    public OrderProductQuantity addOrderProductQuantityRelationship(@PathVariable long orderid,
                                                                    @PathVariable long productid,
                                                                    @PathVariable int quantity){
        OrderProductQuantity orderProductQuantity = new OrderProductQuantity();
        orderProductQuantity.setOrderId(orderid);
        orderProductQuantity.setProductId(productid);
        orderProductQuantity.setQuantity(quantity);
        return orderProductQuantityRepository.save(orderProductQuantity);
    }
}