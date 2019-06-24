package com.restaurantbooking.restaurantbooking.web;

import com.restaurantbooking.restaurantbooking.model.Location;
import com.restaurantbooking.restaurantbooking.model.Restaurant;
import com.restaurantbooking.restaurantbooking.service.Restaturantservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RestaturantController {
    @Autowired

    private Restaturantservice restaturantservice;
    private Location l;



    @RequestMapping(value = "/restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Restaurant> getAllRestaurants() {
        return restaturantservice.getAllRestaurants();
    }
    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Restaurant getRestaurantById(@PathVariable Long id) {
        return restaturantservice.getRestaurantById(id);

    }
//    @RequestMapping(value="/restaurants/{location}",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
//    public List<Restaurant> getRestaurantByLocation(String place){
//        l = restaurant.getLocation();
//        return (List<Restaurant>) restaturantservice.getRestaurantByLocation(l.getName());
//    }
    @RequestMapping(value = "/restaurants", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Restaurant> createRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaturantservice.createRestaurant(restaurant);
        return Optional.ofNullable(createdRestaurant)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }
    @RequestMapping(value = "/restaurants", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Restaurant> CreateRestaurant(@RequestBody Restaurant restaurant) {
        Restaurant createdRestaurant = restaturantservice.CreateRestaurant(restaurant);
        return Optional.ofNullable(createdRestaurant)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }
    @RequestMapping(value = "/restaurants/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void deleteById(@PathVariable Long id) {
         restaturantservice.deleteById(id);

    }


   /* @CrossOrigin
    @RequestMapping(value="restaurants/location",method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
     public Boolean getRestaurantByLocation(@RequestBody Restaurant restaurant) {
        return restaturantservice.getRestaurantByLocation(restaurant.getRestaurantName(), restaurant.getLocation());
    }*/

}
