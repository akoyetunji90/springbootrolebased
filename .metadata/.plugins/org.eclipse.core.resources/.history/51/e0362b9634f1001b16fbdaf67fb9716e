package com.zeedlabs.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.login.entity.AccountOfficer;
import com.zeedlabs.login.repository.OfficerRepository;
import com.zeedlabs.login.service.OfficerService;

@Controller
public class OfficerContoller {

	@Autowired
	private OfficerService service;

	@Autowired
	private OfficerRepository repo;

	@GetMapping("/register/new")

	public String showRegistrationForm(Model model) {
		AccountOfficer officer = new AccountOfficer();
		model.addAttribute("officer", officer);
		
		service.designationList(model);
		service.stateOfOriginList(model);

			return "officer_form";
	}

	@PostMapping("/register/new")
	public String submitForm(@ModelAttribute("officer") AccountOfficer officer) {
		System.out.println(officer);

		service.registerCustomerUser(officer);

		return "officer_page";
	}

	@GetMapping("/officer/page")
	public String listOfficers(Model model) {
		List<AccountOfficer> listOfficers = repo.findAll();

		model.addAttribute("officer", new AccountOfficer());
		model.addAttribute("listOfficers", listOfficers);

		return "officer_table";
	}
	@GetMapping("/officer/edit/{id}")
	public String showEditCustomerForm(@PathVariable("id") Integer id, Model model) {
		AccountOfficer officer = repo.findById(id).get();

		model.addAttribute("officer", officer);

		service.designationList(model);
		service.stateOfOriginList(model);

		return "Officer_form";
	}
}
