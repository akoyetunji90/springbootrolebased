package com.zeedlabs.inventoryapp;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.inventoryapp.repository.UserRepository;
import com.zeedlabs.inventoryapp.user.Role;
import com.zeedlabs.inventoryapp.user.User;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {

	@Autowired
	private UserRepository repo;

	@Autowired
	private TestEntityManager entityManager;

	@Test
	public void testCreateRoles() {
		Role roleAdmin = new Role("Administrator");
		Role roleEditor = new Role("Editor");
		Role roleVisitor = new Role("Visitor");

		entityManager.persist(roleAdmin);
		entityManager.persist(roleEditor);
		entityManager.persist(roleVisitor);

	}

	@Test
	public void testCreateNewUserWithOneRole() {
		Role roleAdmin = entityManager.find(Role.class, 1);
		User user = new User("akoyetunji@gmail.com", "Pass123$$");
		user.addRole(roleAdmin);

		repo.save(user);
	}

	@Test
	public void testCreateNewUserWithTwoRoles() {
		Role roleEditor = entityManager.find(Role.class, 2);
		Role roleVisitor = entityManager.find(Role.class, 3);

		User user = new User("alaoabibat28@gmail.com", "Pass123$$");

		user.addRole(roleEditor);
		user.addRole(roleVisitor);

		repo.save(user);
	}

	@Test
	public void testAssignRoleToExistingUser() {
		User user = repo.findById(2).get();
		Role roleEditor = entityManager.find(Role.class, 2);
		user.addRole(roleEditor);
	}

	@Test
	public void testRemoveRoleFromExistingUser() {
		User user = repo.findById(1).get();
		Role role = new Role(3);
		user.removeRole(role);

	}
	@Test
	public void createNewUserWithNewRole() {
		Role roleSalesperson = new Role("Salesperson");
		User user = new User("adetunji@zeedlabs.com", "Pass123$$");
		user.addRole(roleSalesperson);
		
		repo.save(user);

	}
	@Test
	public void testGetUser() {
		User user = repo.findById(2).get();
		entityManager.detach(user);
		
		System.out.println(user.getEmail());
		
		System.out.println(user.getRoles());

	}
	@Test
	public void testRemoveUser() {
		repo.deleteById(17);
	}
}
