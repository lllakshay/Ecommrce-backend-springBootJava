package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserCard;

public interface IUserCardDao extends JpaRepository<UserCard, Integer>{

	List<UserCard> getUserCardByUserId(int id);

	
}
