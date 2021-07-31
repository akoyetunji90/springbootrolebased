package com.zeedlabs.productmanager.crud;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.productmanager.crud.entity.Role;
import com.zeedlabs.productmanager.crud.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired
	RoleRepository roleRepo;
	
	@Test
	public void testCreateRoles() {
		Role Engagement = new Role("Engagement");
		Role Admin = new Role("Admin");
		Role ICT = new Role("ICT");
		Role CreditAndRisk = new Role("CreditAndRisk");
		Role Operations = new Role("Operations");
		Role FinCon = new Role("FinCon");

		roleRepo.saveAll(List.of(Engagement, Admin, ICT, CreditAndRisk, Operations, FinCon));
		List<Role> listRoles = roleRepo.findAll();
		assertThat(listRoles.size()).isEqualTo(6);
	}
}
