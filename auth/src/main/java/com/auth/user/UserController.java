package com.auth.user;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

	private final UserDetailsService userDetailsService;

	@Autowired
	public UserController(UserDetailsService userDetailsService) {
		this.userDetailsService = userDetailsService;
	}

	@GetMapping(value = "getUserAuthorities")
	public Collection<? extends GrantedAuthority> getUserAuths() {
		User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		return userDetailsService.getUserAuths(user.getUsername());
	}

	@GetMapping(value = "getUsers")
	public List<String> getAllUsernames() {
		List<String> usernames = userDetailsService.getAllUsers();
		return usernames;
	}
	
}
