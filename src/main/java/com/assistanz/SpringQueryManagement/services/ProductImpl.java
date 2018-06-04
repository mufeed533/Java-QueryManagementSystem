package com.assistanz.SpringQueryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assistanz.SpringQueryManagement.entities.Products;
import com.assistanz.SpringQueryManagement.exception.ResourceNotFoundException;
import com.assistanz.SpringQueryManagement.repositories.ProductRepository;

@Service
public class ProductImpl {

	@Autowired
	ProductRepository productRepository;
	
	public List<Products> getProducts(){
		List<Products> productList = productRepository.findAll();
		return productList;
	}
	
	public Products getProductById(int id){
		return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
	}
	
	public Products updateProduct(int id, Products productDetails){
		Products product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
		
		product.setName(productDetails.getName());
		product.setDescription(productDetails.getDescription());
		product.setPrice(productDetails.getPrice());
		return productRepository.save(product);
	}
	
	public Products createProduct(Products product){
		return productRepository.save(product);
	}
	
	public ResponseEntity<?> deleteProduct(int id){
		Products product = productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "Id", id));
		productRepository.delete(product);
		return ResponseEntity.ok().build();
	}
}
