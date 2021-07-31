package com.zeedlabs.apiconsumption.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zeedlabs.apiconsumption.model.User;
import com.zeedlabs.apiconsumption.model.UtilityRequest;

@Repository
public interface UtilityRepository extends JpaRepository<UtilityRequest, Long>{

}
