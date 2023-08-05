package com.example.socialmedia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.socialmedia.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUserid(String userid);
	
}
