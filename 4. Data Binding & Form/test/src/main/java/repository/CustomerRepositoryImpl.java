package repository;

import model.Customer;
import model.Login;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements ICustomerRepository{
    private static List<Customer> customerList = new ArrayList<>();
    static {
        customerList.add(new Customer("A001","Thomas",25,"thomas123","123456"));
        customerList.add(new Customer("A002","Jenifer",20,"jenifer123","123456"));
        customerList.add(new Customer("A003","David",22,"david123","123456"));
    }
    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public boolean create(Customer customer) {
        return customerList.add(customer);
    }

    @Override
    public Customer findByName(String name) {
        return null;
    }

    @Override
    public Customer checkLogin(Login login) {

        for (Customer c: customerList) {
            if(c.getAccount().equals(login.getAccount())
                    && c.getPassword().equals(login.getPassword())){
                return c;
            }
        }
        return null;
    }

}
