package com.restaurantbooking.restaurantbooking.service;




import com.restaurantbooking.restaurantbooking.model.Location;
import com.restaurantbooking.restaurantbooking.model.Restaurant;
import com.restaurantbooking.restaurantbooking.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {
    @Autowired
    private LocationRepository locationRepository;

    public Location createlocation(Location location) {
        return locationRepository.save(location);
    }


    public List<Location> getAllLocations() {

            return (List<Location>) locationRepository.findAll();

    }

     public Location getLocationByName(String name){
         Optional<Location> locationOptional = locationRepository.findByName(name);
         return locationOptional.get();

     }


    public Location getLocationById(Long id) {
        return locationRepository.findById(id).orElse(null);
    }
}

