package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.pojos.Admin;
import com.app.service.IAdminService;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private IAdminService adminService;
	
	public AdminController()
	{
		System.out.println("in cntr of "+getClass().getName());
	}
	
	@GetMapping
	public List<Admin> getAllAdmins()
	{
		return adminService.getAllAdmins();
	}
	
}
