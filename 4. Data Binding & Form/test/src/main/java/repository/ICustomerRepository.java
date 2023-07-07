package repository;

import model.Customer;
import model.Login;

import java.util.List;

public interface ICustomerRepository {
    List<Customer> findAll();

    boolean create(Customer customer);

    Customer findByName(String name);

    Customer checkLogin(Login login);
}
