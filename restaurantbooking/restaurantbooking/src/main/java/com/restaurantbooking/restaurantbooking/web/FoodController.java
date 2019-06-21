package com.restaurantbooking.restaurantbooking.web;

import com.restaurantbooking.restaurantbooking.model.Food;
import com.restaurantbooking.restaurantbooking.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class FoodController {
    @Autowired

    private FoodService foodService;

    @RequestMapping(value = "/food", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Food> getAllFood() {
        return foodService.getAllFood();

    }
    @RequestMapping(value = "/food/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Food getFoodById(String id) {
        return foodService.getFoodById(id);

    }
    @RequestMapping(value = "/food", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Food> createFood(@RequestBody Food food) {
        Food createdFood = foodService.createFood(food);
        return Optional.ofNullable(createdFood)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }
    @RequestMapping(value = "/food", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Food> CreateFood(@RequestBody Food food) {
        Food createdFood = foodService.CreateFood(food);
        return Optional.ofNullable(createdFood)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }
    @RequestMapping(value = "/food/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteById(String id) {
        foodService.deleteById(id);
    }
}
