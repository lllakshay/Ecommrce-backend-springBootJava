package com.app.service;

import java.util.List;

import com.app.pojos.Product;

public interface IProductService {

	public List<Product> getAllProducts();

	public List<Product> getProductByCategory(String category);

	public Product getProdutById(Integer id);

	public Product addNewProduct(Product product);

	public Product updateProduct(Product product);

	public Product deleteProductById(Integer id);

}
