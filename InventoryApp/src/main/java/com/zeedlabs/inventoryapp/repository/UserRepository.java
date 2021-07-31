package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
