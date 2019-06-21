package com.restaurantbooking.restaurantbooking.repository;

import com.restaurantbooking.restaurantbooking.model.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food,String> {
}
