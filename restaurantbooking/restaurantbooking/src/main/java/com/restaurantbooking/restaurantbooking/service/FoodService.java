package com.restaurantbooking.restaurantbooking.service;

import com.restaurantbooking.restaurantbooking.model.Food;
import com.restaurantbooking.restaurantbooking.repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodService {
    @Autowired
    private FoodRepository foodRepository;

    public List<Food> getAllFood() {
        return (List<Food>) foodRepository.findAll();
    }

    public Food getFoodById(String id) {
        return  foodRepository.findById(id).get();
    }

    public Food createFood(Food food) {
        return foodRepository.save(food);
    }

    public Food CreateFood(Food food) {
        return foodRepository.save(food);
    }

    public void deleteById(String id) {
        foodRepository.deleteById(id)








        ;
    }
}
