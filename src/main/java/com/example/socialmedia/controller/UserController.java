package com.example.socialmedia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.socialmedia.entity.User;
import com.example.socialmedia.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {
	
	@Autowired
	UserService userservice;
	
	@GetMapping("get/alluser")
	public ResponseEntity<List<User>> allUsers() {
		return ResponseEntity.ok(userservice.getAllUser());
	}
	
	@GetMapping("get/{userid}")
	public ResponseEntity<User> getUserById(@PathVariable("userid") String userid) {
		User user = userservice.getUser(userid);
		try {
			if (user == null) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.ok(user);
		} catch (Exception e) {
			e.getStackTrace();
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("post")
	public ResponseEntity<Boolean> registerUser(@RequestBody User user) {
		try {
			userservice.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@PutMapping("update/{userid}")
	public ResponseEntity<User> updateUser(@PathVariable("userid") String userid, @RequestBody User user){
		try {
			if(userid==user.getUserid()) {
				userservice.updateUser(userid, user);
				return ResponseEntity.ok(user);
			}
			userservice.addUser(user);
			return ResponseEntity.status(HttpStatus.CREATED).build();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
	
	@DeleteMapping("delete/{userid}")
	public ResponseEntity<User> deleteUser(@PathVariable("userid") String userid){
		try {
			if(this.userservice.deleteUser(userid)) {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		} catch (Exception e) {
			e.getStackTrace();
		}
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
	}
}
