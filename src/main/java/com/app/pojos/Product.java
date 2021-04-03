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
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.engine.FetchStyle;
import org.hibernate.engine.FetchTiming;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

//create table product (
//id integer(50) unsigned auto_increment,
//productName varchar(100) not null,
//price varchar(50) not null,
//availableUnits varchar(50) not null,
//descreption varchar(225) not null,
//constraint pk_id_product primary key(id));



@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "productName", length = 20)
	@NotBlank(message = "Please enter productName")
	private String productName;
	
	@Column(name = "price", length = 20)
	@NotBlank(message = "Please enter product price")
	private String price;
	
	@Column(name = "availableUnits", length = 20)
	@NotBlank(message = "Please available Units")
	private String availableUnits;
	
	@Column(name = "descreption", length = 255)
	@NotBlank(message = "Please enter descreption of product")
	private String description;
	
	@Column(name = "category", length = 255)
	@NotBlank(message = "Please enter descreption of product")
	private String category;
	
	
	
	
	
//	@OneToMany(mappedBy = "product",cascade=CascadeType.ALL,orphanRemoval = true)
//	@JsonIgnoreProperties("product")
////	@Fetch(FetchMode.JOIN)
//	@Basic(optional = true)
//	private List<Cart> cartList=new ArrayList<>();
//	
//	
//	
//	
	@OneToMany(mappedBy = "product")
	@JsonIgnoreProperties("product")
	@Fetch(FetchMode.JOIN)
	@Basic(optional = true)
	private List<OrderedProduct> orderProductList=new ArrayList<>();
	
	
	
	
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}





	public Product(@NotBlank(message = "Please enter productName") String productName,
			@NotBlank(message = "Please enter product price") String price,
			@NotBlank(message = "Please available Units") String availableUnits,
			@NotBlank(message = "Please enter descreption of product") String description, String category) {
		super();
		this.productName = productName;
		this.price = price;
		this.availableUnits = availableUnits;
		this.description = description;
		this.category = category;
	}





	public Integer getId() {
		return id;
	}





	public void setId(Integer id) {
		this.id = id;
	}





	public String getProductName() {
		return productName;
	}





	public void setProductName(String productName) {
		this.productName = productName;
	}





	public String getPrice() {
		return price;
	}





	public void setPrice(String price) {
		this.price = price;
	}





	public String getAvailableUnits() {
		return availableUnits;
	}





	public void setAvailableUnits(String availableUnits) {
		this.availableUnits = availableUnits;
	}





	public String getDescription() {
		return description;
	}





	public void setDescription(String description) {
		this.description = description;
	}







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
//	public List<OrderedProduct> getOrderProductList() {
//		return orderProductList;
//	}







	public void setOrderProductList(List<OrderedProduct> orderProductList) {
		this.orderProductList = orderProductList;
	}
	
	
	
	
	public String getCategory() {
		return category;
	}
	
	
	
	
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	
//
//
//
//
//
//	@Override
//	public String toString() {
//		return "Product [id=" + id + ", productName=" + productName + ", price=" + price + ", availableUnits="
//				+ availableUnits + ", description=" + description + ", category=" + category + ", cartList=" + cartList
//				+ ", orderProductList=" + orderProductList + "]";
//	}
//




	
	
	
	


}
