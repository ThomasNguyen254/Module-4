package com.example.footballpitch.service;

import com.example.footballpitch.model.Customer;
import com.example.footballpitch.model.FootballPitch;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface ICustomerService {
    List<Customer> showAll();

    Page<Customer> showAll(Pageable pageable, String name);

    List<Customer> searchName(String name);

    Customer findById(Long id);

    void save(Customer customer);

    void update(Customer customer);

    void delete(Long id);
}
