package com.app.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.ERole;
import com.app.pojos.Role;

public interface IRoleDao extends JpaRepository<Role, Integer> {

	Optional<Role> findByName(ERole roleUser);

}
