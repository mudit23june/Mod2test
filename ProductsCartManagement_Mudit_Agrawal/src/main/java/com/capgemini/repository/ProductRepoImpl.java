package com.capgemini.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.capgemini.beans.Product;
import com.capgemini.exception.DuplicateID;
import com.capgemini.exception.EmptyList;
import com.capgemini.exception.IdDoesNotExist;

@Repository("repo")
public class ProductRepoImpl implements IProductRepo
{	
	@PersistenceContext
	EntityManager entityManager;
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	@Override
	public Product createProduct(Product product)
	{
		if(entityManager.find(Product.class, product.getId())!=null)
			throw new DuplicateID();
		entityManager.persist(product);
		entityManager.flush();
		return product;
	}

	@Override
	public Product findProduct(String id)
	{
		Product product = entityManager.find(Product.class, id);
		if(product==null)
			throw new IdDoesNotExist();
		product.setId(id);
		return product;
	}

	@Override
	public Product updateProduct(Product product)
	{
		if(entityManager.find(Product.class, product.getId())==null)
			throw new IdDoesNotExist();
		entityManager.merge(product);
		entityManager.flush();
		return product;	
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Product> viewProducts()
	{
		Query query = entityManager.createNativeQuery("select * from product");
		List<Product> products = query.getResultList();
		if(products.isEmpty())
			throw new EmptyList();
		return products;
	}

	@Override
	public Product removeProduct(String id)
	{
		Product product = entityManager.find(Product.class, id);
		if(product == null)
			throw new IdDoesNotExist();
		entityManager.remove(product);
		entityManager.flush();
		return product;
	}
}