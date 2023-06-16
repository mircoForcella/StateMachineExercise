package com.statemachine.demo.services;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService {
    User findByUsername(String username);
    User save(User user);
    User findById(Long id);
    void delete(Long id);
}