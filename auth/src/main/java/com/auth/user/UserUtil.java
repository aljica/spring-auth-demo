package com.auth.user;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class UserUtil {
	public static void main(String a[]) {
		BCryptPasswordEncoder bcryptPasswordEncoder = new BCryptPasswordEncoder();
		String pwd = bcryptPasswordEncoder.encode("password");
		System.out.println(pwd);
		 
	}
}
