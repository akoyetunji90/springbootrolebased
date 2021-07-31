package com.trustbanc.intranetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustbanc.intranetservice.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
