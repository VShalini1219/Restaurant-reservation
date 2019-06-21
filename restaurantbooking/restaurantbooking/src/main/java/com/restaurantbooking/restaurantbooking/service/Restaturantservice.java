package com.restaurantbooking.restaurantbooking.service;

import com.restaurantbooking.restaurantbooking.model.Restaurant;
import com.restaurantbooking.restaurantbooking.repository.RestaturantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class Restaturantservice {
    @Autowired
    private RestaturantRepository restaturantRepository;

    public List<Restaurant> getAllRestaurants() {
        return (List<Restaurant>) restaturantRepository.findAll();
    }

    public Restaurant getRestaurantById(Long id) {
        return restaturantRepository.findById(id).get();
    }

    public Restaurant createRestaurant(Restaurant restaurant) {
        return restaturantRepository.save(restaurant);
    }

    public Restaurant CreateRestaurant(Restaurant restaurant) {
        return restaturantRepository.save(restaurant);
    }

    public void deleteById(Long id) {
        restaturantRepository.deleteById(id);
    }


   /* public List<Restaurant> getRestaurantByLocation(String location) {
        return (List<Restaurant>) restaturantRepository.findByRestaurantNameAndLocation();
    }*/

//    public List<Restaurant> getRestaurantByLocation(String Location) {
//        Optional<Restaurant> restaurantOptional = restaturantRepository.findByRestaurantNameAndLocation(restaurantName, Location);
//        if (restaurantOptional.isPresent()){
//            //return true;
//        }
//        else{
//            //return false;
//        }
//    }
}
