package com.zeedlabs.login.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zeedlabs.login.entity.Customer;
import com.zeedlabs.login.repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository repo;

	public void registerCustomerUser(Customer user) {

		repo.save(user);
	}

	public void designationList(Model model) {

		List<String> designationList = Arrays.asList("Air-Force", "Army", "Civil-Servant", "Navy", "Police", "Soldier",
				"Private-Sector", "Entreprenuer");
		model.addAttribute("designationList", designationList);

	}

	public void stateOfOriginList(Model model) {

		List<String> stateOfOriginList = Arrays.asList("Abia", "Adamawa", "Akwaibom", "Anambra", "Bauchi", "Bayelsa",
				"Benue", "Borno", "Cross River", "Delta", "Edo", "Ekiti", "Enugu", "F.C.T", "Gombe", "Imo", "Jigawa",
				"Kaduna", "Kano", "Kastina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger", "Ogun", "Ondo",
				"Osun", "Oyo", "Pleateu", "River", "Sokoto", "Taraba", "Yobe", "Zamfara");
		model.addAttribute("stateOfOriginList", stateOfOriginList);

	}

	public void stateOfResidenceList(Model model) {

		List<String> stateOfResidenceList = Arrays.asList("Abia", "Adamawa", "Akwaibom", "Anambra", "Bauchi", "Bayelsa",
				"Benue", "Borno", "Cross River", "Delta", "Edo", "Ekiti", "Enugu", "F.C.T", "Gombe", "Imo", "Jigawa",
				"Kaduna", "Kano", "Kastina", "Kebbi", "Kogi", "Kwara", "Lagos", "Nasarawa", "Niger", "Ogun", "Ondo",
				"Osun", "Oyo", "Pleateu", "River", "Sokoto", "Taraba", "Yobe", "Zamfara");
		model.addAttribute("stateOfResidenceList", stateOfResidenceList);

	}

	public void loanTenureList(Model model) {

		List<String> loanTenureList = Arrays.asList("3 Months", "6 Months", "9 Months", "12 Months", "15 Months",
				"18 Months", "24 Months");
		model.addAttribute("loanTenureList", loanTenureList);

	}
}
