package com.zeedlabs.qrCode.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.zeedlabs.qrCode.entity.Product;

@Repository
("productRepository")
public interface ProductRepository extends CrudRepository<Product, String> {
}
