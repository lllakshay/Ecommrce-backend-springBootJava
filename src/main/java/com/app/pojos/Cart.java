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
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

//create table cart(
//id integer(50) unsigned auto_increment,
//user_id integer(50) unsigned not null,
//product_id integer(50) unsigned not null,
//quantity varchar(50) not null,
//total varchar(50) not null,
//wishlist boolean not null,
//constraint pk_id_cart primary key(id),
//constraint fk_user_id_cart foreign key (user_id) references user(id),
//constraint fk_product_id_cart foreign key (product_id) references product(id));



@Entity
@Table(name = "cart")
public class Cart {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "quantity")
	@NotBlank
	private String quantity;
	
	@Column(name = "total")
	@NotBlank
	private String total;
	
	@Column(name = "wishlist")
	@NotBlank
	private boolean wishlist;
	
	
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@Basic(optional = true)
	private User user;
	
	
	
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "product_id")
	@Basic(optional=true)
	private Product product;
	
	
	
		

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Cart(@NotBlank String quantity, @NotBlank String total, @NotBlank boolean wishlist, User user,
			Product product) {
		super();
		this.quantity = quantity;
		this.total = total;
		this.wishlist = wishlist;
		this.user = user;
		this.product = product;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getQuantity() {
		return quantity;
	}





	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}





	public String getTotal() {
		return total;
	}





	public void setTotal(String total) {
		this.total = total;
	}





	public boolean isWishlist() {
		return wishlist;
	}





	public void setWishlist(boolean wishlist) {
		this.wishlist = wishlist;
	}





	public User getUser() {
		return user;
	}





	public void setUser(User user) {
		this.user = user;
	}





	public Product getProduct() {
		return product;
	}





	public void setProduct(Product product) {
		this.product = product;
	}





	@Override
	public String toString() {
		return "Cart [id=" + id + ", quantity=" + quantity + ", total=" + total + ", wishlist=" + wishlist + ", user="
				+ user + ", product=" + product + "]";
	}



	
	
	
	
	
}
