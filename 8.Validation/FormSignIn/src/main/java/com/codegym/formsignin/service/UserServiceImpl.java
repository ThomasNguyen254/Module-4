package com.codegym.formsignin.service;

import com.codegym.formsignin.model.User;
import com.codegym.formsignin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public boolean save(User user) {
        User user1 = userRepository.save(user);
        if(user1 != null) {
            return true;
        }
        return false;
    }
}
