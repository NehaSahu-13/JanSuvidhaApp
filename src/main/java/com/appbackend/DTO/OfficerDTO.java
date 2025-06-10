package com.appbackend.DTO;

import java.util.Date;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OfficerDTO {

	private long department_ID;
	
	private long office_ID;
	
	private String officer_Name;
	
	private String officer_Designation;
	
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	private String officer_PhoneNumber;
	
	private long officer_ID;
	
   @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Invalid Email Address!!" )
	private String email;
	
	@Size(min=8,max=20,message="Password must contain 8-20 characters only")
	private String password;
	
	private String created_By;
	
	private Date creation_Date;



	

	public OfficerDTO(long department_ID, long office_ID, String officer_Name, String officer_Designation,
			@Size(min = 10, max = 10, message = "Phone number must be 10 digits") String officer_PhoneNumber,
			long officer_ID,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email Address!!") String email,
			@Size(min = 8, max = 20, message = "Password must contain 8-20 characters only") String password,
			String created_By, Date creation_Date) {
		super();
		this.department_ID = department_ID;
		this.office_ID = office_ID;
		this.officer_Name = officer_Name;
		this.officer_Designation = officer_Designation;
		this.officer_PhoneNumber = officer_PhoneNumber;
		this.officer_ID = officer_ID;
		this.email = email;
		this.password = password;
		this.created_By = created_By;
		this.creation_Date = creation_Date;
	}

	public Date getCreation_Date() {
		return creation_Date;
	}

	public void setCreation_Date(Date creation_Date) {
		this.creation_Date = creation_Date;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getDepartment_ID() {
		return department_ID;
	}

	public void setDepartment_ID(long department_ID) {
		this.department_ID = department_ID;
	}

	public long getOffice_ID() {
		return office_ID;
	}

	public void setOffice_ID(long office_ID) {
		this.office_ID = office_ID;
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

	public String getCreated_By() {
		return created_By;
	}

	public void setCreated_By(String created_By) {
		this.created_By = created_By;
	}


	
	
	
	/**
	 * @param department_ID
	 * @param office_ID
	 * @param officer_Name
	 * @param officer_Designation
	 * @param officer_PhoneNumber
	 * @param officer_ID
	 * @param email
	 * @param password
	 * @param created_By
	 */
	
	@Override
	public String toString() {
		return "OfficerDTO [department_ID=" + department_ID + ", office_ID=" + office_ID + ", officer_Name="
				+ officer_Name + ", officer_Designation=" + officer_Designation + ", officer_PhoneNumber="
				+ officer_PhoneNumber + ", officer_ID=" + officer_ID + ", email=" + email + ", password=" + password
				+ ", created_By=" + created_By + ", creation_Date=" + creation_Date + "]";
	}

	public OfficerDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
