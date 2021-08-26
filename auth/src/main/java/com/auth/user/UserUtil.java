package com.auth.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class UserUtil {
	public static void main(String a[]) {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String pwd = bcryptPasswordEncoder.encode("adminpass");
		// System.out.println(pwd);

		User user = new User(2, "admin", pwd, "ADMIN");
		user.getAuthorities();
		System.out.println(user);
		 
	}

	@Bean CommandLineRunner cmdRunner(UserRepository userRepo) {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String pwd = bcryptPasswordEncoder.encode("adminpass");
		String johnpwd = bcryptPasswordEncoder.encode("password");
		return args -> {
			User user = new User(2, "admin", pwd, "ADMIN");
			user.getAuthorities();
			User john = new User(1, "john", johnpwd, "USER");
			john.getAuthorities();

			userRepo.save(user);
			userRepo.save(john);
		};
	}
}
