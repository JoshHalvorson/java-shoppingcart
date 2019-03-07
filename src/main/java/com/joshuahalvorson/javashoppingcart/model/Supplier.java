package com.joshuahalvorson.javashoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "suppliers")
public class Supplier {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private long supplierId;

    @Column(name = "supplier_name")
    private String supplierName;

    @ManyToMany
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

    public long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(long supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }
}
