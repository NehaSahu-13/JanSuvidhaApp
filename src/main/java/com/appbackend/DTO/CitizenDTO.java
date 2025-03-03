package com.appbackend.DTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CitizenDTO {
	
	private long id;

    private String user_Name;
	
	private String Gender;

	private String Address;
	
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	private String phone_Number;
	
    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Invalid Email Address!!" )
	private String email;
	
	@Size(min=8,max=20,message="Password must contain 8-20 characters only")
	private String password;
	
	private int district_ID;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUser_Name() {
		return user_Name;
	}

	public void setUser_Name(String user_Name) {
		this.user_Name = user_Name;
	}

	public String getGender() {
		return Gender;
	}

	public void setGender(String gender) {
		Gender = gender;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public String getPhone_Number() {
		return phone_Number;
	}

	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getDistrict_ID() {
		return district_ID;
	}

	public void setDistrict_ID(int district_ID) {
		this.district_ID = district_ID;
	}

	@Override
	public String toString() {
		return "CitizenDTO [id=" + id + ", user_Name=" + user_Name + ", Gender=" + Gender + ", Address=" + Address
				+ ", phone_Number=" + phone_Number + ", email=" + email + ", password=" + password + ", district_ID="
				+ district_ID + "]";
	}

	/**
	 * @param id
	 * @param user_Name
	 * @param gender
	 * @param address
	 * @param phone_Number
	 * @param email
	 * @param password
	 * @param district_ID
	 */
	public CitizenDTO(long id, String user_Name, String gender, String address, String phone_Number,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email Address!!") String email,
			@Size(min = 8, max = 20, message = "Password must contain 8-20 characters only") String password,
			int district_ID) {
		super();
		this.id = id;
		this.user_Name = user_Name;
		Gender = gender;
		Address = address;
		this.phone_Number = phone_Number;
		this.email = email;
		this.password = password;
		this.district_ID = district_ID;
	}

	/**
	 * 
	 */
	public CitizenDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	
	
	
	
}
