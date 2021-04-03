package com.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IRoleDao;
import com.app.pojos.ERole;
import com.app.pojos.Role;

@Service
@Transactional
public class RoleServiceImpl implements IRoleService {

	@Autowired
	private IRoleDao roleDao;
	
	@Override
	public Optional<Role> findByName(ERole roleUser) {
		// TODO Auto-generated method stub
		return roleDao.findByName(roleUser);
	}

}
