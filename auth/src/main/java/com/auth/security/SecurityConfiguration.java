package com.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Bean(name = "pwdEncoder")
	public PasswordEncoder getPasswordEncoder() {
		DelegatingPasswordEncoder delPasswordEnc = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
		BCryptPasswordEncoder bCryptPwdEncoder = new BCryptPasswordEncoder();
		delPasswordEnc.setDefaultPasswordEncoderForMatches(bCryptPwdEncoder);
		return delPasswordEnc;
	}

}
