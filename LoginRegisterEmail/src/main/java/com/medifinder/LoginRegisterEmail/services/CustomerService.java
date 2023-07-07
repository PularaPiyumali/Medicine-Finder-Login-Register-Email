package com.medifinder.LoginRegisterEmail.services;

import com.medifinder.LoginRegisterEmail.Requests.CustomerRequest;
import com.medifinder.LoginRegisterEmail.Requests.UsersIdRequest;
import com.medifinder.LoginRegisterEmail.entities.Customer;
import com.medifinder.LoginRegisterEmail.repository.CustomerRepository;
import com.medifinder.LoginRegisterEmail.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
@AllArgsConstructor
public class CustomerService implements Serializable {

    private CustomerRepository customerRepository;
    private UserRepository userRepository;
    public Customer addCustomerUsername(CustomerRequest customerRequest) {
        Customer customer = new Customer();
        customer.setCustomerUsername(customerRequest.getCustomerUsername());
        return customerRepository.save(customer);
    }

    public void addUserCustomer(Long customerId, UsersIdRequest userCustomerRequest) {

        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new IllegalArgumentException("Pharmacy is not found"));
        customer.setUserId(userCustomerRequest.getUserId());
        customerRepository.save(customer);
    }
}
