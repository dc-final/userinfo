package com.distributedcomputing.userinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.distributedcomputing.userinfo.entity.User;
import com.distributedcomputing.userinfo.service.UserService;
@RestController
@RequestMapping("/user")
@CrossOrigin
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/addUser")
	public ResponseEntity<User> addUser(@RequestBody User user){
		User userSaved = userService.addNewUser(user);
		return new ResponseEntity<>(userSaved, HttpStatus.CREATED);
		
	}
	@GetMapping("/fetchUserById/{userId}")
	public ResponseEntity<User> getUserDetails(@PathVariable Integer userId){
		return userService.getUserById(userId);
	}
}
