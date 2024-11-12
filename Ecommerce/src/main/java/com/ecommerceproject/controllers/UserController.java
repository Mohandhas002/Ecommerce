package com.ecommerceproject.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceproject.entities.User;
import com.ecommerceproject.service.interfaces.UserService;



@RestController
@RequestMapping(value="/users")
public class UserController {
	@Autowired
	private UserService userService;

	    @PostMapping("/register")
	    public ResponseEntity<User> register(@RequestBody User user) {
	        return ResponseEntity.ok(userService.registerUser(user));
	    }

	    @PostMapping("/login")
	    public ResponseEntity<String> login(@RequestBody User user) {
	    	System.out.println("Login Process");
	        String token = userService.loginUser(user);
	        System.out.println(token);
	        return ResponseEntity.ok("Bearer " + token);
	    }

    @GetMapping(value="/{id}")
	public User getUserById(@PathVariable Long id) {
		
		return userService.getUserById(id);
	}

    @PutMapping(value="/{id}")
	public User updateUser(@PathVariable Long id,@RequestBody User user) {
	
		return userService.updateUser(id, user);
	}

    // AuthResponse.java
    public class AuthResponse {
        private final String token;

        public AuthResponse(String token) {
            this.token = token;
        }

        public String getToken() {
            return token;
        }
    }

        
}
