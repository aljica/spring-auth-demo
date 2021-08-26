package com.auth.user;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
 
    private final UserRepository userRepository;

	@Autowired
	public UserDetailsService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return user;
	}

	public Collection<? extends GrantedAuthority> getUserAuths(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException(username);
		}

		return user.getAuthorities();
	}

	public void createUser(Integer id, String username, String password, String role) {
		User user = new User(id, username, password, role);
		user.getAuthorities();
		userRepository.save(user);
	}

	public List<String> getAllUsers() {
		// Returns usernames
		List<User> users = userRepository.findAll();
		List<String> usernames = new ArrayList<String>();
		for (User user : users) {
			usernames.add(user.getUsername());
		}
		return usernames;
	}

}