package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IAdminDao;
import com.app.pojos.Admin;


@Service
@Transactional
public class AdminServiceImpl implements IAdminService {

	public AdminServiceImpl()
	{
		System.out.println("in cnst of "+getClass().getName());
	}
	
	
	@Autowired
	private IAdminDao adminDao;
	
	@Override
	public List<Admin> getAllAdmins() {
		// TODO Auto-generated method stub
		return adminDao.findAll();
	}

	
}
