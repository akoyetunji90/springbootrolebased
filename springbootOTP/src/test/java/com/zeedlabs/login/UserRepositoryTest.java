package com.zeedlabs.login;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.repository.UserRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@Rollback(false)
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository repo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Test
	public void testCreateUser() {
		User user = new User();
		user.setEmail("adekunle1234@zeedlabs.com");
		user.setPassword("Pass_word1234$$");
		user.setFirstName("Abdullah");
		user.setLastName("Oyetunji");
		
		User savedUser = repo.save(user);
		User existUser=entityManager.find(User.class, savedUser.getId());
		
		assertThat(existUser.getEmail()).isEqualTo(user.getEmail());
		
	}
	
	@Test
	public void testFindUserByEmail(){
		
		String Email = "akoyetunji@gmail.com";
		
		User user=repo.findByEmail(Email);
		assertThat(user).isNotNull();
	}

}
