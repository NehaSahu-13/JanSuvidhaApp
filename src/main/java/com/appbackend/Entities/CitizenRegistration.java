package com.appbackend.Entities;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;


@Entity
public class CitizenRegistration {

	private String user_Name;
	
	private String Gender;

	private String Address;
	 
    private String phone_Number;
	
	private String email;
	
	@Id
	private long user_ID;
	
	private String password;
	
	private Date registrationDate;
	
	@ManyToOne
	private District district;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="citizen",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<ActivityLog>activities;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="citizen",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<ErrorLog>errors;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="citizen",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<ComplaintAndSuggestion>complaintAndSuggestions;
	

	
	
	
	public void setPhone_Number(String phone_Number) {
		this.phone_Number = phone_Number;
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


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getUser_ID() {
		return user_ID;
	}

	public void setUser_ID(long user_ID) {
		this.user_ID = user_ID;
	}

	public District getDistrict() {
		return district;
	}

	public void setDistrict(District district) {
		this.district = district;
	}

	public List<ActivityLog> getActivities() {
		return activities;
	}

	public void setActivities(List<ActivityLog> activities) {
		this.activities = activities;
	}

	public List<ErrorLog> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorLog> errors) {
		this.errors = errors;
	}

	public List<ComplaintAndSuggestion> getComplaintAndSuggestions() {
		return complaintAndSuggestions;
	}

	public void setComplaintAndSuggestions(List<ComplaintAndSuggestion> complaintAndSuggestions) {
		this.complaintAndSuggestions = complaintAndSuggestions;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	

	public String getPhone_Number() {
		return phone_Number;
	}

	@Override
	public String toString() {
		return "CitizenRegistration [user_Name=" + user_Name + ", Gender=" + Gender + ", Address=" + Address
				+ ", phone_Number=" + phone_Number + ", email=" + email + ", user_ID=" + user_ID + ", district="
				+ district + ", activities=" + activities + ", errors=" + errors + ", complaintAndSuggestions="
				+ complaintAndSuggestions + ", password=" + password + ", registrationDate=" + registrationDate + "]";
	}

	/**
	 * @param user_Name
	 * @param gender
	 * @param address
	 * @param phone_Number
	 * @param email
	 * @param user_ID
	 * @param district
	 * @param activities
	 * @param errors
	 * @param complaintAndSuggestions
	 * @param password
	 * @param registrationDate
	 */
	public CitizenRegistration(String user_Name, String gender, String address, String phone_Number,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email Address!!") String email,
			long user_ID, District district, List<ActivityLog> activities, List<ErrorLog> errors,
			List<ComplaintAndSuggestion> complaintAndSuggestions,
			@Size(min = 8, max = 20, message = "Password must contain 8-20 characters only") String password,
			Date registrationDate) {
		super();
		this.user_Name = user_Name;
		Gender = gender;
		Address = address;
		this.phone_Number = phone_Number;
		this.email = email;
		this.user_ID = user_ID;
		this.district = district;
		this.activities = activities;
		this.errors = errors;
		this.complaintAndSuggestions = complaintAndSuggestions;
		this.password = password;
		this.registrationDate = registrationDate;
	}

	/**
	 * 
	 */
	public CitizenRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
}
