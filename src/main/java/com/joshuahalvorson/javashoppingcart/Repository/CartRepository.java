package com.joshuahalvorson.javashoppingcart.Repository;

import com.joshuahalvorson.javashoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
