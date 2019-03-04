package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long cart_id;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "cart")
    private Set<Product> products = new HashSet<>();

    public Cart() {
    }

    public long getCart_id() {
        return cart_id;
    }

    public void setCart_id(long cart_id) {
        this.cart_id = cart_id;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
