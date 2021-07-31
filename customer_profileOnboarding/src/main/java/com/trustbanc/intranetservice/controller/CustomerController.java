package com.trustbanc.intranetservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.trustbanc.intranetservice.entity.Customer;
import com.trustbanc.intranetservice.repository.CustomerRepository;
import com.trustbanc.intranetservice.service.CustomerService;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService service;

	@Autowired
	private CustomerRepository repo;

	@GetMapping("/register")

	public String showRegistrationForm(Model model) {
		Customer user = new Customer();
		model.addAttribute("user", user);

		service.designationList(model);
		service.stateOfOriginList(model);
		service.loanTenureList(model);
		service.stateOfResidenceList(model);

		return "customer_form";
	}

	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") Customer user) {
		System.out.println(user);

		service.registerCustomerUser(user);

		return "customer_page";
	}

	@GetMapping("/user")
	public String listCustomers(Model model) {
		List<Customer> listCustomers = repo.findAll();

		model.addAttribute("user", new Customer());
		model.addAttribute("listCustomers", listCustomers);

		return "customer_table";
	}

	@GetMapping("/user/edit/{id}")
	public String showEditCustomerForm(@PathVariable("id") Integer id, Model model) {
		Customer user = repo.findById(id).get();

		model.addAttribute("user", user);

		service.designationList(model);
		service.stateOfOriginList(model);
		service.loanTenureList(model);
		service.stateOfResidenceList(model);

		return "customer_form";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {

		repo.deleteById(id);

		return "redirect:/user";
	}
}