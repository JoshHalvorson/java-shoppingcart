package com.joshuahalvorson.javashoppingcart.repository;

import com.joshuahalvorson.javashoppingcart.model.OrderProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, Long> {
    List<OrderProductQuantity> findByOrderId(long orderid);
}
