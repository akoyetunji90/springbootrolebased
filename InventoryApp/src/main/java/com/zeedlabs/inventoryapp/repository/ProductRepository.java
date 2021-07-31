package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
