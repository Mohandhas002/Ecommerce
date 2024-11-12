package com.ecommerceproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerceproject.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
	User findByUsername(String username);
}
