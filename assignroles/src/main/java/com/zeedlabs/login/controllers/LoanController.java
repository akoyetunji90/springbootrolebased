package com.zeedlabs.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.login.entity.LoanDetails;
import com.zeedlabs.login.repository.LoanRepository;
import com.zeedlabs.login.service.LoanService;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;

	@Autowired
	private LoanRepository repo;
	
	@GetMapping("/loan/new")

	public String showLoanForm(Model model) {
		LoanDetails loan = new LoanDetails();
		model.addAttribute("loan", loan);

		loanService.loanMaturityList(model);
        loanService.repaymentTypeList(model);
        loanService.productTypeList(model);
        
		return "loan_form";
	}
	
	  @PostMapping("/loan/new") public String submitForm(@ModelAttribute("loan")
	  LoanDetails loan) { System.out.println(loan);
	  
	  loanService.registerLoanDetails(loan);
	  
	  return "loan_page";
	  
	  }
	 
	@GetMapping("/loan/table")
	public String listLoans(Model model) {
		List<LoanDetails> listLoans = repo.findAll();

		model.addAttribute("loan", new LoanDetails());
		model.addAttribute("listLoans", listLoans);
		
		return "loan_table";
	}
	
}