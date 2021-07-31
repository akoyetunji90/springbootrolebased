package com.trustbanc.intranetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustbanc.intranetservice.entity.LoanDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Integer>{

}
