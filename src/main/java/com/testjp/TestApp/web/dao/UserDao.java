package com.testjp.TestApp.web.dao;

import com.testjp.TestApp.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    User findById(int id);
    User save(User user);
}
