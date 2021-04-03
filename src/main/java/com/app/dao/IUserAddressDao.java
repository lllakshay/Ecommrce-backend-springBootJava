package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.UserAddress;

public interface IUserAddressDao extends JpaRepository<UserAddress, Integer> {

	List<UserAddress> getUserAddressByUserId(int id);
	
}
