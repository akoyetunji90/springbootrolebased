package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.zeedlabs.productmanager.crud.model.Product;
import com.zeedlabs.productmanager.crud.model.User;

public interface ProductRepository extends JpaRepository<Product, Integer> {
	
	
	 @Query("SELECT u FROM User u WHERE u.username = :username") public User
	 getUserByUsername(@Param("username") String username);
	 	
	
}
