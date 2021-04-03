package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserOrder;


public interface IUserOrderDao extends JpaRepository<UserOrder, Integer>{

	List<UserOrder> findByUserId(Integer uid);

	
}
