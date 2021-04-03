package com.app.pojos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.validator.constraints.UniqueElements;

import com.app.security.payload.request.SignupRequest;
import com.fasterxml.jackson.annotation.JsonEnumDefaultValue;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


//create table user (
//id integer(50) unsigned auto_increment,
//firstName varchar(25) not null,
//lastName varchar(25),
//email varchar(25) unique not null,
//password varchar(225) not null,
//mobileNo varchar(25) unique not null,
//activeStatus boolean not null,
//admin boolean not null,
//constraint pk_id_user primary key(id));


@Entity
@Table(name="user")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="userName",length=25,unique=true)
	@NotBlank(message = "Enter UserName id")
	private String userName;
	

	@Column(name="firstName",length=25)
	@NotBlank(message = "Enter your first name")
	private String firstName;
	
	@Column(name="lastName",length=25)
	@NotBlank(message = "Enter your last name")
	private String lastName;
	
	@Column(name="email",length=25,unique=true)
	@NotBlank(message = "Enter Email id")
	private String email;
	
	@Column(name="password",length=255)
	@NotBlank(message = "Enter password")
	private String password;
	
	@Column(name="mobileNo",length=25,unique=true)
	@NotBlank(message = "Enter mobile number ")
	@Min(value = 10, message = "Please enter 10 digits only")
	private String mobileNo;
	
	@Column(name="activeStatus")
	private boolean activeStatus;
	

	@Column(name="seller")
	private boolean seller;
	
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(	name = "user_roles", 
				joinColumns = @JoinColumn(name = "user_id"), 
				inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();
	
	
//	@OneToMany(mappedBy = "user" ,fetch = FetchType.EAGER,cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("user")
//	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<UserOrder> userOrderList=new ArrayList<>();
//	
//	
//	
//	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("user")
////	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<UserAddress> userAddressList=new ArrayList<>();
//	
//	
//	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("user")
////	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<UserCard> userCardList=new ArrayList<>();
//	
//	
//	
//	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("user")
//	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<Cart> cartList =new ArrayList<>();
//	
//	
//	
//	@OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("user")
////	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<Payment> paymentList =new ArrayList<>();
//	
//	
//	
//	
//	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public User( String username,
			String firstName,
			String lastName,
			String email,
			String password,
			String mobileNo,
			boolean activeStatus,
			boolean seller) {
		super();
		this.userName = username;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.mobileNo = mobileNo;
		this.activeStatus = activeStatus;
		this.seller = seller;
	}
	
	
	
	
	

	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}



	
	public String getUsername() {
		return userName;
	}
	
	
	
	
	
	public void setUsername(String username) {
		this.userName = username;
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






	public Set<Role> getRoles() {
		return roles;
	}






	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}




//	public List<UserOrder> getUserOrderList() {
//		return userOrderList;
//	}
//
//
//
//
//
//	public void setUserOrderList(List<UserOrder> userOrderList) {
//		this.userOrderList = userOrderList;
//	}
//
//
//
//
//
//	public List<UserAddress> getUserAddressList() {
//		return userAddressList;
//	}
//
//
//
//
//
//	public void setUserAddressList(List<UserAddress> userAddressList) {
//		this.userAddressList = userAddressList;
//	}
//
//
//
//
//
//	public List<UserCard> getUserCardList() {
//		return userCardList;
//	}
//
//
//
//
//
//	public void setUserCardList(List<UserCard> userCardList) {
//		this.userCardList = userCardList;
//	}
//
//
//
//
//
//	public List<Cart> getCartList() {
//		return cartList;
//	}
//
//
//
//
//
//	public void setCartList(List<Cart> cartList) {
//		this.cartList = cartList;
//	}
//
//
//
//
//
//	public List<Payment> getPaymentList() {
//		return paymentList;
//	}
//
//
//
//
//
//	public void setPaymentList(List<Payment> paymentList) {
//		this.paymentList = paymentList;
//	}
//
//
//
//
//
	
//	// add helper method to establish a bi dir link between parent n child
//	public void addUserAddress(UserAddress a) {
//		// p ---> c
//		userAddressList.add(a);
//		// c ---> p
//		a.setUser(this);
//	}
//
//	// add helper method to remove a bi dir link between parent n child
//	public void removeUserAddress(UserAddress a) {
//		// p --X-> c
//		userAddressList.remove(a);
//		// c -X--> p
//		a.setUser(null);
//	}
//	
//	// add helper method to establish a bi dir link between parent n child
//	public void addUserCard(UserCard c) {
//		// p ---> c
//		userCardList.add(c);
//		// c ---> p
//		c.setUser(this);
//	}
//
//	// add helper method to remove a bi dir link between parent n child
//	public void removeUserCard(UserCard c) {
//		// p --X-> c
//		userCardList.remove(c);
//		// c -X--> p
//		c.setUser(null);
//	}
//	
//	public void addUserOrder(UserOrder c) {
//		// p ---> c
//		userOrderList.add(c);
//		// c ---> p
//		c.setUser(this);
//	}
//
//	// add helper method to remove a bi dir link between parent n child
//	public void removeUserOrder(UserOrder c) {
//		// p --X-> c
//		userCardList.remove(c);
//		// c -X--> p
//		c.setUser(null);
//	}
//	
//	public void addCart(Cart c) {
//		// p ---> c
//		CartList.add(c);
//		// c ---> p
//		c.setUser(this);
//	}
//
//	// add helper method to remove a bi dir link between parent n child
//	public void removeCart(Cart c) {
//		// p --X-> c
//		CartList.remove(c);
//		// c -X--> p
//		c.setUser(null);
//	}


	
	
	


	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + userName + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", password=" + password + ", mobileNo=" + mobileNo + ", activeStatus="
				+ activeStatus + ", seller=" + seller + ", roles=" + roles + "]";
	}
	
	

}
