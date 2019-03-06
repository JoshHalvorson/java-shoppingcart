package com.joshuahalvorson.javashoppingcart.Repository;

import com.joshuahalvorson.javashoppingcart.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    @Transactional
    @Modifying
    @Query(value = "INSERT INTO shoppingcart.cart (product_id, quantity) VALUES (:product_id, :quantity)", nativeQuery = true)
    void addProductToCart(long product_id, int quantity);

    @Transactional
    @Modifying
    @Query(value = "DELETE FROM shoppingcart.cart WHERE product_id = :product_id", nativeQuery = true)
    void removeProductFromCart(long product_id);
}
