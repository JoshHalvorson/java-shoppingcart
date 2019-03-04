package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long order_id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "order")
    private Set<Product> products = new HashSet<>();

    private String order_shipping_address;

    private String order_payment_method;

    private boolean order_shipped;

    public Order() {
    }

    public long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(long order_id) {
        this.order_id = order_id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    public String getOrder_shipping_address() {
        return order_shipping_address;
    }

    public void setOrder_shipping_address(String order_shipping_address) {
        this.order_shipping_address = order_shipping_address;
    }

    public String getOrder_payment_method() {
        return order_payment_method;
    }

    public void setOrder_payment_method(String order_payment_method) {
        this.order_payment_method = order_payment_method;
    }

    public boolean isOrder_shipped() {
        return order_shipped;
    }

    public void setOrder_shipped(boolean order_shipped) {
        this.order_shipped = order_shipped;
    }
}
