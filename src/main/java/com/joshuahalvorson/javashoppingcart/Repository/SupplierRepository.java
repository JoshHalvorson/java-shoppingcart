package com.joshuahalvorson.javashoppingcart.Repository;

import com.joshuahalvorson.javashoppingcart.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
}
