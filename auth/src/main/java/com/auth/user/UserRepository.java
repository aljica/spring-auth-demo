package com.auth.user;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	public User findByUsername(String username);

	@Query(value = "SELECT * FROM users_table", nativeQuery = true)
	public Optional<List<User>> getAllUsers();
}
