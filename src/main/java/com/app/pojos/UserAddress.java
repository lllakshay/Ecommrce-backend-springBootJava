 package com.app.pojos;

import java.util.ArrayList;	
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//create table userAddress(
//id integer(50) unsigned auto_increment,
//user_id integer(50) unsigned not null,
//city varchar(50) not null,
//state varchar(50) not null,
//country varchar(50) not null,
//pincode varchar(50) not null,
//address varchar(225) not null,     
//constraint pk_id_userAddress primary key(id),
//constraint fk_user_id_userAddress foreign key (user_id) references user(id));




@Entity
@Table(name = "userAddress")
public class UserAddress {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	
	
	@Column(name = "city", length = 20)
	@NotBlank
	private String city;
	
	@Column(name = "state", length = 20)
	@NotBlank
	private String state;
	
	@Column(name = "country", length = 20)
	@NotBlank
	private String country;
	
	@Column(name = "pincode", length = 6)
	@NotBlank
	@Min(value = 6, message = "Please enter 6 digits pincode only")
	private String pincode;
	
	@Column(name = "address", length = 60)
	@NotBlank
	private String address;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Basic(optional = true)
	private User user;
	
	
	
//	@OneToMany(mappedBy = "userAddress")
//	@JsonIgnoreProperties("userAddress")
////	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<UserOrder> userOrderList=new ArrayList<>();
//	
	
	
	
	
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}





//	public UserAddress(@NotBlank String city, @NotBlank String state, @NotBlank String country,
//			@NotBlank @Min(value = 6, message = "Please enter 6 digits pincode only") String pincode,
//			@NotBlank String address, User user) {
//		super();
//		this.city = city;
//		this.state = state;
//		this.country = country;
//		this.pincode = pincode;
//		this.address = address;
//		this.user = user;
//	}





	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public String getCity() {
		return city;
	}





	public void setCity(String city) {
		this.city = city;
	}





	public String getState() {
		return state;
	}





	public void setState(String state) {
		this.state = state;
	}





	public String getCountry() {
		return country;
	}





	public void setCountry(String country) {
		this.country = country;
	}





	public String getPincode() {
		return pincode;
	}





	public void setPincode(String pincode) {
		this.pincode = pincode;
	}





	public String getAddress() {
		return address;
	}





	public void setAddress(String address) {
		this.address = address;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}




//
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
//	@Override
//	public String toString() {
//		return "UserAddress [id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", pincode="
//				+ pincode + ", address=" + address + ", user=" + user + ", userOrderList=" + userOrderList + "]";
//	}
//
//	
//	
	

	
	
}
