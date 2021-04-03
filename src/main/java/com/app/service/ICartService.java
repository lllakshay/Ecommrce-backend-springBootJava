package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.pojos.Cart;
public interface ICartService {

	public List<Cart> getAllCart();

	public List<Cart> getCartByUserId(int uid);

	public Cart addProductInCart(Cart cart, Integer uid);

	public Cart updateProductInCart(Cart cart, Integer uid);

	public Cart deleteProductInCart(Integer id);

	public Cart deleteProductInCartByUserId(Integer uid);


}
