package com.app.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.OrderedProduct;

public interface IOrderedProductDao extends JpaRepository<OrderedProduct, Integer> {

//	List<OrderedProduct> findByUserId(Integer uid);

}
