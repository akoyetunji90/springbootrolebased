package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.login.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
