package com.zeedlabs.qrCode.service;

import com.zeedlabs.qrCode.entity.Product;

public interface ProductService {

	public Iterable<Product> findAll();

}