package com.zeedlabs.productmanager.crud.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.productmanager.crud.entity.LoanDetails;
import com.zeedlabs.productmanager.crud.entity.VerificationPage;
import com.zeedlabs.productmanager.crud.repository.VerificationRepository;
import com.zeedlabs.productmanager.crud.service.VerificationService;

@Controller
public class VerificationController {

	@Autowired
	private VerificationService verifyService;

	@Autowired
	private VerificationRepository verifyRepo;
	
		
	  @GetMapping("/verify/new")
	  
	  public String showVerificationForm(Model model) { 
	  VerificationPage verify = new VerificationPage(); model.addAttribute("verify", verify);
	  
	  verifyService.dateOfBirthList(model);
	  verifyService.dateOfEnlistmentList(model);
	  verifyService.ippisNumberList(model); verifyService.loanStatusList(model);
	  verifyService.netPayList(model); verifyService.validIdTypeList(model);
	  
	  return "verification_form"; }
	  
	 	@PostMapping("/verify/new")
	public String submitForm(@ModelAttribute("verify") VerificationPage verify) {
		System.out.println(verify);

		verifyService.verifyLoanDetails(verify);

		return "verification_page";
	}

	@GetMapping("/verify/table")
	public String listVerification(Model model) {
		List<VerificationPage> listVerification = verifyRepo.findAll();

		model.addAttribute("verify", new VerificationPage());
		model.addAttribute("loan", new LoanDetails());

		model.addAttribute("listVerification", listVerification);

		return "verification_table";
	}
}