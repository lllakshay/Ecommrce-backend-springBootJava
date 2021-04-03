package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.IProductDao;
import com.app.exception.UserException;
import com.app.pojos.Product;
import com.app.pojos.UserCard;

@Service
@Transactional
public class ProductServiceImpl implements IProductService {
	
		
	public ProductServiceImpl()
	{
		System.out.println(" in cnst of "+getClass().getName());
	}
	
	@Autowired
	private IProductDao productDao;

	
	@Override
	public List<Product> getAllProducts() {

		return productDao.findAll();
	}

	@Override
	public List<Product> getProductByCategory(String category) {
		// TODO Auto-generated method stub
		return productDao.getProductByCategory(category);
	}

	
	@Override
	public Product getProdutById(Integer id) {
		// TODO Auto-generated method stub
		return productDao.getOne(id);
	}

	@Override
	public Product addNewProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		return productDao.save(product);
	}

	@Override
	public Product deleteProductById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Product> optUserCard = productDao.findById(id);
		Product product=optUserCard.orElseThrow(()->new UserException("Invalid Id.."));
		productDao.deleteById(id);
		return product;
	}
	

}
