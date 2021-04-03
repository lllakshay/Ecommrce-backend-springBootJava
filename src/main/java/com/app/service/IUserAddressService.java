package com.app.service;

import java.util.List;

import com.app.pojos.UserAddress;

public interface IUserAddressService {

	public List<UserAddress> getAllUserAddress();

	public List<UserAddress> getAddressByUserId(int id);

	public UserAddress addNewUser(UserAddress userAddress,Integer uid);

	public UserAddress updateUser(UserAddress userAddress, Integer uid);

	public UserAddress DeleteUserAddressById(Integer aid);

	public UserAddress getAddressById(int aid);

}
