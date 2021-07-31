package com.zeedlabs.login.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zeedlabs.login.entity.AccountOfficer;
import com.zeedlabs.login.repository.OfficerRepository;

@Service
public class OfficerService {

	@Autowired
	private OfficerRepository repo;

	public void registerCustomerUser(AccountOfficer officer) {

		repo.save(officer);
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
}
