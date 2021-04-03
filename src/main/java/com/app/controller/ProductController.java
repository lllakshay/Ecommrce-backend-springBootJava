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

import com.app.pojos.Product;
import com.app.service.IProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;
	
	public ProductController()
	{
		System.out.println("in contr of "+getClass().getName());
	}
	
	@GetMapping("/allProducts")
	public List<Product> getAllProducts()
	{
		return productService.getAllProducts();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Integer id)
	{
		 try 
		 {
		 	return new ResponseEntity<>(productService.getProdutById(id),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.NOT_FOUND);
		 }
	}
	
	@GetMapping("/{category}")
	public List<Product> getProductByCategory(@PathVariable String category)
	{
		 return productService.getProductByCategory(category);
	}
	
	@PostMapping("/insert")
	public ResponseEntity<?> addNewProduct(@RequestBody Product product)
	{
		 try 
		 {
		 	return new ResponseEntity<>(productService.addNewProduct(product),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@PutMapping("/insert")
	public ResponseEntity<?> updateProduct(@RequestBody Product product)
	{
		 try 
		 {
		 	return new ResponseEntity<>(productService.updateProduct(product),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteProductById(@PathVariable Integer id)
	{
		try 
		 {
		 	return new ResponseEntity<>(productService.deleteProductById(id),HttpStatus.CREATED);
		 }
		 catch(RuntimeException e)
		 {
		   	return new ResponseEntity<>("valid details not given",HttpStatus.INTERNAL_SERVER_ERROR);
		 }
	}
	
	
}
