package com.trustbanc.intranetservice.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.trustbanc.intranetservice.entity.LoanDetails;
import com.trustbanc.intranetservice.entity.VerificationPage;
import com.trustbanc.intranetservice.repository.VerificationRepository;

@Service
public class VerificationService {

	@Autowired
	private VerificationRepository verifyRepo;

	public void verifyLoanDetails(VerificationPage verify) {
		
			verifyRepo.save(verify);

	}

	public void dateOfBirthList(Model model) {

		List<String> ageLimitList = Arrays.asList(" ", "Exceeded Age Limit", "Eligible For 12 Months Tenure", "Satisfactory"
				,"Approved");
		model.addAttribute("ageLimitList", ageLimitList);

	}

	public void dateOfEnlistmentList(Model model) {

		List<String> dateOfEnlistmentList = Arrays.asList(" ", "Exceeded Length Of Service","Satisfactory", "Eligible For 12 Months Tenure"
				,"Approved");
		model.addAttribute("dateOfEnlistmentList", dateOfEnlistmentList);

	}
	
	public void ippisNumberList(Model model) {

		List<String> ippisNumberList = Arrays.asList(" ", "Wrong Ippis Number", "Invalid Ippis Number","Satisfactory"
				,"Approved");
		model.addAttribute("ippisNumberList", ippisNumberList);

	}


	public void validIdTypeList(Model model) {

		List<String> validIdTypeList = Arrays.asList(" ", "Valid", "Invalid", "Satisfactory");
		model.addAttribute("validIdTypeList", validIdTypeList);

	}
	public void loanStatusList(Model model) {

		List<String> loanStatusList = Arrays.asList(" ", "Approved", "Unapproved", "Satisfactory");
		model.addAttribute("loanStatusList", loanStatusList);

	}
	public void netPayList(Model model) {

		List<String> netPayList = Arrays.asList(" ", "Two Most Consistent", "Least Of The Three Inconsistent", "Inconsistent", "Satisfactory");
		model.addAttribute("netPayList", netPayList);

	}

}