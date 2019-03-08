package com.joshuahalvorson.javashoppingcart.repository;

import com.joshuahalvorson.javashoppingcart.model.OrderProductQuantity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderProductQuantityRepository extends JpaRepository<OrderProductQuantity, Long> {
}
