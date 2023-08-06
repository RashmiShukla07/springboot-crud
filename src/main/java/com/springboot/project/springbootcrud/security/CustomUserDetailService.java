package com.springboot.project.springbootcrud.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;


//FOR STORING AUTHENTICATION DETAILS IN DATABASE 
public class CustomUserDetailService implements UserDetailsService {
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		return null;
	}
}
