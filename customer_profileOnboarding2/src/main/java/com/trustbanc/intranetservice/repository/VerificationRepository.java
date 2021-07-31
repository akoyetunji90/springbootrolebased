package com.trustbanc.intranetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trustbanc.intranetservice.entity.Customer;
import com.trustbanc.intranetservice.entity.VerificationPage;

public interface VerificationRepository extends JpaRepository<VerificationPage, Integer>{
	
	 @Query("SELECT u FROM Customer u WHERE u.email = ?1") Customer findByEmail(String email);
	 
}
