package com.zeedlabs.apiconsumption.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class AccountOfficer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstname;
	private String lastname;
	private String phonenumber;
	private String street;
	private String city;
	private String stateOfOrigin;
	private String gender;
	private String married;
	private String email;

	private Date birthdate;
	private Date employmentdate;
	private Date retirementdate;
	private String designation;
	private String password;
	private String confirmpassword;

	private String officersName;
	private String officersId;
	private String accountNumber;
	private String accountBalance;
	private String productName;
	private String productId;
	private String loanTenure;

	private boolean terms;
	private boolean mailing;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateoforigin() {
		return stateOfOrigin;
	}

	public void setStateoforigin(String stateoforigin) {
		this.stateOfOrigin = stateoforigin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMarried() {
		return married;
	}

	public void setMarried(String married) {
		this.married = married;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getEmploymentdate() {
		return employmentdate;
	}

	public void setEmploymentdate(Date employmentdate) {
		this.employmentdate = employmentdate;
	}

	public Date getRetirementdate() {
		return retirementdate;
	}

	public void setRetirementdate(Date retirementdate) {
		this.retirementdate = retirementdate;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	
	public String getStateOfOrigin() {
		return stateOfOrigin;
	}

	public void setStateOfOrigin(String stateOfOrigin) {
		this.stateOfOrigin = stateOfOrigin;
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

	public String getOfficersName() {
		return officersName;
	}

	public void setOfficersName(String officersName) {
		this.officersName = officersName;
	}

	public String getOfficersId() {
		return officersId;
	}

	public void setOfficersId(String officersId) {
		this.officersId = officersId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getLoanTenure() {
		return loanTenure;
	}

	public void setLoanTenure(String loanTenure) {
		this.loanTenure = loanTenure;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

}
