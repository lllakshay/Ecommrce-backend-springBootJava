package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.pojos.User;
import java.lang.String;


public interface IUserDao extends JpaRepository<User, Integer > {

	//check customer
		@Query("select u from User u where u.email=?1 and  u.password=?2")
		Optional<User> getUser(String email, String password);

		
		Optional<User> findByUserName(String userName);
		

		Boolean existsByUserName(String userName);
		
		Boolean existsByEmail(String email);
		
}
