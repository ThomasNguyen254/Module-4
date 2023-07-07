package service;

import model.Customer;
import model.Login;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    boolean create(Customer customer);

    Customer findByName(String name);

      Customer checkLogin(Login login);

}
