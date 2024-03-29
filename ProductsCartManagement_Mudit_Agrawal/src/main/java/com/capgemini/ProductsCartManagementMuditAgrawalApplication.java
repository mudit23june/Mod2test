package com.capgemini;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.capgemini")
@EntityScan("com.capgemini.beans")

public class ProductsCartManagementMuditAgrawalApplication
{
	public static void main(String[] args)
	{
		SpringApplication.run(ProductsCartManagementMuditAgrawalApplication.class, args);
	}
}
