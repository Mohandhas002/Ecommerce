package com.ecommerceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ecommerceproject.entities.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
               
}
