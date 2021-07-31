package com.zeedlabs.demo.repository;


import com.zeedlabs.demo.entity.Payment;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface PaymentRepo extends CrudRepository<Payment,Long>{
	List<Payment> findAll();

	//Payment delete();
	//Optional<Payment> findAllById(Long valueOf);
   
}