package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.login.entity.LoanDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Integer>{

}
