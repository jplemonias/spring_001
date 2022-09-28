// package com.testjp.TestApp.web.dao;

// import com.testjp.TestApp.form.UserForm;
// import com.testjp.TestApp.model.User;
// import org.springframework.stereotype.Repository;

// import java.util.ArrayList;
// import java.util.List;

// @Repository
// public class UserDaoImpl implements UserDao {

//     public static List<User> users = new ArrayList<>();
//     static {
//         users.add(new User(2, "test2", "Wawa", 100));
//         users.add(new User(4, "test4", "Wizz", 75));
//         users.add(new User(6, "test6", "Wizz", 75));
//         users.add(new User(7, "test7", "Wawa", 100));
//     }
    
//     @Override
//     public List<User> findAll() {
//         return users;
//     }
 
//     @Override
//     public User findById(int id) {
//         for (User user : users){
//             if (user.getId() == id){
//                 return user;
//             }
//         }
//         return null;
//     }
 
//     @Override
//     public User save(User user) {
//         users.add(user);
//         return user;
//     }
 
//     @Override
//     public User deleteUser(int id) {
//         User isRemoved = users.remove(id);
//         return isRemoved;
//     }
 
//     @Override
//     public List<User> editUser(User user, UserForm UserForm) {
//         user.setId(UserForm.getId());
//         user.setName(UserForm.getName());
//         user.setChampionType(UserForm.getChampionType());
//         user.setHp(UserForm.getHp());
//         // users.set( idList, new User(idList, name, type, hp) );
//         return users;
//     }
// }
