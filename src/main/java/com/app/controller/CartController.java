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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Cart;
import com.app.pojos.Product;
import com.app.pojos.UserAddress;
import com.app.service.ICartService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cart")
public class CartController {

	
	@Autowired
	private ICartService cartService;
	
	public CartController()
	{
		System.out.println("in cnst of "+getClass().getName());
	}
	
	@GetMapping("/allProducts")
	public List<Cart> getAllCart()
	{
		return cartService.getAllCart();
	}
	
	@GetMapping("/{uid}")
	public List<Cart> getAddressByUserId(@PathVariable int uid)
	{
		return cartService.getCartByUserId(uid);
	}	
	
	@PostMapping("/addProduct/{uid}")
	public ResponseEntity<?> addProductInCart(@PathVariable Integer uid,@RequestBody Cart cart)
	{
		 try 
		 {
		 	return new ResponseEntity<>(cartService.addProductInCart(cart,uid),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@PostMapping("/updateProduct/{id}")
	public ResponseEntity<?> updateProductInCart(@PathVariable Integer id,@RequestBody Cart cart)
	{
		 try 
		 {
		 	return new ResponseEntity<>(cartService.updateProductInCart(cart,id),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductInCart(@PathVariable Integer id)
	{
		 try 
		 {
		 	return new ResponseEntity<>(cartService.deleteProductInCart(id),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@DeleteMapping("/delete/user/{uid}")
	public ResponseEntity<?> deleteProductInCartByUserId(@PathVariable Integer uid)
	{
	 	return new ResponseEntity<>(cartService.deleteProductInCartByUserId(uid),HttpStatus.CREATED);
	}
	
}
