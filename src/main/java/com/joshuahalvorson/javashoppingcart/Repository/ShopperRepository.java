package com.joshuahalvorson.javashoppingcart.Repository;

import com.joshuahalvorson.javashoppingcart.model.Shopper;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopperRepository extends JpaRepository<Shopper, Long> {
}
