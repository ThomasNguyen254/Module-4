package com.example.stadium.service.customer;

import com.example.stadium.model.Customer;
import com.example.stadium.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CustomerService implements ICustomerService{
    @Autowired
    CustomerRepository customerRepository;
    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void save(Customer customer) {


    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
