package com.mindexpert.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindexpert.crud.service.UserService;
import com.mindexpert.crud.user.User;

@RestController
@RequestMapping("/api/users/")
public class UserController {
	
	//Dependency Injection 
	@Autowired
	private UserService userService;
	
	//Method to fetch all the users 
	
	@GetMapping
	public List<User> getAllUser(){
		return userService.getAllUser();
		}
	
	// Method to fetch the user based on id 
	@GetMapping("/{id}")
	public ResponseEntity<User> getUserById(@PathVariable Long id){
		User user = userService.getUserById(id);
		return user!=null ? ResponseEntity.ok(user):ResponseEntity.notFound().build();
		
	}
	
	//Method to create the new user 
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	//Method to update user
	@PutMapping("/{id}")
	public  ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
		User updateUser = userService.updateUser(id, userDetails);
		return updateUser !=null ? ResponseEntity.ok(userDetails) : ResponseEntity.notFound().build();
	}
	
	//Method to delete the user based on id 
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteUser(@PathVariable Long id){
		userService.deleteUser(id);
		return ResponseEntity.noContent().build();
	}
}
