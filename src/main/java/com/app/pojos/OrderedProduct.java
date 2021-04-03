package com.app.pojos;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="OrderProduct")
public class OrderedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	
	private int quantity;
	
	
	private double price;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	@Basic(optional=true)
	private Product product;


	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userOrder_id")
	@Basic(optional = true)
	private UserOrder userOrder;
	
	

	public OrderedProduct() {
		super();
		// TODO Auto-generated constructor stub
	}



	public OrderedProduct(int quantity, double price, Product product) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.product = product;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public UserOrder getUserOrder() {
		return userOrder;
	}



	public void setUserOrder(UserOrder userOrder) {
		this.userOrder = userOrder;
	}



	@Override
	public String toString() {
		return "OrderProduct [id=" + id + ", quantity=" + quantity + ", price=" + price + ", product=" + product
				+ ", userOrder=" + userOrder + "]";
	}
	
	
	
	
	
	
}
