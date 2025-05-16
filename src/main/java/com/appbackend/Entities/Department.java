package com.appbackend.Entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long department_ID;
	
	private String department_Name_Eng;
	
	private String department_Name_Hindi;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Office>offices;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<OfficerRegistration>officers;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Notice>notices;
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="department",orphanRemoval=true,fetch = FetchType.EAGER)
	private List<Scheme>schemes;

	public long getDepartment_ID() {
		return department_ID;
	}

	public void setDepartment_ID(long department_ID) {
		this.department_ID = department_ID;
	}

	public String getDepartment_Name_Eng() {
		return department_Name_Eng;
	}

	public void setDepartment_Name_Eng(String department_Name_Eng) {
		this.department_Name_Eng = department_Name_Eng;
	}

	public String getDepartment_Name_Hindi() {
		return department_Name_Hindi;
	}

	public void setDepartment_Name_Hindi(String department_Name_Hindi) {
		this.department_Name_Hindi = department_Name_Hindi;
	}

	public List<Office> getOffices() {
		return offices;
	}

	public void setOffices(List<Office> offices) {
		this.offices = offices;
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

	public List<Scheme> getSchemes() {
		return schemes;
	}

	public void setSchemes(List<Scheme> schemes) {
		this.schemes = schemes;
	}

	@Override
	public String toString() {
		return "Department [department_ID=" + department_ID + ", department_Name_Eng=" + department_Name_Eng
				+ ", department_Name_Hindi=" + department_Name_Hindi + ", offices=" + offices + ", officers=" + officers
				+ ", notices=" + notices + ", schemes=" + schemes + "]";
	}

	/**
	 * @param department_ID
	 * @param department_Name_Eng
	 * @param department_Name_Hindi
	 * @param offices
	 * @param officers
	 * @param notices
	 * @param schemes
	 */
	public Department(long department_ID, String department_Name_Eng, String department_Name_Hindi, List<Office> offices,
			List<OfficerRegistration> officers, List<Notice> notices, List<Scheme> schemes) {
		super();
		this.department_ID = department_ID;
		this.department_Name_Eng = department_Name_Eng;
		this.department_Name_Hindi = department_Name_Hindi;
		this.offices = offices;
		this.officers = officers;
		this.notices = notices;
		this.schemes = schemes;
	}

	/**
	 * 
	 */
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
}
