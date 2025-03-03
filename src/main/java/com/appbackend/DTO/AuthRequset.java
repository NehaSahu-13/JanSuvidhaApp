package com.appbackend.DTO;

public class AuthRequset {

    private long id;
	
    private String password;

	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "AuthRequset [id=" + id + ", password=" + password + "]";
	}
	/**
	 * @param id
	 * @param password
	 */
	public AuthRequset(long id, String password) {
		super();
		this.id = id;
		this.password = password;
	}
	/**
	 * 
	 */
	public AuthRequset() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	
}
