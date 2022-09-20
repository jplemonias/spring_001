package com.testjp.TestApp.web.controller;

import com.testjp.TestApp.model.User;
import com.testjp.TestApp.web.dao.UserDao;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

// import java.util.List;
// import java.util.Iterator;  
// import java.util.ListIterator;  

@RestController
public class UserController {

    private final UserDao userDoa;

    public UserController(UserDao userDoa){
        this.userDoa = userDoa;
    }

    @GetMapping("/users")
    public String listeProduits() {
        // Iterator<User> itr = userDoa.findAll().listIterator(); ;
        String str = "";

        // while(itr.hasNext()){  
        //     str+=itr.next().toString()+"<br>";
        //     System.out.println(itr.next());  
        // }   
        for (User user : userDoa.findAll()){
            str+=user.toString()+"<br>";
        }
        int removLastBr = str.length()-4;
        return str.substring(0, removLastBr);
    }

    @GetMapping(value = "/users/{id}")
    public String oneUser(@PathVariable int id) {
        return userDoa.findById(id).toString();
    }
}