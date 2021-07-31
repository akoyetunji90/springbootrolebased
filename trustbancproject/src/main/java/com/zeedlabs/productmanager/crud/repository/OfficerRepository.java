package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.productmanager.crud.entity.AccountOfficer;

public interface OfficerRepository extends JpaRepository<AccountOfficer, Integer>{

}
