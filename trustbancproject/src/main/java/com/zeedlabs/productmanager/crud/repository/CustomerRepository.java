package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.productmanager.crud.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
