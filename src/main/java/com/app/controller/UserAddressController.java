package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.UserAddress;
import com.app.service.IUserAddressService;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/address")
public class UserAddressController {
	
	@Autowired
	private IUserAddressService userAddressService;
	
	public UserAddressController()
	{
		System.out.println("in ctrl of "+getClass().getName());
	}
	
	@GetMapping("/alladdress")
	public List<UserAddress> getAllUserAddress()
	{
		return userAddressService.getAllUserAddress();
	}
	
	@GetMapping("/{uid}")
	public List<UserAddress> getAddressByUserId(@PathVariable int uid)
	{
		return userAddressService.getAddressByUserId(uid);
	}
	
	@GetMapping("/{aid}")
	public UserAddress getAddressById(@PathVariable int aid)
	{
		return userAddressService.getAddressById(aid);
	}
	
	@PostMapping("/insert/{uid}")
	public ResponseEntity<?> addUserAddress(@PathVariable Integer uid,@RequestBody UserAddress userAddress)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userAddressService.addNewUser(userAddress,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<?> updateUserAddress(@PathVariable Integer uid,@RequestBody UserAddress userAddress)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userAddressService.updateUser(userAddress,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.NOT_FOUND);
		 }
	}
	
	@DeleteMapping("/delete/{aid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer aid)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userAddressService.DeleteUserAddressById(aid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.NOT_FOUND);
		 }
	}
	
	

}
