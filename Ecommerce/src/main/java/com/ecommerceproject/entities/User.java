package com.ecommerceproject.entities;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

@Entity
public class User {
	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
    private Long user_id;
    private String username;
    private String password;
    private String email;
    private String address;
    private LocalDateTime Created_time;
    private Long mobile_number;
    private String role;
    
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    @PrePersist
    protected void onCreate() {
        Created_time = LocalDateTime.now();
    }

    
	public Long getUser_id() {
		return user_id;
	}
	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public LocalDateTime getCreated_time() {
		return Created_time;
	}
	public void setCreated_time(LocalDateTime created_time) {
		Created_time = created_time;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public Long getMobile_number() {
		return mobile_number;
	}
	public void setMobile_number(Long mobile_number) {
		this.mobile_number = mobile_number;
	}   
}
