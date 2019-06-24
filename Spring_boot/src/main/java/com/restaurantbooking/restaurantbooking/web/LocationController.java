package com.restaurantbooking.restaurantbooking.web;



import com.restaurantbooking.restaurantbooking.model.Location;
import com.restaurantbooking.restaurantbooking.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class LocationController {

        @Autowired
        private LocationService locationService;

        @RequestMapping(value = "/locations", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public List<Location> getAllLocations() {
            return (List<Location>) locationService.getAllLocations();

        }

        @RequestMapping(value = "/locations/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Location getLocationById(@PathVariable Long id) {
            return locationService.getLocationById(id);
        }

        @RequestMapping(value = "/locations/{name}", method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
        public Location getLocationByName(@PathVariable String name){
            return locationService.getLocationByName(name);
        }



    @RequestMapping(value = "/locations", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Location> createCustomer(@RequestBody Location location) {
        Location createdLocation =  locationService.createlocation(location);
        return Optional.ofNullable(createdLocation)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());
    }

}

