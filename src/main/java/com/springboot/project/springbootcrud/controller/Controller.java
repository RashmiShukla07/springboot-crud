package com.springboot.project.springbootcrud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller{
	
	@RequestMapping("/")  //should be accessible by everyone whether or not they have logged-in.
	public String homePage() {
		return "Welcome to Employee CRUD Application";
	}
	
	@RequestMapping("/user") //should be accessible only after login by both the users and admin
	public String user(){
		return "Welcome User";
	}
	
	@RequestMapping("/admin") //should be accessible by admin only after login
	public String admin() {
		return "<h1>Welcome Admin</h1>";
	}
}
