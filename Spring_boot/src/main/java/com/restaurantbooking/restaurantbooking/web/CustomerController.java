package com.restaurantbooking.restaurantbooking.web;


import com.restaurantbooking.restaurantbooking.model.Customer;
import com.restaurantbooking.restaurantbooking.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/customers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Customer> getAllCustomers() {
        return (List<Customer>) customerService.getAllCustomers();

    }
    @CrossOrigin
    @RequestMapping(value = "/customers/login", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Boolean checkCustomer(@RequestBody Customer customer){
        return customerService.authUser(customer.getCustomerEmail(), customer.getCustomerPassword());
    }


    @RequestMapping(value = "/customers/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Customer getCustomerById(Long id) {
        return customerService.getCustomerById(id);
    }




    @CrossOrigin
    @RequestMapping(value = "/customers", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer) {
        Customer createdCustomer = customerService.createCustomer(customer);
        return Optional.ofNullable(createdCustomer)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }

    @RequestMapping(value = "/customers", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Customer> CreateCustomer(@RequestBody Customer customer) {
        if(customer.getCustomerId()==null)
            return ResponseEntity.badRequest().header("Error", "A Update customer should have 'id'").build();
        Customer customerById = customerService.getCustomerById(customer.getCustomerId());
        if(customerById==null)
            return ResponseEntity.badRequest().header("Error", "Invalid customer. No customer found with id:"+customer.getCustomerId()).build();
        Customer createdCustomer = customerService.CreateCustomer(customer);
        return Optional.ofNullable(createdCustomer)
                .map(u -> ResponseEntity.ok().body(u))
                .orElse(ResponseEntity.notFound().build());

    }






}



