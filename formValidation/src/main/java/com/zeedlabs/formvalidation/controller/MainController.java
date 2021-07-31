package com.zeedlabs.formvalidation.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.formvalidation.model.Customer;

@Controller
public class MainController {
	
	@GetMapping("/register")
	
	public String showRegistrationForm(Model model) {
		Customer user = new Customer();
		model.addAttribute("user", user);
		
		List<String> professionList = Arrays.asList("Developer", "Designer", "Architech");
		model.addAttribute("professionList", professionList);
				
		return "register_form";
	}
	@PostMapping("/register")
	public String submitForm(@ModelAttribute("user") Customer user) {
		System.out.println(user);
		return "register_success";
	}
	

}
