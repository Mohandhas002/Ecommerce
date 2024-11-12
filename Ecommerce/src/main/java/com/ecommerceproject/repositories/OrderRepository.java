package com.ecommerceproject.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceproject.entities.Order;

public interface OrderRepository extends JpaRepository<Order,Long>{
	
	List<Order> findByuserid(Long userid);
}
