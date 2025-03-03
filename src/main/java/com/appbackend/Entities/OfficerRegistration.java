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
import jakarta.validation.constraints.Size;

@Entity
public class OfficerRegistration {

	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Office office;
	
	private String officer_Name;
	
	private String officer_Designation;
	
	private String officer_PhoneNumber;
	
	private String email;
	
	@Id
	private long officer_ID;
	
	private String password;
	
	private Date creation_Date;
	
	private String created_By;
	
	
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="officer",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Notice>notices;
	
	
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public String getOfficer_Name() {
		return officer_Name;
	}

	public void setOfficer_Name(String officer_Name) {
		this.officer_Name = officer_Name;
	}

	public String getOfficer_Designation() {
		return officer_Designation;
	}

	public void setOfficer_Designation(String officer_Designation) {
		this.officer_Designation = officer_Designation;
	}

	

	public String getOfficer_PhoneNumber() {
		return officer_PhoneNumber;
	}

	public void setOfficer_PhoneNumber(String officer_PhoneNumber) {
		this.officer_PhoneNumber = officer_PhoneNumber;
	}

	public long getOfficer_ID() {
		return officer_ID;
	}

	public void setOfficer_ID(long officer_ID) {
		this.officer_ID = officer_ID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}

	public String getCreated_By() {
		return created_By;
	}

	public void setCreated_By(String created_By) {
		this.created_By = created_By;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	
	
	
	/**
	 * @param department
	 * @param office
	 * @param officer_Name
	 * @param officer_Designation
	 * @param officer_PhoneNumber
	 * @param email
	 * @param officer_ID
	 * @param password
	 * @param creation_Date
	 * @param created_By
	 * @param notices
	 */
	public OfficerRegistration(Department department, Office office, String officer_Name, String officer_Designation,
			String officer_PhoneNumber, String email, long officer_ID, String password, Date creation_Date,
			String created_By, List<Notice> notices) {
		super();
		this.department = department;
		this.office = office;
		this.officer_Name = officer_Name;
		this.officer_Designation = officer_Designation;
		this.officer_PhoneNumber = officer_PhoneNumber;
		this.email = email;
		this.officer_ID = officer_ID;
		this.password = password;
		this.creation_Date = creation_Date;
		this.created_By = created_By;
		this.notices = notices;
	}

	@Override
	public String toString() {
		return "OfficerRegistration [department=" + department + ", office=" + office + ", officer_Name=" + officer_Name
				+ ", officer_Designation=" + officer_Designation + ", officer_PhoneNumber=" + officer_PhoneNumber
				+ ", email=" + email + ", officer_ID=" + officer_ID + ", password=" + password + ", creation_Date="
				+ creation_Date + ", created_By=" + created_By + ", notices=" + notices + "]";
	}

	public OfficerRegistration() {
		super();
		// TODO Auto-generated constructor stub
	}

   
	
	
	
	
	
	
	
}
