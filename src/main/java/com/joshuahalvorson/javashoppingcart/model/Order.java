package com.joshuahalvorson.javashoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private long orderId;

    @OneToMany
    @JsonIgnoreProperties("order")
    private Set<Product> products = new HashSet<>();

    @Column(name = "order_shipping_address")
    private String orderShippingAddress;

    @Column(name = "order_payment_method")
    private String orderPaymentMethod;

    @Column(name = "order_shipped")
    private boolean orderShipped;

    public Order() {
    }

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
    }

    public String getOrderPaymentMethod() {
        return orderPaymentMethod;
    }

    public void setOrderPaymentMethod(String orderPaymentMethod) {
        this.orderPaymentMethod = orderPaymentMethod;
    }

    public boolean isOrderShipped() {
        return orderShipped;
    }

    public void setOrderShipped(boolean orderShipped) {
        this.orderShipped = orderShipped;
    }
}
