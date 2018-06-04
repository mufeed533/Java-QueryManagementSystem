package com.assistanz.SpringQueryManagement.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assistanz.SpringQueryManagement.entities.Queries;
import com.assistanz.SpringQueryManagement.services.QueryImpl;

@RestController
@RequestMapping("/query-api")
public class QueryController {
	
	
	@Autowired
	QueryImpl queryImpl;

	@GetMapping("/queries")
	public List<Queries> getQueries(){
		return queryImpl.getQueries();
	}
	
	@GetMapping("/queries/{id}")
	public Queries getQueryById(@PathVariable int id){
		return queryImpl.getQueryById(id);
	}

	@PutMapping("/queries/{id}")
	public Queries updateQuery(@PathVariable(value = "id") int id, @RequestBody Queries queryDetails){
		return queryImpl.updateQuery(id, queryDetails);
	}
	
	@PostMapping("/queries")
	public Queries createQuery(@Valid @RequestBody Queries Query){
		return queryImpl.createQuery(Query);
	}
	
	@DeleteMapping("/queries/{id}")
	public ResponseEntity<?> deleteQuery(@PathVariable(value = "id") int id){
		return queryImpl.deleteQuery(id);
	}
}