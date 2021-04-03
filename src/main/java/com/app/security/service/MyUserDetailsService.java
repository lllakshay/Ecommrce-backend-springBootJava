package com.app.security.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.pojos.User;

@Service
public class MyUserDetailsService implements UserDetailsService {

	
	public MyUserDetailsService() {
		// TODO Auto-generated constructor stub
		System.out.println("in cnst of "+getClass().getName());
	}
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userDao.findByUserName(username)
					.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		System.out.println(user);
		
		return UserDetailsPojos.build(user);
	
		
	}
	
	
}
