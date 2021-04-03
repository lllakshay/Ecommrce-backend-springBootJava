package com.app.security.service;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.pojos.ERole;
import com.app.pojos.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

//class to store data fetched from database for authentication purposes
public class UserDetailsPojos implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String username;
	
	private String firstName;
	
	private String lastName;
	
	private String email;
	
	@JsonIgnore
	private String password;
	
	private String mobileNo;
	
	private boolean activeStatus;
	
	private boolean seller;
	
	private  Collection<? extends GrantedAuthority> authorities;
	
	


	public UserDetailsPojos(Integer id, String username, String firstName, String lastName, String email,
			String password, String mobileNo, boolean activeStatus, boolean seller, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.activeStatus = activeStatus;
		this.seller = seller;
		this.authorities = authorities;
	}



	public static UserDetailsPojos build(User user) {
		
		List<GrantedAuthority> authorities = user.getRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName().name()))
				.collect(Collectors.toList());

		return new UserDetailsPojos(
				user.getId(),
				user.getUsername(),
				user.getFirstName(), 
				user.getLastName(),
				user.getEmail(),
				user.getPassword(),
				user.getMobileNo(),
				user.isActiveStatus(),
				user.isSeller(),
				authorities);
		
	}
	
	
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return authorities;
	}

	
	
	public Integer getId() {
		return id;
	}



	public String getFirstName() {
		return firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public String getEmail() {
		return email;
	}



	public String getMobileNo() {
		return mobileNo;
	}


	public boolean isSeller() {
		return seller;
	}




	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsPojos user = (UserDetailsPojos) o;
		return Objects.equals(id, user.id);
	}

}
