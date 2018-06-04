package com.assistanz.SpringQueryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assistanz.SpringQueryManagement.entities.Queries;

@Repository
public interface QueryRepository extends JpaRepository<Queries, Integer>{

}
