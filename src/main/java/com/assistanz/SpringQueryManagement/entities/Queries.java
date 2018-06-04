package com.assistanz.SpringQueryManagement.entities;

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
@Table(name = "queries")
public class Queries {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int queryId;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String email;
	
	@NotBlank
	private String query;
	
	public Queries(){
		
	}
	
	Queries(int query_id,String firstName,String lastName,String email,String query){
		this.queryId = query_id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.query = query;
	}
	
	public int getQueryId(){
		return this.queryId;
	}
	
	public void setQueryId(int queryId){
		this.queryId = queryId;
	}
	
	public String getfirstName(){
		return this.firstName;
	}
	
	public void setFirstName(String firstName){
		this.firstName = firstName;
	}
	public String getLastName(){
		return this.lastName;
	}
	
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	public String getEmail(){
		return this.email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	public String getQuery(){
		return this.query;
	}
	
	public void setQuery(String query){
		this.query = query;
	}
}
