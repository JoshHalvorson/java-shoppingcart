package com.joshuahalvorson.javashoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_cost")
    private double productCost;

    @Column(name = "product_active")
    private boolean productActive;

    @Column(name = "product_on_hand")
    private int productOnHand;

    @ManyToMany
    @JoinColumn(name ="order_id")
    @JsonIgnoreProperties("products")
    private Set<Order> orders = new HashSet<>();

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "supplier_id")
    @JsonIgnoreProperties("supplier_products")
    private Set<Supplier> suppliers = new HashSet<>();

    @OneToMany(mappedBy = "product")
    @JsonIgnore
    private Set<OrderProductQuantity> orderProductQuantities = new HashSet<>();

    public Product() {
    }

    public Set<OrderProductQuantity> getOrderProductQuantities() {
        return orderProductQuantities;
    }

    public void setOrderProductQuantities(Set<OrderProductQuantity> orderProductQuantities) {
        this.orderProductQuantities = orderProductQuantities;
    }

    public boolean isProductActive() {
        return productActive;
    }

    public void setProductActive(boolean productActive) {
        this.productActive = productActive;
    }

    public Set<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Set<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getProductCost() {
        return productCost;
    }

    public void setProductCost(double productCost) {
        this.productCost = productCost;
    }

    public int getProductOnHand() {
        return productOnHand;
    }

    public void setProductOnHand(int productOnHand) {
        this.productOnHand = productOnHand;
    }
}
