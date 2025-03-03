package com.appbackend.Entities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

public class Admin {
	
	@Autowired
	private PasswordEncoder  bCryptPasswordEncoder;

	private String username="neha123@gmail.com";
	private String password=bCryptPasswordEncoder.encode("neha@1234");
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + "]";
	}
	/**
	 * @param username
	 * @param password
	 */
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	/**
	 * 
	 */
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
