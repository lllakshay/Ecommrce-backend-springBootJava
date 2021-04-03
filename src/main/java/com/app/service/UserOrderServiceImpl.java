package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserDao;
import com.app.dao.IUserOrderDao;
import com.app.pojos.UserAddress;
import com.app.pojos.UserOrder;

@Service
@Transactional
public class UserOrderServiceImpl implements IUserOrderService {


	@Autowired
	private IUserOrderDao userOrderDao; 
	
	@Autowired
	private IUserDao userDao;
	
	
	@Override
	public List<UserOrder> getAllOrders() {
		// TODO Auto-generated method stub
		return userOrderDao.findAll();
	}


	@Override
	public List<UserOrder> getOrderesByUserId(Integer uid) {
		// TODO Auto-generated method stub
		
		return userOrderDao.findByUserId(uid);
	}


	@Override
	public UserOrder addNewOrder(UserOrder userOrder, Integer uid) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
