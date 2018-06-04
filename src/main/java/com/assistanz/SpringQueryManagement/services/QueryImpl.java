package com.assistanz.SpringQueryManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.assistanz.SpringQueryManagement.entities.Queries;
import com.assistanz.SpringQueryManagement.exception.ResourceNotFoundException;
import com.assistanz.SpringQueryManagement.repositories.QueryRepository;

@Service
public class QueryImpl {
	
	@Autowired
	QueryRepository queryRepository;
	
	public List<Queries> getQueries(){
		List<Queries> queryList = queryRepository.findAll();
		return queryList;
	}
	
	public Queries getQueryById(int id){
		return queryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Query", "Id", id));
	}
	
	public Queries updateQuery(int id, Queries queryDetails){
		Queries query = queryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Query", "Id", id));
		
		query.setFirstName(queryDetails.getfirstName());
		query.setLastName(queryDetails.getLastName());
		query.setEmail(queryDetails.getEmail());
		query.setQuery(queryDetails.getQuery());
		return queryRepository.save(query);
	}
	
	public Queries createQuery(Queries Query){
		return queryRepository.save(Query);
	}
	
	public ResponseEntity<?> deleteQuery(int id){
		Queries query = queryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Query", "Id", id));
		queryRepository.delete(query);
		return ResponseEntity.ok().build();
	}
}
