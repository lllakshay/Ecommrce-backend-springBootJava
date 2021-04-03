package com.app.service;

import java.util.Optional;

import com.app.pojos.ERole;
import com.app.pojos.Role;

public interface IRoleService {

	Optional<Role> findByName(ERole roleUser);

}
