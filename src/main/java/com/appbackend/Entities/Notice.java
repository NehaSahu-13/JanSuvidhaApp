package com.appbackend.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Notice {

	@ManyToOne
	private Department department;
	
	@ManyToOne
	private Office office;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	private String notice_Title;
	
	private String notice_Description;
	
	private String uploaded_FileName;
	
	private Date notice_Date;
	
	private Date notice_Active_Date;
	
	private Date notice_Expiry_Date;
	
	private int notice_Visibility;
	
	@ManyToOne
	private OfficerRegistration officer;

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

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getNotice_Title() {
		return notice_Title;
	}

	public void setNotice_Title(String notice_Title) {
		this.notice_Title = notice_Title;
	}

	public String getNotice_Description() {
		return notice_Description;
	}

	public void setNotice_Description(String notice_Description) {
		this.notice_Description = notice_Description;
	}

	public String getUploaded_FileName() {
		return uploaded_FileName;
	}

	public void setUploaded_FileName(String uploaded_FileName) {
		this.uploaded_FileName = uploaded_FileName;
	}

	public Date getNotice_Date() {
		return notice_Date;
	}

	public void setNotice_Date(Date notice_Date) {
		this.notice_Date = notice_Date;
	}

	public Date getNotice_Active_Date() {
		return notice_Active_Date;
	}

	public void setNotice_Active_Date(Date notice_Active_Date) {
		this.notice_Active_Date = notice_Active_Date;
	}

	public Date getNotice_Expiry_Date() {
		return notice_Expiry_Date;
	}

	public void setNotice_Expiry_Date(Date notice_Expiry_Date) {
		this.notice_Expiry_Date = notice_Expiry_Date;
	}

	public int getNotice_Visibility() {
		return notice_Visibility;
	}

	public void setNotice_Visibility(int notice_Visibility) {
		this.notice_Visibility = notice_Visibility;
	}

	public OfficerRegistration getOfficer() {
		return officer;
	}

	public void setOfficer(OfficerRegistration officer) {
		this.officer = officer;
	}

	@Override
	public String toString() {
		return "Notice [department=" + department + ", office=" + office + ", ID=" + ID + ", notice_Title="
				+ notice_Title + ", notice_Description=" + notice_Description + ", uploaded_FileName="
				+ uploaded_FileName + ", notice_Date=" + notice_Date + ", notice_Active_Date=" + notice_Active_Date
				+ ", notice_Expiry_Date=" + notice_Expiry_Date + ", notice_Visibility=" + notice_Visibility
				+ ", officer=" + officer + "]";
	}

	/**
	 * @param department
	 * @param office
	 * @param iD
	 * @param notice_Title
	 * @param notice_Description
	 * @param uploaded_FileName
	 * @param notice_Date
	 * @param notice_Active_Date
	 * @param notice_Expiry_Date
	 * @param notice_Visibility
	 * @param officer
	 */
	public Notice(Department department, Office office, long iD, String notice_Title, String notice_Description,
			String uploaded_FileName, Date notice_Date, Date notice_Active_Date, Date notice_Expiry_Date,
			int notice_Visibility, OfficerRegistration officer) {
		super();
		this.department = department;
		this.office = office;
		ID = iD;
		this.notice_Title = notice_Title;
		this.notice_Description = notice_Description;
		this.uploaded_FileName = uploaded_FileName;
		this.notice_Date = notice_Date;
		this.notice_Active_Date = notice_Active_Date;
		this.notice_Expiry_Date = notice_Expiry_Date;
		this.notice_Visibility = notice_Visibility;
		this.officer = officer;
	}

	/**
	 * 
	 */
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
	
}
