package com.capgemini.repository;

import java.util.List;

import com.capgemini.beans.Product;

public interface IProductRepo
{
	
	public Product createProduct(Product product);
	public Product findProduct(String id);
	public Product updateProduct(Product product);
	public List<Product> viewProducts();
	public Product removeProduct(String id);
	
}
