package com.app.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//create table userCard(
//id integer(50) unsigned auto_increment,
//user_id integer(50) unsigned not null,
//cardNumber varchar(25) not null,
//expireDate varchar(25) not null,
//cardName varchar(25) not null,
//constraint pk_id_userCard primary key(id),
//constraint fk_user_id_userCard foreign key (user_id) references user(id));


@Entity
@Table(name = "userCard")
public class UserCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "cardNumber")
	@NotBlank
	private String cardNumber;
	
	@Column(name = "expireDate")
	@NotBlank
	private String expireDate;
	
	
	@Column(name = "cardName")
	@NotBlank
	private String cardName;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	@Basic(optional = true)
	private User user;
	
	
	
	@OneToMany(mappedBy = "userCard",orphanRemoval = true)
	@JsonIgnoreProperties("userCard")
	@Fetch(FetchMode.JOIN)
	@Basic(optional = true)
	private List<UserOrder> userOrderList=new ArrayList<>();
	
	
	
	public UserCard() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserCard(@NotBlank String cardNumber, @NotBlank String expireDate, @NotBlank String cardName, User user) {
		super();
		this.cardNumber = cardNumber;
		this.expireDate = expireDate;
		this.cardName = cardName;
		this.user = user;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getCardNumber() {
		return cardNumber;
	}



	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}



	public String getExpireDate() {
		return expireDate;
	}



	public void setExpireDate(String expireDate) {
		this.expireDate = expireDate;
	}



	public String getCardName() {
		return cardName;
	}



	public void setCardName(String cardName) {
		this.cardName = cardName;
	}



	public User getUser() {
		return user;
	}



	public void setUser(User user) {
		this.user = user;
	}



//	public List<UserOrder> getUserOrderList() {
//		return userOrderList;
//	}



	public void setUserOrderList(List<UserOrder> userOrderList) {
		this.userOrderList = userOrderList;
	}



	@Override
	public String toString() {
		return "UserCard [id=" + id + ", cardNumber=" + cardNumber + ", expireDate=" + expireDate + ", cardName="
				+ cardName + ", user=" + user + ", userOrderList=" + userOrderList + "]";
	}


	
	
	
	
	

}
