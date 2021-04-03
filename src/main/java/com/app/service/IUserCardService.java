package com.app.service;

import java.util.List;

import com.app.pojos.UserAddress;
import com.app.pojos.UserCard;

public interface IUserCardService {

	public List<UserCard> getAllUserCard();
	
	public List<UserCard> getCardByUserId(int cid);

	public UserCard addNewUser(UserCard userCard,Integer uid);

	public UserCard updateUser(UserCard userCard, Integer uid);

	public UserCard DeleteUserCardById(Integer cid);

	public UserCard getCardById(int cid);

}
