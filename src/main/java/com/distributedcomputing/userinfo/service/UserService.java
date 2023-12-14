package com.distributedcomputing.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.distributedcomputing.userinfo.entity.User;
import com.distributedcomputing.userinfo.repo.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepo;

	public User addNewUser(User user) {
		User saved = userRepo.save(user);	
		return saved;
	}

	public ResponseEntity<User> getUserById(Integer userId) {
		Optional<User> retrieved = userRepo.findById(userId);
		if(retrieved.get()!=null) {
			return new ResponseEntity<>(retrieved.get(), HttpStatus.OK);
		}
		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
}
