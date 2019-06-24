package com.restaurantbooking.restaurantbooking.repository;

import com.restaurantbooking.restaurantbooking.model.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface  RestaturantRepository extends CrudRepository<Restaurant,Long> {
//    Optional<Restaurant> findByRestaurantName(String restaurantName, String Location);
}
