package com.assistanz.SpringQueryManagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assistanz.SpringQueryManagement.entities.Products;

@Repository
public interface ProductRepository extends JpaRepository<Products, Integer> {

}
