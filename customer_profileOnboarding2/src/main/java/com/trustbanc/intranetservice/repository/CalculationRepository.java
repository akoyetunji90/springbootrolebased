package com.trustbanc.intranetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustbanc.intranetservice.entity.LoanCalculations;

public interface CalculationRepository extends JpaRepository<LoanCalculations, Integer>{

}
