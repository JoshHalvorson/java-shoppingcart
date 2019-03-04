package com.joshuahalvorson.javashoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long supplier_id;

    private String supplier_name;

    @ManyToMany
    @JoinColumn(name = "product_id")
    @JsonIgnoreProperties("suppliers")
    private Set<Product> supplier_products;

    public Supplier() {
    }

    public Set<Product> getSupplier_products() {
        return supplier_products;
    }

    public void setSupplier_products(Set<Product> supplier_products) {
        this.supplier_products = supplier_products;
    }

    public long getSupplier_id() {
        return supplier_id;
    }

    public void setSupplier_id(long supplier_id) {
        this.supplier_id = supplier_id;
    }

    public String getSupplier_name() {
        return supplier_name;
    }

    public void setSupplier_name(String supplier_name) {
        this.supplier_name = supplier_name;
    }
}
