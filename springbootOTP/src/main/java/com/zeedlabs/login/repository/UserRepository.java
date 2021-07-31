package com.zeedlabs.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.zeedlabs.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("SELECT u FROM User u WHERE u.email = ?1")
	public User findByEmail(String email);
	
	/*
	 * @Query("SELECT u FROM User u WHERE u.verificationCode = ?1") public User
	 * findByVerificationCode(String verificationCode);
	 * 
	 * @Query("Update User u Set u.enable = true WHERE u.id = ?1")
	 * 
	 * @Modifying public void enable(Integer id);
	 */	
	public User findByResetPasswordToken(String token);
}
