package controller;

import model.Customer;
import model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import repository.CustomerRepositoryImpl;
import repository.ICustomerRepository;
import service.CustomerImpl;
import service.ICustomerService;

@Controller
public class CustomerController {

    private ICustomerService customerService = new CustomerImpl();
    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView("home","login",new Login());
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView login(@ModelAttribute("login") Login login) {
        Customer customer = customerService.checkLogin(login);
        if(customer == null){
            ModelAndView modelAndView = new ModelAndView("error");
            return modelAndView;
        } else {
            ModelAndView modelAndView = new ModelAndView("login");
            modelAndView.addObject("customer", customer);
            return modelAndView;
        }

    }
}
