package com.trustbanc.intranetservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "calculation_loan")
public class LoanCalculations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffid;
	
	private double balance;
	private double annualinterestrate;
	private double monthlyinterestrate;
	private double monthlypayment;
	private double interestpaid;
	private double principalpaid;
	private double totalinterestpaid;
	private double newbalance;
	
	
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public double getAnnualinterestrate() {
		return annualinterestrate;
	}
	public void setAnnualinterestrate(double annualinterestrate) {
		this.annualinterestrate = annualinterestrate;
	}
	public double getMonthlyinterestrate() {
		return monthlyinterestrate;
	}
	public void setMonthlyinterestrate(double monthlyinterestrate) {
		this.monthlyinterestrate = monthlyinterestrate;
	}
	public double getMonthlypayment() {
		return monthlypayment;
	}
	public void setMonthlypayment(double monthlypayment) {
		this.monthlypayment = monthlypayment;
	}
	public double getInterestpaid() {
		return interestpaid;
	}
	public void setInterestpaid(double interestpaid) {
		this.interestpaid = interestpaid;
	}
	public double getPrincipalpaid() {
		return principalpaid;
	}
	public void setPrincipalpaid(double principalpaid) {
		this.principalpaid = principalpaid;
	}
	public double getTotalinterestpaid() {
		return totalinterestpaid;
	}
	public void setTotalinterestpaid(double totalinterestpaid) {
		this.totalinterestpaid = totalinterestpaid;
	}
	public double getNewbalance() {
		return newbalance;
	}
	public void setNewbalance(double newbalance) {
		this.newbalance = newbalance;
	}
}
