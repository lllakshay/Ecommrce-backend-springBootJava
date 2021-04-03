package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.User;

public interface IUserService {

	public List<User> getAllUsers();

	//check customer login
	public User getUserByEmailPass(String email, String password);

	public boolean existsByUserName(String userName);

	public boolean existsByEmail(String email);

	public void createNewUser(User user);

	public User deleteCustomer(int cid);

	public User getUserById(int id);
	
}
