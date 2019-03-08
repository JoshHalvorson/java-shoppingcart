package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.*;

@Entity
@Table(name = "shoppers")
public class Shopper {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "shopper_id")
    private long shopperId;

    @Column(name = "shopper_name")
    private String shopperName;

    @Column(name = "shopper_billing_address")
    private String shopperBillingAddress;

    @Column(name = "shopper_shipping_address")
    private String shopperShippingAddress;

    @Column(name = "shopper_phone_number")
    private String shopperPhoneNumber;

    @Column(name = "shopper_payment_method")
    private String shopperPaymentMethod;

    @OneToOne
    @JoinColumn(name = "id")
    private Cart cartId;

    public Shopper() {
    }

    public long getShopperId() {
        return shopperId;
    }

    public void setShopperId(long shopperId) {
        this.shopperId = shopperId;
    }

    public String getShopperName() {
        return shopperName;
    }

    public void setShopperName(String shopperName) {
        this.shopperName = shopperName;
    }

    public String getShopperBillingAddress() {
        return shopperBillingAddress;
    }

    public void setShopperBillingAddress(String shopperBillingAddress) {
        this.shopperBillingAddress = shopperBillingAddress;
    }

    public String getShopperShippingAddress() {
        return shopperShippingAddress;
    }

    public void setShopperShippingAddress(String shopperShippingAddress) {
        this.shopperShippingAddress = shopperShippingAddress;
    }

    public String getShopperPhoneNumber() {
        return shopperPhoneNumber;
    }

    public void setShopperPhoneNumber(String shopperPhoneNumber) {
        this.shopperPhoneNumber = shopperPhoneNumber;
    }

    public String getShopperPaymentMethod() {
        return shopperPaymentMethod;
    }

    public void setShopperPaymentMethod(String shopperPaymentMethod) {
        this.shopperPaymentMethod = shopperPaymentMethod;
    }
}
