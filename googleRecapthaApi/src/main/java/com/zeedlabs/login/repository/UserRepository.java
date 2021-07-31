package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeedlabs.login.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	}
