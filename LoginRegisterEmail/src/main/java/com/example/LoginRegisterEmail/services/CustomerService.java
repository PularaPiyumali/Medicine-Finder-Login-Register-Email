package com.example.LoginRegisterEmail.services;

import com.example.LoginRegisterEmail.Requests.UsersRequest;
import com.example.LoginRegisterEmail.entities.Customer;
import com.example.LoginRegisterEmail.repository.CustomerRepository;
import com.example.LoginRegisterEmail.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class CustomerService implements Serializable {

    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    public Customer addCustomerUsername(Customer customer) {
        return customerRepository.save(customer);
    }

    public void addUserCustomer(Long customerId, UsersRequest userCustomerRequest) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Pharmacy is not found"));
        customer.setUserId(userCustomerRequest.getUserId());
        customerRepository.save(customer);
    }
}
