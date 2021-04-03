package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.UserCard;
import com.app.service.IUserCardService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/card")
public class UserCardController {

	
	@Autowired
	private IUserCardService userCardService;
	
	
	public UserCardController()
	{
		System.out.println("in cntr of "+getClass().getName());
	}
	
	@GetMapping("/getall")
	public List<UserCard> getAllUserCard()
	{
		return userCardService.getAllUserCard();
	}
	
	@GetMapping("/{uid}")
	public List<UserCard> getCardByUserId(@PathVariable int uid)
	{
		return userCardService.getCardByUserId(uid);
	}
	
	@GetMapping("/{cid}")
	public UserCard getCardById(@PathVariable int cid)
	{
		return userCardService.getCardById(cid);
	}
	
	@PostMapping("/insert/{uid}")
	public ResponseEntity<?> addUserCard(@PathVariable Integer uid,@RequestBody UserCard userCard)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userCardService.addNewUser(userCard,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@PutMapping("/update/{uid}")
	public ResponseEntity<?> updateUserCard(@PathVariable Integer uid,@RequestBody UserCard userCard)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userCardService.updateUser(userCard,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.NOT_FOUND);
		 }
	}
	
	@DeleteMapping("/delete/{cid}")
	public ResponseEntity<?> deleteById(@PathVariable Integer cid)
	{
		 try 
		 {
		 	return new ResponseEntity<>(userCardService.DeleteUserCardById(cid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.NOT_FOUND);
		 }
	}
	
	
}
