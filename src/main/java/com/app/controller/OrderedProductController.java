package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.OrderedProduct;
import com.app.pojos.UserAddress;
import com.app.service.IOrderdProductService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/Orders")
public class OrderedProductController {

	@Autowired
	private IOrderdProductService orderdProductService;

	public OrderedProductController() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@GetMapping("/all")
	public List<OrderedProduct> getAllOrderes()
	{
		return orderdProductService.getAllOrderes();
	}
	
//	@GetMapping("/{uid}")
//	public List<OrderedProduct> getOrderesByUserId(@PathVariable Integer uid)
//	{
//		return orderdProductService.getOrderesByUserId(uid);
//	}
	
	
}
