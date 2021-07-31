package com.zeedlabs.apiconsumption.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zeedlabs.apiconsumption.model.User;
import com.zeedlabs.apiconsumption.model.UtilityRequest;
import com.zeedlabs.apiconsumption.repository.UtilityRepository;

@RestController
@RequestMapping("/api/v2")
public class UtilityController {
 
    @Autowired
    private UtilityRepository utilRepo;

 
    @GetMapping("/users")
    public List<UtilityRequest> getAllUsers() {
         return utilRepo.findAll();
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UtilityRequest> getUserById(
      @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
         UtilityRequest user = utilRepo.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
        return ResponseEntity.ok().body(user);
    }

    @PostMapping("/users")
    public UtilityRequest createUser(@Validated @RequestBody UtilityRequest user) {
    	
        return utilRepo.save(user);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<UtilityRequest> updateUser(
      @PathVariable(value = "id") Long userId,
      @Validated @RequestBody UtilityRequest userDetails) throws ResourceNotFoundException {
        UtilityRequest user = utilRepo.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));
  
        user.setRefNumber(userDetails.getRefNumber());
        user.setBillerId(userDetails.getBillerId());
        user.setPackageId(userDetails.getPackageId());
        user.setAmount(userDetails.getAmount());
        user.setLastModifiedDate(new Date());
        final UtilityRequest updatedUser = utilRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/users/{id}")
    public Map<String, Boolean> deleteUser(
         @PathVariable(value = "id") Long userId) throws ResourceNotFoundException {
         UtilityRequest user = utilRepo.findById(userId)
          .orElseThrow(() -> new ResourceNotFoundException("User not found :: " + userId));

        utilRepo.delete(user);
         Map<String, Boolean> response = new HashMap<>();
         response.put("deleted", Boolean.TRUE);
         return response;
    }
}