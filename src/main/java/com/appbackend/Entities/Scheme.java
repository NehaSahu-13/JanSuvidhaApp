package com.appbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Scheme {

	@ManyToOne
	private Department department;
	
	private int scheme_Sponsor;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long scheme_ID;
	
	private String scheme_Title;
	
	private String scheme_Description;
	
	private String scheme_Eligiblity;
	
	private String to_Contact;
	
	private String uploaded_FileName;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public int getScheme_Sponsor() {
		return scheme_Sponsor;
	}

	public void setScheme_Sponsor(int scheme_Sponsor) {
		this.scheme_Sponsor = scheme_Sponsor;
	}

	public long getScheme_ID() {
		return scheme_ID;
	}

	public void setScheme_ID(long scheme_ID) {
		this.scheme_ID = scheme_ID;
	}

	public String getScheme_Title() {
		return scheme_Title;
	}

	public void setScheme_Title(String scheme_Title) {
		this.scheme_Title = scheme_Title;
	}

	public String getScheme_Description() {
		return scheme_Description;
	}

	public void setScheme_Description(String scheme_Description) {
		this.scheme_Description = scheme_Description;
	}

	public String getScheme_Eligiblity() {
		return scheme_Eligiblity;
	}

	public void setScheme_Eligiblity(String scheme_Eligiblity) {
		this.scheme_Eligiblity = scheme_Eligiblity;
	}

	public String getTo_Contact() {
		return to_Contact;
	}

	public void setTo_Contact(String to_Contact) {
		this.to_Contact = to_Contact;
	}

	public String getUploaded_FileName() {
		return uploaded_FileName;
	}

	public void setUploaded_FileName(String uploaded_FileName) {
		this.uploaded_FileName = uploaded_FileName;
	}

	@Override
	public String toString() {
		return "Scheme [department=" + department + ", scheme_Sponsor=" + scheme_Sponsor + ", scheme_ID=" + scheme_ID
				+ ", scheme_Title=" + scheme_Title + ", scheme_Description=" + scheme_Description
				+ ", scheme_Eligiblity=" + scheme_Eligiblity + ", to_Contact=" + to_Contact + ", uploaded_FileName="
				+ uploaded_FileName + "]";
	}

	/**
	 * @param department
	 * @param scheme_Sponsor
	 * @param scheme_ID
	 * @param scheme_Title
	 * @param scheme_Description
	 * @param scheme_Eligiblity
	 * @param to_Contact
	 * @param uploaded_FileName
	 */
	public Scheme(Department department, int scheme_Sponsor, long scheme_ID, String scheme_Title,
			String scheme_Description, String scheme_Eligiblity, String to_Contact, String uploaded_FileName) {
		super();
		this.department = department;
		this.scheme_Sponsor = scheme_Sponsor;
		this.scheme_ID = scheme_ID;
		this.scheme_Title = scheme_Title;
		this.scheme_Description = scheme_Description;
		this.scheme_Eligiblity = scheme_Eligiblity;
		this.to_Contact = to_Contact;
		this.uploaded_FileName = uploaded_FileName;
	}

	/**
	 * 
	 */
	public Scheme() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
}
