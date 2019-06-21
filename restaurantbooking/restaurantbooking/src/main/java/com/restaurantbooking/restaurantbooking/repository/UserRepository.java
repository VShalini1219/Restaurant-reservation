package com.restaurantbooking.restaurantbooking.repository;


import com.restaurantbooking.restaurantbooking.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
