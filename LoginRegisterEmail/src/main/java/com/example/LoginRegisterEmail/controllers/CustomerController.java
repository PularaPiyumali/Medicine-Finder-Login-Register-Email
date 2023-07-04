package com.example.LoginRegisterEmail.controllers;

import com.example.LoginRegisterEmail.Requests.CustomerRequest;
import com.example.LoginRegisterEmail.Requests.UsersIdRequest;
import com.example.LoginRegisterEmail.entities.Customer;
import com.example.LoginRegisterEmail.services.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@CrossOrigin
@RequestMapping(path = "api/v1")
public class CustomerController {

    private CustomerService customerService;

    @PostMapping("/customers")
    public ResponseEntity<Customer> addCustomer(@RequestBody CustomerRequest customerRequest)
    {
        Customer newCustomer = customerService.addCustomerUsername(customerRequest);
        return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);

    }

    @PutMapping("customers/{customerId}")
    public ResponseEntity<String> addUserCustomer(@PathVariable Long customerId, @RequestBody UsersIdRequest userCustomerRequest) {
        try {
            customerService.addUserCustomer(customerId,userCustomerRequest);
            return ResponseEntity.ok("Customer added successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
