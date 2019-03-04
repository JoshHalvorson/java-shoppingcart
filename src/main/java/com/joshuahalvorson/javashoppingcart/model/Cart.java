package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "cart")
public class Cart {
    @Id @GeneratedValue
    private long cart_id;

    private Set<Product> products = new HashSet<>();
}
