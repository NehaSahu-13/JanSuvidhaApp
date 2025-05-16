package com.appbackend.Entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Office {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long office_ID;
		
	private String office_Type;
	
	private String Office_Name_Eng;
	
	private String Office_Name_Hindi;
	
	private String office_Address;
	
    private String office_Phone;
	
	private String office_Email;
	
	@ManyToOne
	private Department department;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="office",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<OfficerRegistration>officers;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="office",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Notice>notices;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="office",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<ComplaintAndSuggestion>complaintAndSuggestions;

	public long getOffice_ID() {
		return office_ID;
	}

	public void setOffice_ID(long office_ID) {
		this.office_ID = office_ID;
	}

	public String getOffice_Type() {
		return office_Type;
	}

	public void setOffice_Type(String office_Type) {
		this.office_Type = office_Type;
	}

	public String getOffice_Name_Eng() {
		return Office_Name_Eng;
	}

	public void setOffice_Name_Eng(String office_Name_Eng) {
		Office_Name_Eng = office_Name_Eng;
	}

	public String getOffice_Name_Hindi() {
		return Office_Name_Hindi;
	}

	public void setOffice_Name_Hindi(String office_Name_Hindi) {
		Office_Name_Hindi = office_Name_Hindi;
	}

	public String getOffice_Address() {
		return office_Address;
	}

	public void setOffice_Address(String office_Address) {
		this.office_Address = office_Address;
	}

	
	public String getOffice_Phone() {
		return office_Phone;
	}

	public void setOffice_Phone(String office_Phone) {
		this.office_Phone = office_Phone;
	}

	public String getOffice_Email() {
		return office_Email;
	}

	public void setOffice_Email(String office_Email) {
		this.office_Email = office_Email;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public List<OfficerRegistration> getOfficers() {
		return officers;
	}

	public void setOfficers(List<OfficerRegistration> officers) {
		this.officers = officers;
	}

	public List<Notice> getNotices() {
		return notices;
	}

	public void setNotices(List<Notice> notices) {
		this.notices = notices;
	}

	public List<ComplaintAndSuggestion> getComplaintAndSuggestions() {
		return complaintAndSuggestions;
	}

	public void setComplaintAndSuggestions(List<ComplaintAndSuggestion> complaintAndSuggestions) {
		this.complaintAndSuggestions = complaintAndSuggestions;
	}

	@Override
	public String toString() {
		return "Office [office_ID=" + office_ID + ", office_Type=" + office_Type + ", Office_Name_Eng="
				+ Office_Name_Eng + ", Office_Name_Hindi=" + Office_Name_Hindi + ", office_Address=" + office_Address
				+ ", office_Phone=" + office_Phone + ", office_Email=" + office_Email + ", department=" + department
				+ ", officers=" + officers + ", notices=" + notices + ", complaintAndSuggestions="
				+ complaintAndSuggestions + "]";
	}

	/**
	 * @param office_ID
	 * @param office_Type
	 * @param office_Name_Eng
	 * @param office_Name_Hindi
	 * @param office_Address
	 * @param office_Phone
	 * @param office_Email
	 * @param department
	 * @param officers
	 * @param notices
	 * @param complaintAndSuggestions
	 */
	public Office(long office_ID, String office_Type, String office_Name_Eng, String office_Name_Hindi,
			String office_Address, String office_Phone,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email Address!!") String office_Email,
			Department department, List<OfficerRegistration> officers, List<Notice> notices,
			List<ComplaintAndSuggestion> complaintAndSuggestions) {
		super();
		this.office_ID = office_ID;
		this.office_Type = office_Type;
		Office_Name_Eng = office_Name_Eng;
		Office_Name_Hindi = office_Name_Hindi;
		this.office_Address = office_Address;
		this.office_Phone = office_Phone;
		this.office_Email = office_Email;
		this.department = department;
		this.officers = officers;
		this.notices = notices;
		this.complaintAndSuggestions = complaintAndSuggestions;
	}

	/**
	 * 
	 */
	public Office() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
