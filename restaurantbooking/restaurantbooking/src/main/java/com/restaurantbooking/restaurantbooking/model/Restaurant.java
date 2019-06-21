package com.restaurantbooking.restaurantbooking.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Restaurant {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String restaurantName;
    private String restaurantAddress;
    private Long restaurantPin;


    @ManyToOne
    @JoinColumn(name = "locationId",referencedColumnName = "id")
    private Location location;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public Long getRestaurantPin() {
        return restaurantPin;
    }

    public void setRestaurantPin(Long restaurantPin) {
        this.restaurantPin = restaurantPin;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }



}
