package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.shopping.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}
