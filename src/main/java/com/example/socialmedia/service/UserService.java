package com.example.socialmedia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.socialmedia.entity.User;
import com.example.socialmedia.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepo;
	
	public List<User> getAllUser(){
		List<User> users = userRepo.findAll();
		return users;
	}
	
	public User getUser(String userid) {
		return userRepo.findByUserid(userid);
	}
	
	public User addUser(User user) {
		return userRepo.save(user);
	}
	
	public User updateUser(String userid, User user) {	
		user.setUserid(userid);
		userRepo.save(user);
		return user;
	}
	
	public boolean deleteUser(String userid) {
		List<User> list = userRepo.findAll();
		User user = null;
		for(User u: list) {
			if(u.getUserid() == userid) {
				user=u;
			}
		}
		if(user!=null) {
			userRepo.delete(user);
			return true;
		}
		return false;
	}
}
