package com.zeedlabs.productmanager.crud.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "officers_table")
public class AccountOfficer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String firstname;
	private String lastname;
	private String phonenumber;
	private String street;
	private String city;
	private String stateoforigin;
	private String gender;
	private String married;
	private String email;

	private Date birthdate;
	private Date employmentdate;
	private Date retirementdate;
	private String designation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
		return stateoforigin;
	}
	public void setStateoforigin(String stateoforigin) {
		this.stateoforigin = stateoforigin;
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
		
}
