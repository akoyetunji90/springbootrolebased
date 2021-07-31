package com.trustbanc.intranetservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.trustbanc.intranetservice.entity.LoanCalculations;
import com.trustbanc.intranetservice.entity.LoanDetails;
import com.trustbanc.intranetservice.repository.CalculationRepository;
import com.trustbanc.intranetservice.repository.LoanRepository;
import com.trustbanc.intranetservice.service.LoanService;

@Controller
public class LoanController {

	@Autowired
	private LoanService loanService;

	@Autowired
	private LoanRepository repo;
	
	@Autowired
	private CalculationRepository calRepo;

	@GetMapping("/loan/new")

	public String showLoanForm(Model model) {
		LoanDetails loan = new LoanDetails();
		model.addAttribute("loan", loan);

		loanService.loanMaturityList(model);
        loanService.repaymentTypeList(model);
		return "loan_form";
	}

	@PostMapping("/loan/new")
	public String submitForm(@ModelAttribute("loan") LoanDetails loan) {
		System.out.println(loan);

		loanService.registerLoanDetails(loan);

		return "loan_page";
	}

	@GetMapping("/loan/table")
	public String listLoans(Model model) {
		List<LoanDetails> listLoans = repo.findAll();

		model.addAttribute("loan", new LoanDetails());
		model.addAttribute("listLoans", listLoans);

       // loanService.calculateLoan(model);

		return "loan_table";
	}
	
	@GetMapping("/calculation/loan")
	public String loanCalculations(Model model) {
		List<LoanCalculations> listCalculations = calRepo.findAll();

		model.addAttribute("cal", new LoanCalculations());

		model.addAttribute("listCalculations", listCalculations);

        loanService.calculateLoan(model);

		return "calculation_table";
	}

}
