package com.zeedlabs.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zeedlabs.demo.entity.Payment;
import com.zeedlabs.demo.repository.PaymentRepo;
import com.zeedlbas.demo.model.BaseResponse;

@Service
public class PaymentService {
   @Autowired	
   PaymentRepo paymentRepo;

   
   public BaseResponse savePaymentRecord(Payment payment){
	   BaseResponse baseResponse = new BaseResponse();
	   baseResponse.setStatus(400);
	   baseResponse.setDescription("An error occured");
	   try {
		   Long recordId=paymentRepo.save(payment).getId();
		   baseResponse.setStatus(200);
		   baseResponse.setDescription("Your record has been saved successfully with the Id "+recordId);
		   baseResponse.setData(payment);
	   }catch(Exception ex) {
		   
		   ex.printStackTrace();
	   }
	   return baseResponse;
	   
	   
   }
   
   public BaseResponse retrievedRecordById(String userId) {
	   BaseResponse baseResponse = new BaseResponse();
	   baseResponse.setStatus(400);
	   baseResponse.setDescription("An error occured");
	   try {
		   Optional<Payment> optPayment=paymentRepo.findById(Long.valueOf(userId));
		   
		   if(! optPayment.isPresent()){
			   baseResponse.setStatus(400);
			   baseResponse.setDescription("Payment record not found");
			   return baseResponse;
			   
		   }
		   Payment payment = optPayment.get();
		   baseResponse.setStatus(200);
		   baseResponse.setDescription("Successful");
		   baseResponse.setData(payment);
		   
	   }catch(Exception ex) {
		   
		   ex.printStackTrace();
	   }
	   
	   
	   return baseResponse;
	   
   }
  
   public BaseResponse retrieveAllRecordById(){
	   BaseResponse baseResponse = new BaseResponse();
	   baseResponse.setStatus(400);
	   baseResponse.setDescription("An error occured");
	   try {
		  List<Payment> payments = paymentRepo.findAll();
		  if(payments.isEmpty()) {
			  baseResponse.setStatus(400);
			  baseResponse.setDescription("No record to display!");
			  return baseResponse;
		  }
		  
		  baseResponse.setStatus(200);
		   baseResponse.setDescription("Successful");
		   baseResponse.setData(payments);
		   
		  
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	   return baseResponse;
     }
   public void deleteById(Long id) {
	   paymentRepo.deleteById(id);
	   
   }
   
}