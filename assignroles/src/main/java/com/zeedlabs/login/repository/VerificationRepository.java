package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeedlabs.login.entity.Customer;
import com.zeedlabs.login.entity.VerificationPage;

public interface VerificationRepository extends JpaRepository<VerificationPage, Integer>{
	
	 @Query("SELECT u FROM Customer u WHERE u.email = ?1") Customer findByEmail(String email);
	 
}
