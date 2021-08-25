package com.auth.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
/*import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;*/

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
			.antMatchers("/api/**").hasRole("ADMIN")
			//.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginProcessingUrl("/login")
			.defaultSuccessUrl("/")
			.failureUrl("/login?error=true");
		//	.and()
		//.cors()
	}
	
	@Bean(name = "pwdEncoder")
	public PasswordEncoder getPasswordEncoder() {
		DelegatingPasswordEncoder delPasswordEnc = (DelegatingPasswordEncoder) PasswordEncoderFactories.createDelegatingPasswordEncoder();
		BCryptPasswordEncoder bCryptPwdEncoder = new BCryptPasswordEncoder();
		delPasswordEnc.setDefaultPasswordEncoderForMatches(bCryptPwdEncoder);
		return delPasswordEnc;
	}

	/*@Bean
    CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }*/

}
