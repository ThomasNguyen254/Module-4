package com.example.learn_springboot.controller;

import com.example.learn_springboot.model.Person;
import com.example.learn_springboot.service.IPersonService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/persons")
public class PersonalController {
    private final IPersonService personService;

    public PersonalController(IPersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String showPersons(Model model){
        List<Person> personList = personService.findAll();
        model.addAttribute("personList",personList);
        return "list";

    }
}
