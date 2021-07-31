package com.zeedlabs.login.controllers;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.login.entity.Role;
import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.repository.UserRepository;
import com.zeedlabs.login.service.UserService;

@Controller
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private UserRepository repo;

	
	@GetMapping("")
	public String showLoginPage() {

		return "login";
	}

	@GetMapping("/index")
	public String showindexPage() {

		return "index";
	}
	
	@GetMapping("/welcome")
	public String viewHomePage() {

		return "welcome";
	}
	
	@GetMapping("/registerUser")
	public String showSignUpForm(Model model) {
		model.addAttribute("user", new User());

		List<Role> listRoles = service.getRoles();
		model.addAttribute("listRoles", listRoles);

		
		return "signup_form";
	}

	@GetMapping("/login")
	public String showLoginForm(Model model) {

		return "login";
	}

	@PostMapping("/process_register")
	public String processRegistration(User user, Model model, HttpServletRequest request)
			throws UnsupportedEncodingException {
		service.registerDefaultUser(user);
		service.registerUser(user);

		return "register_success";
	}

	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = repo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "list_users";
	}

	@GetMapping("/users/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
		User user = service.get(id);
		List<Role> listRoles = service.getRoles();
		model.addAttribute("user", user);
		model.addAttribute("listRoles", listRoles);

		return "edit_user";
	}

	@PostMapping("/users/save")
	public String saveUser(User user) {
		service.save(user);
		return "redirect:/list_users";
	}

}
