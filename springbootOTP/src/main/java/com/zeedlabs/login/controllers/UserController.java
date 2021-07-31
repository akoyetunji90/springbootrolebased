package com.zeedlabs.login.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.repository.UserRepository;

@Controller
public class UserController {

	@Autowired
	private UserRepository userrepo;

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

	@PostMapping("/process_register")
	public String processRegistration(User user) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String encodedPassword = encoder.encode(user.getPassword());
		user.setPassword(encodedPassword);

		userrepo.save(user);

		return "register_success";
	}

	@GetMapping("/list_users")
	public String viewUsersList(Model model) {
		List<User> listUsers = userrepo.findAll();
		model.addAttribute("listUsers", listUsers);
		return "list_users";
	}
}
