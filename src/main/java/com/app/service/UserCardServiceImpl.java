package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserCardDao;
import com.app.dao.IUserDao;
import com.app.exception.UserException;
import com.app.pojos.UserCard;


@Service
@Transactional
public class UserCardServiceImpl implements IUserCardService{

	@Autowired
	private IUserCardDao userCardDao;
	
	@Autowired
	private IUserDao userDao;
	
	public UserCardServiceImpl()
	{
		System.out.println("in cnst of "+getClass().getName());
	}
	
	@Override
	public List<UserCard> getAllUserCard() {
		return userCardDao.findAll();
	}
	

	@Override
	public List<UserCard> getCardByUserId(int id) {

		return userCardDao.getUserCardByUserId(id);
		
		
	}

	@Override
	public UserCard addNewUser(UserCard userCard,Integer uid) {
		// TODO Auto-generated method stub
		userCard.setUser(userDao.getOne(uid));
		userCardDao.save(userCard);
		return userCard;
	}

	@Override
	public UserCard updateUser(UserCard userCard, Integer uid) {
		// TODO Auto-generated method stub
		userCard.setUser(userDao.getOne(uid));
		userCardDao.save(userCard);
		return userCard;
	}

	@Override
	public UserCard DeleteUserCardById(Integer cid) {
		// TODO Auto-generated method stub
		Optional<UserCard> optUserCard = userCardDao.findById(cid);
		UserCard userCard=optUserCard.orElseThrow(()->new UserException("Invalid UserCard Id.."));
		userCardDao.deleteById(cid);
		return userCard;
	}

	@Override
	public UserCard getCardById(int cid) {
		Optional<UserCard> optUserCard=userCardDao.findById(cid);
		UserCard userCard=optUserCard.orElseThrow(()-> new UserException("Enter Valid User Card Id"));
		return userCard;
	}


}
