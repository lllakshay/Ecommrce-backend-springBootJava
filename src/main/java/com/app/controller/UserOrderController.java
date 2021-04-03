package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.OrderedProduct;
import com.app.pojos.UserAddress;
import com.app.pojos.UserOrder;
import com.app.service.IUserOrderService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/order")
public class UserOrderController {

	public UserOrderController()
	{
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	@Autowired
	private IUserOrderService userOrderService;
	
	@GetMapping("/all")
	public List<UserOrder> getAllOrders()
	{
		return userOrderService.getAllOrders();
	}
	

	@GetMapping("/{uid}")
	public List<UserOrder> getOrderesByUserId(@PathVariable Integer uid)
	{	
		return userOrderService.getOrderesByUserId(uid);
	}
	
	@PostMapping("/insert/{uid}")
	public ResponseEntity<?> addNewOrder(@PathVariable Integer uid,@RequestBody UserOrder userOrder)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userOrderService.addNewOrder(userOrder,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	}
