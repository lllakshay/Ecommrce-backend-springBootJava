package com.app.service;

import java.util.List;

import com.app.pojos.UserAddress;
import com.app.pojos.UserOrder;

public interface IUserOrderService {

	public List<UserOrder> getAllOrders();

	public List<UserOrder> getOrderesByUserId(Integer uid);

	public UserOrder addNewOrder(UserOrder userOrder, Integer uid);



}
