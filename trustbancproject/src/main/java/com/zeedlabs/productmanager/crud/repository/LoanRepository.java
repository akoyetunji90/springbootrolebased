package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.productmanager.crud.entity.LoanDetails;

public interface LoanRepository extends JpaRepository<LoanDetails, Integer>{

}
