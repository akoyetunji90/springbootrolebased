package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
