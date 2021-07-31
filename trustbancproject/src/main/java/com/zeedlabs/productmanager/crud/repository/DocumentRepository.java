package com.zeedlabs.productmanager.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zeedlabs.productmanager.crud.entity.Documents;

public interface DocumentRepository extends JpaRepository<Documents, Integer>{

}
