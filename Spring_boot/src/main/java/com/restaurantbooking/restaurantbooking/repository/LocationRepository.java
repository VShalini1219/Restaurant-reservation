package com.restaurantbooking.restaurantbooking.repository;

import com.restaurantbooking.restaurantbooking.model.Location;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface LocationRepository extends CrudRepository<Location,Long> {

    Optional<Location> findByName(String name);
}
