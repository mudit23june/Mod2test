package com.capgemini.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Product;
import com.capgemini.service.IProductService;

@RestController	
public class ProductController
{	
	@Autowired
	IProductService service;
	
	public IProductService getService()
	{
		return service;
	}

	public void setService(IProductService service)
	{
		this.service = service;
	}
	
	@RequestMapping(value="/createProduct", consumes="application/json", produces="application/json", method=RequestMethod.POST)
	public Product createProduct(@Valid @RequestBody Product product)
	{
		product = service.createProduct(product);
		return product;
	}
	
	@RequestMapping(value="/products/{id}", consumes="application/json", produces="application/json",method=RequestMethod.PUT)
	public Product updateProduct(@RequestBody Product product)
	{
		product = service.updateProduct(product);
		return product;
	}
	
	@RequestMapping(value="/deleteProduct/{id}", produces="application/json", method=RequestMethod.DELETE)
	public Product removeProduct(@PathVariable String id)
	{
		Product product = service.removeProduct(id);
		return product;
	}
	
	@RequestMapping(value="/products", produces="application/json", method=RequestMethod.GET)
	public List<Product> viewProducts() 
	{
		List<Product> products = service.viewProducts();
		return products;
	}
	
	@RequestMapping(value="/findProduct/{id}", produces="application/json")
	public Product findProduct(@PathVariable String id)
	{
		Product product = service.findProduct(id);
		return product;
	}
}
