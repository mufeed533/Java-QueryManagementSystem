package com.assistanz.SpringQueryManagement.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@EntityListeners(AuditingEntityListener.class)
@Table(name = "product_info")
public class Products implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotBlank
	private String name;
	
	@NotBlank
	private String description;
	
	private int price;
	
	public Products(){
		
	}
	
	Products(int id, String name, String description, int price){
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	public int getId(){
		return this.id;
	}
	public void setId(int id){
		this.id = id;
	}
	
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name = name;
	}
	
	public String getDescription(){
		return this.description;
	}
	public void setDescription(String description){
		this.description = description;
	}
	
	public int getPrice(){
		return this.price;
	}
	public void setPrice(int price){
		this.price = price;
	}
}
	
