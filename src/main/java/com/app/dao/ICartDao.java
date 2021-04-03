package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Cart;

public interface ICartDao extends JpaRepository<Cart, Integer> {

	List<Cart> findByUserId(int uid);

	void deleteByUserId(Integer uid);



}
