package com.zeedlabs.login.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository repo;

	@GetMapping("")
	public String viewHomePage() {

		return "index";
	}

	@GetMapping("/register")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());

		return "signup_form";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {

		return "login";
	}

	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "list_users";
	}

		}
