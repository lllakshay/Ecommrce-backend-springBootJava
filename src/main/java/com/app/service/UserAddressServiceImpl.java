package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IUserAddressDao;
import com.app.dao.IUserDao;
import com.app.exception.UserException;
import com.app.pojos.UserAddress;

@Service
@Transactional
public class UserAddressServiceImpl implements IUserAddressService {

	
	@Autowired
	private IUserAddressDao userAddressDao;
	
	@Autowired
	private IUserDao userDao;
	
	@Override
	public List<UserAddress> getAllUserAddress() {
		// TODO Auto-generated method stub
		return userAddressDao.findAll();
	}

	@Override
	public List<UserAddress> getAddressByUserId(int id) {

		return userAddressDao.getUserAddressByUserId(id);
		
		
	}

	@Override
	public UserAddress addNewUser(UserAddress userAddress,Integer uid) {
		// TODO Auto-generated method stub
		userAddress.setUser(userDao.getOne(uid));
		userAddressDao.save(userAddress);
		return userAddress;
	}

	@Override
	public UserAddress updateUser(UserAddress userAddress, Integer uid) {
		// TODO Auto-generated method stub
		userAddress.setUser(userDao.getOne(uid));
		userAddressDao.save(userAddress);
		return userAddress;
	}

	@Override
	public UserAddress DeleteUserAddressById(Integer aid) {
		// TODO Auto-generated method stub
		Optional<UserAddress> optUserAddress = userAddressDao.findById(aid);
		UserAddress userAddress=optUserAddress.orElseThrow(()->new UserException("Invalid UserAddress Id.."));
		userAddressDao.deleteById(aid);
		return userAddress;
	}

	@Override
	public UserAddress getAddressById(int aid) {
		Optional<UserAddress> optUserAddress=userAddressDao.findById(aid);
		UserAddress userAddress=optUserAddress.orElseThrow(()-> new UserException("Enter Valid User Address Id"));
		return userAddress;
	}

}
