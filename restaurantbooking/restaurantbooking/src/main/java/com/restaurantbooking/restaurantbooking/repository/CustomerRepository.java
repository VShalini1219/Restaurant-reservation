package com.restaurantbooking.restaurantbooking.repository;

import com.restaurantbooking.restaurantbooking.model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Long> {

    Optional<Customer> findByCustomerEmailAndCustomerPassword(String email, String password);

}
