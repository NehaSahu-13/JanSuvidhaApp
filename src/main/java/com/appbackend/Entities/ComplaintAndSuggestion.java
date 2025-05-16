package com.appbackend.Entities;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;



@Entity
public class ComplaintAndSuggestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	private int type;
	
	@ManyToOne
	private CitizenRegistration citizen;
	
	private String application_Type;
	
	private String details;
	
	private String uploaded_FileName;
	
	private Date lodge_Date;
	
	@ManyToOne
	private Office office;
	
	private long disposal_ID;
	
	private Timestamp disposal_DateAndTime;
	
	private String uploaded_FileName_ByOffice;
	
	private String status;
	
	private String solution;
	
	
	
	

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public CitizenRegistration getCitizen() {
		return citizen;
	}

	public void setCitizen(CitizenRegistration citizen) {
		this.citizen = citizen;
	}

	public String getApplication_Type() {
		return application_Type;
	}

	public void setApplication_Type(String application_Type) {
		this.application_Type = application_Type;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getUploaded_FileName() {
		return uploaded_FileName;
	}

	public void setUploaded_FileName(String uploaded_FileName) {
		this.uploaded_FileName = uploaded_FileName;
	}

	public Date getLodge_Date() {
		return lodge_Date;
	}

	public void setLodge_Date(Date lodge_Date) {
		this.lodge_Date = lodge_Date;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public long getDisposal_ID() {
		return disposal_ID;
	}

	public void setDisposal_ID(long disposal_ID) {
		this.disposal_ID = disposal_ID;
	}

	public Timestamp getDisposal_DateAndTime() {
		return disposal_DateAndTime;
	}

	public void setDisposal_DateAndTime(Timestamp disposal_DateAndTime) {
		this.disposal_DateAndTime = disposal_DateAndTime;
	}

	public String getUploaded_FileName_ByOffice() {
		return uploaded_FileName_ByOffice;
	}

	public void setUploaded_FileName_ByOffice(String uploaded_FileName_ByOffice) {
		this.uploaded_FileName_ByOffice = uploaded_FileName_ByOffice;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	@Override
	public String toString() {
		return "ComplaintAndSuggestion [ID=" + ID + ", type=" + type + ", citizen=" + citizen + ", application_Type="
				+ application_Type + ", details=" + details + ", uploaded_FileName=" + uploaded_FileName
				+ ", lodge_Date=" + lodge_Date + ", office=" + office + ", disposal_ID=" + disposal_ID
				+ ", disposal_DateAndTime=" + disposal_DateAndTime + ", uploaded_FileName_ByOffice="
				+ uploaded_FileName_ByOffice + ", status=" + status + ", solution=" + solution + "]";
	}

	/**
	 * @param iD
	 * @param type
	 * @param citizen
	 * @param application_Type
	 * @param details
	 * @param uploaded_FileName
	 * @param lodge_Date
	 * @param office
	 * @param disposal_ID
	 * @param disposal_DateAndTime
	 * @param uploaded_FileName_ByOffice
	 * @param status
	 * @param solution
	 */
	public ComplaintAndSuggestion(long iD, int type, CitizenRegistration citizen, String application_Type,
			String details, String uploaded_FileName, Date lodge_Date, Office office, long disposal_ID,
			Timestamp disposal_DateAndTime, String uploaded_FileName_ByOffice, String status, String solution) {
		super();
		ID = iD;
		this.type = type;
		this.citizen = citizen;
		this.application_Type = application_Type;
		this.details = details;
		this.uploaded_FileName = uploaded_FileName;
		this.lodge_Date = lodge_Date;
		this.office = office;
		this.disposal_ID = disposal_ID;
		this.disposal_DateAndTime = disposal_DateAndTime;
		this.uploaded_FileName_ByOffice = uploaded_FileName_ByOffice;
		this.status = status;
		this.solution = solution;
	}

	public ComplaintAndSuggestion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
}
