package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IOrderedProductDao;
import com.app.pojos.OrderedProduct;
@Service
@Transactional
public class OrderedProductServiceImpl implements IOrderdProductService{

	@Autowired
	private IOrderedProductDao orderedProductDao;
	
	
	@Override
	public List<OrderedProduct> getAllOrderes() {
		// TODO Auto-generated method stub
		return orderedProductDao.findAll();
	}

//
//	@Override
//	public List<OrderedProduct> getOrderesByUserId(Integer uid) {
//		// TODO Auto-generated method stub
//		return orderedProductDao.findByUserId(uid);
//	}

}
