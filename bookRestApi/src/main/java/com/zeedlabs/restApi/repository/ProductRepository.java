package com.zeedlabs.restApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.restApi.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
