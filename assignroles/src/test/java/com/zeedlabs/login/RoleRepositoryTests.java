package com.zeedlabs.login;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.login.entity.Role;
import com.zeedlabs.login.repository.RoleRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {
	
	@Autowired
	RoleRepository roleRepo;
	
	@Test
	public void testCreateRoles() {
		Role User = new Role("User");
		Role Admin = new Role("Admin");
		Role Creator = new Role("Customer");
		Role Operator = new Role("Operator");

		roleRepo.saveAll(List.of(User, Admin, Creator,Operator));
		List<Role> listRoles = roleRepo.findAll();
		assertThat(listRoles.size()).isEqualTo(3);
	}
}
