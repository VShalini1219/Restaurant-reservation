package com.restaurantbooking.restaurantbooking.repository;

import com.restaurantbooking.restaurantbooking.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByCustomerEmailAndCustomerPassword(String email, String password);
    Optional<Customer> findByCustomerEmail(String email);

}
