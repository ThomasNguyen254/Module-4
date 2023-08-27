package com.example.stadium.service.customer;

import com.example.stadium.IGeneralService;
import com.example.stadium.model.Customer;

import java.util.List;

public interface ICustomerService extends IGeneralService<Customer> {
    List<Customer> findAll();
}
