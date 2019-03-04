package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue
    private long product_id;

    private String product_name;

    private String product_description;

    private double product_cost;

    private int product_on_hand;

    public Product() {
    }

    public long getProduct_id() {
        return product_id;
    }

    public void setProduct_id(long product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public double getProduct_cost() {
        return product_cost;
    }

    public void setProduct_cost(double product_cost) {
        this.product_cost = product_cost;
    }

    public int getProduct_on_hand() {
        return product_on_hand;
    }

    public void setProduct_on_hand(int product_on_hand) {
        this.product_on_hand = product_on_hand;
    }
}
