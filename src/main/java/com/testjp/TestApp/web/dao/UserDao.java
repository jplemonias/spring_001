package com.testjp.TestApp.web.dao;

import com.testjp.TestApp.form.UserForm;
import com.testjp.TestApp.model.User;

import java.util.List;

public interface UserDao {
    List<User> findAll();
    // C
    User save(User user);
    // R
    User findById(int id);
    // U
    List<User> editUser(User user, UserForm UserForm);
    // D
    User deleteUser(int id);
}