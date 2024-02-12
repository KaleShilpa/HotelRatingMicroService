package com.javaexpress.userservice.service;

import java.util.List;

import com.javaexpress.userservice.entity.User;

public interface UserService {

	User save(User user);
	
	List<User> getAllUsers();
	
	User getUser(String userId);
	
}
