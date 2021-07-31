package com.zeedlabs.oneToManyExample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeedlabs.oneToManyExample.Model.Instructor;

@Repository
public interface InstructorRepository extends JpaRepository<Instructor, Long>{

}