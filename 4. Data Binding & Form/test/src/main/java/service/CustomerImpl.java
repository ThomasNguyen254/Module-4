package service;

import model.Customer;
import model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;

import java.util.List;
@Service
public class CustomerImpl implements ICustomerService{

    private ICustomerRepository customerRepository = new CustomerRepositoryImpl();
    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public boolean create(Customer customer) {
        return customerRepository.create(customer);
    }

    @Override
    public Customer findByName(String name) {
        return customerRepository.findByName(name);
    }

    @Override
    public Customer checkLogin(Login login) {
        return customerRepository.checkLogin(login);
    }

}
