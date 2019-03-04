package com.joshuahalvorson.javashoppingcart.model;

import javax.persistence.*;

@Entity
@Table(name = "shoppers")
public class Shopper {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shopper_id;

    private String shopper_name;

    private String shopper_billing_address;

    private String shopper_shipping_address;

    private String shopper_phone_number;

    private String shopper_payment_method;

    public Shopper() {
    }

    public long getShopper_id() {
        return shopper_id;
    }

    public void setShopper_id(long shopper_id) {
        this.shopper_id = shopper_id;
    }

    public String getShopper_name() {
        return shopper_name;
    }

    public void setShopper_name(String shopper_name) {
        this.shopper_name = shopper_name;
    }

    public String getShopper_billing_address() {
        return shopper_billing_address;
    }

    public void setShopper_billing_address(String shopper_billing_address) {
        this.shopper_billing_address = shopper_billing_address;
    }

    public String getShopper_shipping_address() {
        return shopper_shipping_address;
    }

    public void setShopper_shipping_address(String shopper_shipping_address) {
        this.shopper_shipping_address = shopper_shipping_address;
    }

    public String getShopper_phone_number() {
        return shopper_phone_number;
    }

    public void setShopper_phone_number(String shopper_phone_number) {
        this.shopper_phone_number = shopper_phone_number;
    }

    public String getShopper_payment_method() {
        return shopper_payment_method;
    }

    public void setShopper_payment_method(String shopper_payment_method) {
        this.shopper_payment_method = shopper_payment_method;
    }
}
