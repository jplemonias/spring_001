package com.testjp.TestApp.web.controller;

import com.testjp.TestApp.form.UserForm;
import com.testjp.TestApp.model.User;
import com.testjp.TestApp.web.dao.UserDao;
import com.testjp.TestApp.web.exceptions.*;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;
// import java.util.Iterator;  
// import java.util.ListIterator;  

import javax.annotation.PostConstruct;

@RestController

@RequestMapping("/users")

public class UserController {

    private final UserDao userDoa;

    public UserController(UserDao userDoa){
        this.userDoa = userDoa;
    }

	@Value("${message.welcome}")
	private String messageWelcom;

	@Value("${message.select}")
	private String messageSelect;

	@Value("${message.error}")
	private String errorMessage;

	@Value("${message.error.user4o4}")
	private String userNotFound;

	@Value("${message.error.wtf}")
	private String wtf;

	// @GetMapping(value = { "/", "/index" })
	// public String index(Model model) {
	// 	model.addAttribute("message", messageWelcom);
	// 	return "index";
	// }

	@GetMapping
	public List<User> userList() {
		return userDoa.findAll();
	}

	@GetMapping(value = { "/{id}" })
	public User displayACharacter(@PathVariable int id) {
		User user = userDoa.findById(id);
        if (user==null) {
			throw new UserNotFound("User can not be found.");
		}
        return user;
	}

	// @GetMapping(value = { "/addUser" })
	// public UserForm showAddUserPage() {
	// 	return new UserForm();
	// }

	@PostMapping(value = { "/add" })
	public User saveUser(@RequestBody User user) {

		int id = user.getId();
		String name = user.getName();
		String type = user.getChampionType();
		int hp = user.getHp();

		Boolean nameIsValid = name != null && name.length() > 0;
		Boolean typeIsValid = type != null && type.length() > 0;
		if (nameIsValid) {
			if (typeIsValid) {
				for (User userLoop : userDoa.findAll()){
					if (userLoop.getId() == id){
						throw new UserExisting("Already existing user.");
					}
				}
				return userDoa.save(new User(id, name, type, hp));
			}
			throw new ErrorForm("Error in entering the form. (Type)");
		}
		throw new ErrorForm("Error in entering the form. (Name)");
	}

	@DeleteMapping(value = { "/delete/{id}" })
	public List<User> deletUser(Model model, @PathVariable int id) {
		List<User> users = userDoa.findAll();
		User user = userDoa.findAll().stream()
			.filter(x -> id == x.getId()).findFirst()
			.orElse(null);

		if (user == null) {
			throw new UserNotFound("User can not be found.");
		}
		userDoa.deleteUser(users.indexOf(user));
		return users;
	}

	@GetMapping(value = { "/edit/{idUser}" })
	public UserForm showAddEditPage(@PathVariable int idUser) {
		
		UserForm UserForm = new UserForm();
		User user = userDoa.findById(idUser);

		UserForm.setId(user.getId());
		UserForm.setName(user.getName());
		UserForm.setChampionType(user.getChampionType());
		UserForm.setHp(user.getHp());

		return UserForm;
	}

	@PutMapping(value = { "/edit/{idUser}" })
	public User editUser(Model model, @ModelAttribute("UserForm") UserForm UserForm, @PathVariable int idUser) {

		System.out.println(UserForm.getId());
		System.out.println(UserForm.getName());
		System.out.println(UserForm.getChampionType());
		System.out.println(UserForm.getHp());
		
		int id = UserForm.getId();
		String name = UserForm.getName();
		String type = UserForm.getChampionType();
		int hp = UserForm.getHp();

		Boolean nameIsValid = name != null && name.length() > 0;
		Boolean typeIsValid = type != null && type.length() > 0;

		if (nameIsValid) {
			if (typeIsValid) {
				for (User user : userDoa.findAll()){
					if (user.getId() == idUser){
						userDoa.editUser(user, UserForm);
						return user;
					}
				}
				throw new UserNotFound("User can not be found.");
			}
			throw new ErrorForm("Error in entering the form. (Type)");
		}
		throw new ErrorForm("Error in entering the form. (Name)");
	}

    // @GetMapping("/users")
    // public String listeProduits() {
    //     // Iterator<User> itr = userDoa.findAll().listIterator(); ;
    //     String str = "";

    //     // while(itr.hasNext()){  
    //     //     str+=itr.next().toString()+"<br>";
    //     //     System.out.println(itr.next());  
    //     // }   
    //     for (User user : userDoa.findAll()){
    //         str+=user.toString()+"<br>";
    //     }
    //     int removLastBr = str.length()-4;
    //     return str.substring(0, removLastBr);
    // }

    // @GetMapping(value = "/users/{id}")
    // public String oneUser(@PathVariable int id) {
    //     return userDoa.findById(id).toString();
    // }
}