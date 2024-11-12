package com.ecommerceproject.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ecommerceproject.entities.User;
import com.ecommerceproject.repositories.UserRepository;
import com.ecommerceproject.service.interfaces.UserService;
import com.ecommerceproject.util.JwtUtil;


@Service
public class UserServiceImp implements UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
    private JwtUtil jwtUtil;


    @Override
	public User registerUser(User user) {
	    user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
	    user.setRole("USER");  // Ensure the role is set when registering the user
	    return userRepository.save(user);
	}

    @Override
    public String loginUser(User user) {
        // Authenticate the user
        User dbUser = userRepository.findByUsername(user.getUsername());
        if (dbUser != null && new BCryptPasswordEncoder().matches(user.getPassword(), dbUser.getPassword())) {
            // Generate JWT token for user
            return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
        }
        return null;  // Invalid credentials
    }

	@Override
	public User getUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		return user.orElseThrow(() -> new RuntimeException("User Not Found"));
	}
	
	@Override
	public User updateUser(Long id, User user) {
        Optional<User> customerUpdate = userRepository.findById(id);
        if(customerUpdate.isPresent()) {
        	User userdata=customerUpdate.get();
            userdata.setUsername(user.getUsername());
            userdata.setEmail(user.getEmail());
            userdata.setPassword(user.getPassword());
            userdata.setMobile_number(user.getMobile_number());
            
            userRepository.save(userdata);
            return userdata;
        }
        else {
        	throw new RuntimeException("User Not Found");
        }
    
	}
	
}
