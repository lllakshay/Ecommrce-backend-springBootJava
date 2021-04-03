package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.ICartDao;
import com.app.dao.IUserDao;
import com.app.exception.UserException;
import com.app.pojos.Cart;

@Service
@Transactional
public class CartServiceImpl implements ICartService{

	@Autowired
	private ICartDao cartDao;
	
	@Autowired
	private IUserDao userDao;
	
	public CartServiceImpl()
	{
		System.out.println("in const of "+getClass().getName());
	}
	
	
	@Override
	public List<Cart> getAllCart() {
		// TODO Auto-generated method stub
		return cartDao.findAll();
	}


	@Override
	public List<Cart> getCartByUserId(int uid) {
		// TODO Auto-generated method stub
		return cartDao.findByUserId(uid);
	}


	@Override
	public Cart addProductInCart(Cart cart, Integer uid) {
		cart.setUser(userDao.getOne(uid));
		cartDao.save(cart);
		return cart;
	}


	@Override
	public Cart updateProductInCart(Cart cart, Integer uid) {
		cart.setUser(userDao.getOne(uid));
		cartDao.save(cart);
		return cart;
	}


	@Override
	public Cart deleteProductInCart(Integer id) {
		Optional<Cart> optCart=cartDao.findById(id);
		Cart cart=optCart.orElseThrow(()->new UserException(" Id Not Available "));
		cartDao.deleteById(id);
		return cart;
	}


	@Override
	public Cart deleteProductInCartByUserId(Integer uid) {
		cartDao.deleteByUserId(uid);
		return null;
	}



	
	
	
	
	
	

}
