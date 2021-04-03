package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.exception.UserException;
import com.app.pojos.User;

@Service
@Transactional
public class UserServiceImpl implements IUserService{
	
	public UserServiceImpl()
	{
		System.out.println(" inn cnst of "+getClass().getName());
	}

	@Autowired
	private IUserDao userDao;


	@Override
	public List<User> getAllUsers() {
		System.out.println("in GetAllUsers Service");
		// TODO Auto-generated method stub
		return userDao.findAll();
	}


	@Override
	public User getUserByEmailPass(String email, String password) {
		// TODO Auto-generated method stub
		return userDao.getUser(email, password).orElseThrow(() -> new UserException("invalid credentials"));
	}


	@Override
	public boolean existsByUserName(String userName) {
		// TODO Auto-generated method stub
		return userDao.existsByUserName(userName);
	}


	@Override
	public boolean existsByEmail(String email) {
		// TODO Auto-generated method stub
		return userDao.existsByEmail(email);
	}


	@Override
	public void createNewUser(User user) {
		// TODO Auto-generated method stub
		userDao.save(user);
	}


	@Override
	public User deleteCustomer(int cid) {
		// TODO Auto-generated method stub
		Optional<User> optUser =userDao.findById(cid);
		User prevUser=optUser.orElseThrow(()->new UserException("Invalid cust Id.."));
		 userDao.deleteById(cid);
		 return prevUser;
	}


	@Override
	public User getUserById(int id) {
		
		Optional<User> OptUser=userDao.findById(id);
		
		User user=OptUser.orElseThrow(()->new UserException("User Not Found With given id"));
		
		return user;
	}

	
}
