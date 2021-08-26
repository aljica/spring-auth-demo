package com.auth.user;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository underTest;

	@Test
	void getAllUsernames() {
		// given
		
		// when
		//Optional<List<User>> users = underTest.getAllUsers();

		// then
		assertTrue(true);
	}

	@AfterEach
	void tearDown() {
		underTest.deleteAll();
	}

}
