package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeedlabs.login.entity.Role;
import com.zeedlabs.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	User findByEmail(String email);
	
	@Query
	("SELECT r FROM Role r WHERE r.name = ?1")
	public Role findByName(String name);
	
	
	 }
