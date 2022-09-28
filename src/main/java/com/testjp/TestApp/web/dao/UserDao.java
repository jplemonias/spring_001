package com.testjp.TestApp.web.dao;

// import com.testjp.TestApp.form.UserForm;
import com.testjp.TestApp.model.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// import java.util.List;

@Repository
public interface UserDao extends JpaRepository<Users, Integer> {
    // List<User> findAll();
    // // C
    // User save(User user);
    // R
    Users findById(int id);
    // // U
    // List<User> editUser(User user, UserForm UserForm);
    // // D
    // User deleteUser(int id);
}