package com.trustbanc.intranetservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trustbanc.intranetservice.entity.AccountOfficer;

public interface OfficerRepository extends JpaRepository<AccountOfficer, Integer>{

}
