package com.zeedlabs.apiconsumption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeedlabs.apiconsumption.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
