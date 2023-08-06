package com.springboot.project.springbootcrud.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfiguration {
	
	//Authentication- InMemory
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails user = User
				.withUsername("user")
				.password(passwordEncoder().encode("pass"))
				.roles("USER")
				.build();
		
		UserDetails admin = User
				.withUsername("admin")
				.password(passwordEncoder().encode("password"))
				.roles("ADMIN")
				.build();
		
		return  new InMemoryUserDetailsManager(user, admin);
		
		
		//If using db : return CustomUserDetailsService();
		
	}
	
	//Password Encryption
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	//Authorization
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/admin")
				.hasRole("ADMIN")
				.requestMatchers("/user")
				.hasRole("USER")
				.requestMatchers("/")
				.permitAll()
				.anyRequest()
				.authenticated()
				.and()
				.formLogin();
		return httpSecurity.build();
	}
}
