package com.joshuahalvorson.javashoppingcart.Repository;

import com.joshuahalvorson.javashoppingcart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
