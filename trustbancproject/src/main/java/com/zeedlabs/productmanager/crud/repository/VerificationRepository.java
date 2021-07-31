package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeedlabs.productmanager.crud.entity.Customer;
import com.zeedlabs.productmanager.crud.entity.VerificationPage;

public interface VerificationRepository extends JpaRepository<VerificationPage, Integer>{
	
	 @Query("SELECT u FROM Customer u WHERE u.email = ?1") Customer findByEmail(String email);
	 
}
