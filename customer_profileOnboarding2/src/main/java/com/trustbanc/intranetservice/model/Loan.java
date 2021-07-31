package com.trustbanc.intranetservice.model;

import java.util.Scanner;

public class Loan {
	
		public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// User input
		System.out.print("Please enter the requested loan amount: ");
		double loanamount = scan.nextDouble();
		double balance = loanamount;
		System.out.print("Please enter the interest rate per year (in %): ");
		double annualinterestrate = scan.nextDouble() / 100;// Convert to %
		double monthlyinterestrate = annualinterestrate / 12;// Calculate monthly interest
		System.out.print("Please enter the monthly payment you intend to make: ");
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