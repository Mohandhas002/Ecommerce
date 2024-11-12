package com.ecommerceproject.service.interfaces;

import com.ecommerceproject.entities.User;

public interface UserService {
    User registerUser(User user);
    String loginUser(User user);
    User getUserById(Long id);
    User updateUser(Long id,User user);
    
}
