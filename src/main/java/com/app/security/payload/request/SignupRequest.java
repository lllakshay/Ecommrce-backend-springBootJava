package com.app.security.payload.request;


import java.util.Set;

import javax.validation.constraints.*;

public class SignupRequest {

 
   
	@NotBlank
	@Size(min = 3, max = 20)
	private String UserName;
	
	
	@NotBlank
	private String firstName;
	
	private String lastName;
	
	@NotBlank
	@Email
	private String email;
	
	@NotBlank
	 @Size(min = 6, max = 40)
	private String password;
	
	@NotBlank
	@Min(value = 10, message = "Please enter 10 digits")
	private String mobileNo;
	
	private boolean activeStatus;

	private boolean seller;
	
	private Set<String> role;
    
	
	

	public SignupRequest() {
		super();
		// TODO Auto-generated constructor stub
	}



	public String getUserName() {
		return UserName;
	}


	public void setUserName(String userName) {
		UserName = userName;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getMobileNo() {
		return mobileNo;
	}


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public boolean isActiveStatus() {
		return activeStatus;
	}


	public void setActiveStatus(boolean activeStatus) {
		this.activeStatus = activeStatus;
	}


	public boolean isSeller() {
		return seller;
	}


	public void setSeller(boolean seller) {
		this.seller = seller;
	}



	public Set<String> getRole() {
		return role;
	}



	public void setRole(Set<String> role) {
		this.role = role;
	}

	
	
	
}
