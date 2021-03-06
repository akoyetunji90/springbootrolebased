package com.zeedlabs.productmanager.crud;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.productmanager.crud.entity.Role;
import com.zeedlabs.productmanager.crud.entity.User;
import com.zeedlabs.productmanager.crud.repository.RoleRepository;
import com.zeedlabs.productmanager.crud.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	private RoleRepository roleRepo;

	@Test
	public void testAddRoleToNewUser() {
		Role roleUser = roleRepo.findByName("ICT");

		User user = new User();
		user.setEmail("adekunle@zeedlabs.com");
		user.setPassword("Pass123$$");
		user.setFirstName("Adekunle");
		user.setLastName("Oyetunji");
		user.addRole(roleUser);

		User savedUser = userRepo.save(user);

		assertThat(savedUser.getRoles().size()).isEqualTo(1);
	}

	@Test
	public void testAddRoleToExistingUser() {
		User user = userRepo.findById(1L).get();
		Role roleUser = roleRepo.findByName("User");
		Role roleAdmin = new Role(2L);

		user.addRole(roleUser);
		user.addRole(roleAdmin);

		User savedUser = userRepo.save(user);

		assertThat(savedUser.getRoles().size()).isEqualTo(2);
	}
}
