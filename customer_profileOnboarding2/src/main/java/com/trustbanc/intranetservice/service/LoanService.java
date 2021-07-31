package com.trustbanc.intranetservice.service;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.trustbanc.intranetservice.entity.LoanDetails;
import com.trustbanc.intranetservice.repository.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository loanRepo;

	public void registerLoanDetails(LoanDetails loan) {

		loanRepo.save(loan);
	}

	public void loanStatusList(Model model) {

		List<String> loanStatusList = Arrays.asList(" ", "Validated", "Satisfactory", "invalid details",
				"Invalid IPPIS", "Eligible For 12 Months");
		model.addAttribute("loanStatusList", loanStatusList);

	}

	public void productTypeList(Model model) {

		List<String> productTypeList = Arrays.asList(" ", "Nigeria Police Force", "Nigeria Custom Service", "Correctional Service",
				"MDA(Federal Ministry", "F.C.T.A", "L.A.S.G", "Tertiary Institution");
		model.addAttribute("productTypeList", productTypeList);

	}

	
	public void repaymentTypeList(Model model) {

		List<String> repaymentTypeList = Arrays.asList(" ", "Weekly", "Monthly", "Quarterly",
				"Annually");
		model.addAttribute("repaymentTypeList", repaymentTypeList);

	}


	public void liquidationStatusList(Model model) {

		List<String> liquidationStatusList = Arrays.asList(" ", "Liquidated", "Active", "Inactive", "Dormant",
				"Requested");
		model.addAttribute("liquidationStatusList", liquidationStatusList);

	}

	public void loanMaturityList(Model model) {

		List<String> loanMaturityList = Arrays.asList(" ", "3 Months", "6 Months", "9 Months", "12 Months", "15 Months",
				"18 Months", "24 Months");
		model.addAttribute("loanMaturityList", loanMaturityList);

	}

	public void calculateLoan(Model model) {

		Scanner scan = new Scanner(System.in);

		// User input
		System.out.print("Please enter the requested loan amount: ");
		double loanamount = scan.nextDouble();
		double balance = loanamount;
		System.out.print("Please enter the interest rate per year (in %): ");
		double annualinterestrate = scan.nextDouble() / 100;// Convert to %
		double monthlyinterestrate = annualinterestrate / 12;// Calculate monthly interest
		System.out.print("Please enter the monthly payment you intend to pay : ");
		double monthlypayment = scan.nextDouble();

		double interestpaid = loanamount * monthlyinterestrate;
		double principalpaid = monthlypayment - interestpaid;
		double totalinterestpaid = 0.0;

		double newbalance;

		// User information header
		System.out.print("\n" + "Loan amount: " + (loanamount) + "\t" + "Annual Interest Rate: " + (annualinterestrate)
				+ "\t" + "Monthly Payment: " + (monthlypayment));

		// Table header
		System.out.println("\n\n\n" + "Month #" + "\t" + "Total-Payment" + "\t" + "Amount-Interest-Paid" + "\t"
				+ "Amount-Debt-Paid" + "\t" + "Loan-Balance");
		System.out.println("-------" + "\t" + "-------------" + "\t" + "--------------------" + "\t"
				+ "----------------" + "\t" + "------------");

		// Calculations for table
		if (interestpaid > monthlypayment) {
			System.out.println("This loan can never be paid off at these rates.");
		} else {
			for (int month = 1; balance > 0; month++) {
				interestpaid = monthlyinterestrate * balance;
				principalpaid = monthlypayment - interestpaid;
				newbalance = balance - principalpaid;
				totalinterestpaid += interestpaid;

				System.out.println(month + "\t" + (monthlypayment) + "\t\t" + (interestpaid) + "\t\t\t"
						+ (principalpaid) + "\t\t\t" + (newbalance));
				balance = newbalance;
			}
		}

		System.out.println("\nTotal Interest Paid: " + totalinterestpaid);
	}
}