package com.capgemini.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Product;
import com.capgemini.repository.IProductRepo;

@Transactional
@Service("service")
public class ProductServiceImpl implements IProductService
{
	@Autowired
	IProductRepo repo;
	
	public IProductRepo getRepo()
	{
		return repo;
	}

	public void setRepo(IProductRepo repo)
	{
		this.repo = repo;
	}

	@Override
	public Product createProduct(Product product)
	{
		return repo.createProduct(product);
	}

	@Override
	public Product findProduct(String id)
	{
		return repo.findProduct(id);
	}

	@Override
	public Product updateProduct(Product product)
	{
		return repo.updateProduct(product);
	}

	@Override
	public List<Product> viewProducts()
	{
		return repo.viewProducts();
	}

	@Override
	public Product removeProduct(String id)
	{
		return repo.removeProduct(id);
	}
}