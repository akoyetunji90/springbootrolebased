package com.zeedlabs.productmanager.crud.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "verification_table")
public class VerificationPage {

	@Id
	private Integer officersid;

	private String dateofenlistment;
	private String agelimit;
	private String ippisnumber;
	private String netpay;
	private String deadserviceratio;
	private String valididtype;
	private String loanstatus;
	
	
	
	public Integer getOfficersid() {
		return officersid;
	}

	public void setOfficersid(Integer officersid) {
		this.officersid = officersid;
	}

	public String getDateofenlistment() {
		return dateofenlistment;
	}

	public void setDateofenlistment(String dateofenlistment) {
		this.dateofenlistment = dateofenlistment;
	}

	public String getAgelimit() {
		return agelimit;
	}

	public void setAgelimit(String agelimit) {
		this.agelimit = agelimit;
	}

	public String getIppisnumber() {
		return ippisnumber;
	}

	public void setIppisnumber(String ippisnumber) {
		this.ippisnumber = ippisnumber;
	}

	public String getNetpay() {
		return netpay;
	}

	public void setNetpay(String netpay) {
		this.netpay = netpay;
	}

	public String getDeadserviceratio() {
		return deadserviceratio;
	}

	public void setDeadserviceratio(String deadserviceratio) {
		this.deadserviceratio = deadserviceratio;
	}

	public String getValididtype() {
		return valididtype;
	}

	public void setValididtype(String valididtype) {
		this.valididtype = valididtype;
	}

	public String getLoanstatus() {
		return loanstatus;
	}

	public void setLoanstatus(String loanstatus) {
		this.loanstatus = loanstatus;
	}

}
