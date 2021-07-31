package com.zeedlabs.inventoryapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.inventoryapp.user.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {

}
