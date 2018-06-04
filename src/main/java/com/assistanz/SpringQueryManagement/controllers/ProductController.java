package com.assistanz.SpringQueryManagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.assistanz.SpringQueryManagement.entities.Products;
import com.assistanz.SpringQueryManagement.services.ProductImpl;

@RestController
@RequestMapping("/product-api")
public class ProductController {

	@Autowired
	ProductImpl productImpl;

	@GetMapping("/products")
	public List<Products> getProducts(){
		return productImpl.getProducts();
	}
	
	@GetMapping("/products/{id}")
	public Products getProductById(@PathVariable int id){
		return productImpl.getProductById(id);
	}

	@PutMapping("/products/{id}")
	public Products updateProduct(@PathVariable(value = "id") int id, @RequestBody Products productDetails){
		return productImpl.updateProduct(id, productDetails);
	}
	
	@PostMapping("/products")
	public Products createProduct(@Valid @RequestBody Products product){
		return productImpl.createProduct(product);
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") int id){
		return productImpl.deleteProduct(id);
	}
	
	@GetMapping("/products/home")
	public String home(Model model,@RequestParam(value="name", required=false, defaultValue="World") String name){
		model.addAttribute("name", name);
        return "hello";
	}
}
