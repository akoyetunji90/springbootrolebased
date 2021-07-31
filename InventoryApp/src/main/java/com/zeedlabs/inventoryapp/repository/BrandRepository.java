package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.entity.Brand;

public interface BrandRepository extends JpaRepository<Brand, Integer> {

}
