package com.codegym.formsignin.service;

import com.codegym.formsignin.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface UserService {
    List<User> findAll();

    boolean save(User user);


}
