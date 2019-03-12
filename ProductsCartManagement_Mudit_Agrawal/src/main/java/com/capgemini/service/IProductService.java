package com.capgemini.service;

import java.util.List;

import com.capgemini.beans.Product;

public interface IProductService
{
	
	public Product createProduct(Product product);
	public Product findProduct(String id);
	public Product updateProduct(Product product);
	public List<Product> viewProducts();
	public Product removeProduct(String id);

}
