package com.mindexpert.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindexpert.crud.repo.UserRepository;
import com.mindexpert.crud.user.User;

@Service
public class UserService {
	
	//to inject the user repository in the user service
	@Autowired
	private UserRepository userRepository;
	
	// to fetch the all user from entity 
	public List<User> getAllUser(){
		return userRepository.findAll();
		}
	
	// to fetch the user based on the particular id 
	public User getUserById(Long id) {
		return userRepository.findById(id).orElse(null);
	}
	
	//to create the new user 
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	//to update the user 
	public User updateUser(Long id, User userDetails) {
		User user = userRepository.findById(id).orElse(null);
		
		if(user != null) {
			user.setName(userDetails.getName());
			user.setEmai(userDetails.getEmai());
			return userRepository.save(user);
		}
		
		return null;
		
	}
	
	// to delete the user form the table 
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
	}

}
