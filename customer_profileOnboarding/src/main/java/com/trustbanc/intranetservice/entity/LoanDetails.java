package com.trustbanc.intranetservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "loan_details")
public class LoanDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer staffid;
	
	private double loanamount;
	private String accountnumber;
	private String maturationperiod;
	private String officersid;
	private String productname;
	private String repaymenttype;
	private String bvnnumber;
	private String ippisnumber;
	
	private boolean terms;
	private boolean mailing;
	public Integer getStaffid() {
		return staffid;
	}
	public void setStaffid(Integer staffid) {
		this.staffid = staffid;
	}
	public double getLoanamount() {
		return loanamount;
	}
	public void setLoanamount(double loanamount) {
		this.loanamount = loanamount;
	}
	public String getAccountnumber() {
		return accountnumber;
	}
	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}
	public String getMaturationperiod() {
		return maturationperiod;
	}
	public void setMaturationperiod(String maturationperiod) {
		this.maturationperiod = maturationperiod;
	}
	public String getOfficersid() {
		return officersid;
	}
	public void setOfficersid(String officersid) {
		this.officersid = officersid;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public String getRepaymenttype() {
		return repaymenttype;
	}
	public void setRepaymenttype(String repaymenttype) {
		this.repaymenttype = repaymenttype;
	}
	public String getBvnnumber() {
		return bvnnumber;
	}
	public void setBvnnumber(String bvnnumber) {
		this.bvnnumber = bvnnumber;
	}
	public String getIppisnumber() {
		return ippisnumber;
	}
	public void setIppisnumber(String ippisnumber) {
		this.ippisnumber = ippisnumber;
	}
	public boolean isTerms() {
		return terms;
	}
	public void setTerms(boolean terms) {
		this.terms = terms;
	}
	public boolean isMailing() {
		return mailing;
	}
	public void setMailing(boolean mailing) {
		this.mailing = mailing;
	}	
}
