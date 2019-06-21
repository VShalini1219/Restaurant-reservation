package com.restaurantbooking.restaurantbooking.service;

import com.restaurantbooking.restaurantbooking.model.User;
import com.restaurantbooking.restaurantbooking.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();

    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();

    }

    public User createUser(User user) {
        return userRepository.save(user);

    }

    public User CreateUser(User user) {
        return userRepository.save(user);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }
}
