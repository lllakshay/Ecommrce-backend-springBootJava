package com.app.pojos;

import java.time.LocalDate;
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
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//create table userOrder(
//id integer(50) unsigned auto_increment,
//user_id integer(50) unsigned not null,
//product_id integer(50) unsigned not null,
//userCard_id integer(50) unsigned not null,
//status boolean not null,
//quantity varchar(50) not null,
//price varchar(50) not null,
//cod  boolean not null,
//orderdate date not null,
//constraint pk_id_order primary key(id),
//constraint fk_user_id_order foreign key (user_id) references user(id),
//constraint fk_product_id_order foreign key (product_id) references product(id),
//constraint fk_userCard_id_order foreign key (userCard_id) references userCard(id));


@Entity
@Table(name = "userOrder")
public class UserOrder {

	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name = "")
	private Integer id;
	
	@Column(name = "status")
	@NotBlank
	private boolean status;
	
	@Column(name = "quantity")
	@NotBlank
	private String quantity;
	
	@Column(name = "price")
	@NotBlank
	private String price;
	
	@Column(name = "cod")
	@NotBlank
	private boolean cod;
	
	@Column(name = "orderDate")
	@NotBlank
	private LocalDate orderDate;
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Basic(optional = true)
	private User user;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userAddress_id")
	@Basic(optional = true)
	private UserAddress userAddress;
	
	
	
	@OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
	@JoinColumn(name = "userCard_id",nullable = false,unique = true)
	private UserCard userCard;
	
	
	
	@OneToMany(mappedBy = "userOrder",cascade = CascadeType.ALL,orphanRemoval = true)
	@JsonIgnoreProperties("userOrder")
	@Fetch(FetchMode.JOIN)
	@Basic(optional = true)
	private List<OrderedProduct> orderProductList=new ArrayList<>();
	
		
	
	
	public UserOrder() {
		super();
		// TODO Auto-generated constructor stub
	}




	public UserOrder(@NotBlank boolean status, @NotBlank String quantity, @NotBlank String price, @NotBlank boolean cod,
			@NotBlank LocalDate orderDate, User user, UserAddress userAddress, UserCard userCard,
			List<OrderedProduct> orderProductList) {
		super();
		this.status = status;
		this.quantity = quantity;
		this.price = price;
		this.cod = cod;
		this.orderDate = orderDate;
		this.user = user;
		this.userAddress = userAddress;
		this.userCard = userCard;
		this.orderProductList = orderProductList;
	}


	// add helper method to establish a bi dir link between parent n child
	public void addOrderedProduct(OrderedProduct s) {
		// p ---> c
		orderProductList.add(s);
		// c ---> p
		s.setUserOrder(this);
	}
	
	// add helper method to remove a bi dir link between parent n child
	public void removeOrderedProduct(OrderedProduct s) {
		// p --X-> c
		orderProductList.remove(s);
		// c -X--> p
		s.setUserOrder(null);
	}

		

	public Integer getId() {
		return id;
	}




	public void setId(Integer id) {
		this.id = id;
	}




	public boolean isStatus() {
		return status;
	}




	public void setStatus(boolean status) {
		this.status = status;
	}




	public String getQuantity() {
		return quantity;
	}




	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}




	public String getPrice() {
		return price;
	}




	public void setPrice(String price) {
		this.price = price;
	}




	public boolean isCod() {
		return cod;
	}




	public void setCod(boolean cod) {
		this.cod = cod;
	}




	public LocalDate getOrderDate() {
		return orderDate;
	}




	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}




	public User getUser() {
		return user;
	}




	public void setUser(User user) {
		this.user = user;
	}




	public UserAddress getUserAddress() {
		return userAddress;
	}




	public void setUserAddress(UserAddress userAddress) {
		this.userAddress = userAddress;
	}




	public UserCard getUserCard() {
		return userCard;
	}




	public void setUserCard(UserCard userCard) {
		this.userCard = userCard;
	}




	public List<OrderedProduct> getOrderProductList() {
		return orderProductList;
	}




	public void setOrderProductList(List<OrderedProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}




	@Override
	public String toString() {
		return "UserOrder [id=" + id + ", status=" + status + ", quantity=" + quantity + ", price=" + price + ", cod="
				+ cod + ", orderDate=" + orderDate + ", user=" + user + ", userAddress=" + userAddress + ", userCard="
				+ userCard + ", orderProductList=" + orderProductList + "]";
	}

	
	
	
	
	
}
