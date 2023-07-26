package com.codegym.formsignin.repository;

import com.codegym.formsignin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

}
