package com.restaurantbooking.restaurantbooking.service;

import com.restaurantbooking.restaurantbooking.model.Customer;
import com.restaurantbooking.restaurantbooking.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerRepository.findAll();

    }

    public Boolean authUser(String email, String password) {
        Optional<Customer> customerOptional = customerRepository.findByCustomerEmailAndCustomerPassword(email, password);
        if (customerOptional.isPresent()) {
            return true;

        }
        return false;
    }

    public Customer getCustomerById(Long cid) {
        return customerRepository.findById(cid).get();

    }

    public Customer createCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }


    public Customer CreateCustomer(Customer customer) {
        return  customerRepository.save(customer);
    }
}

