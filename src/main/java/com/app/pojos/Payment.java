//package com.app.pojos;
//
//import java.time.LocalDate;
//
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToOne;
//import javax.persistence.Table;
//
//
//
//@Entity
//@Table(name="payment")
//public class Payment {
//	
//	
//	
//	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
//	@Column(name="id")
//	private Integer id;
//	
//	
//	private String payment;
//	
//	
//	private LocalDate date;
//	
//	
//	
//	@ManyToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "user_id")
//	@Basic(optional = true)
//	private User user;
//
//	
//	
//	@OneToOne(mappedBy = "payment")
//	private UserOrder userOrder;
//	
//	
//	@ManyToOne
//	@JoinColumn(name = "UserCard_id")
//	@Basic(optional = true)
//	private UserCard userCard;
//	
//	
//
//	public Payment() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//
//
//
//	public Payment(String payment, LocalDate date, User user, UserCard userCard) {
//		super();
//		this.payment = payment;
//		this.date = date;
//		this.user = user;
//		this.userCard = userCard;
//	}
//
//
//
//	public Payment(String payment, LocalDate date, User user, UserOrder userOrder, UserCard userCard) {
//		super();
//		this.payment = payment;
//		this.date = date;
//		this.user = user;
//		this.userOrder = userOrder;
//		this.userCard = userCard;
//	}
//
//
//
//	public Integer getId() {
//		return id;
//	}
//
//
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//
//
//	public String getPayment() {
//		return payment;
//	}
//
//
//
//	public void setPayment(String payment) {
//		this.payment = payment;
//	}
//
//
//
//	public LocalDate getDate() {
//		return date;
//	}
//
//
//
//	public void setDate(LocalDate date) {
//		this.date = date;
//	}
//
//
//
//	public User getUser() {
//		return user;
//	}
//
//
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//
//
//	public UserOrder getUserOrder() {
//		return userOrder;
//	}
//
//
//
//	public void setUserOrder(UserOrder userOrder) {
//		this.userOrder = userOrder;
//	}
//
//
//
//	public UserCard getUserCard() {
//		return userCard;
//	}
//
//
//
//	public void setUserCard(UserCard userCard) {
//		this.userCard = userCard;
//	}
//
//
//
//	@Override
//	public String toString() {
//		return "Payment [id=" + id + ", payment=" + payment + ", date=" + date + ", user=" + user + ", userOrder="
//				+ userOrder + ", userCard=" + userCard + "]";
//	}
//	
//	
//	
//	
//	
//	
//
//}
