package com.appbackend.Entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ErrorLog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long ID;
	
	private String page_Name;
	
	private String error;
	

	@Column(columnDefinition = "TEXT")
	private String errorDetail;
	
	@ManyToOne
	private CitizenRegistration citizen;
	
	private Timestamp dateandTime;

	

	public String getErrorDetail() {
		return errorDetail;
	}

	public void setErrorDetail(String errorDetail) {
		this.errorDetail = errorDetail;
	}

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public String getPage_Name() {
		return page_Name;
	}

	public void setPage_Name(String page_Name) {
		this.page_Name = page_Name;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	

	

	public CitizenRegistration getCitizen() {
		return citizen;
	}

	public void setCitizen(CitizenRegistration citizen) {
		this.citizen = citizen;
	}

	public Timestamp getDateandTime() {
		return dateandTime;
	}

	public void setDateandTime(Timestamp dateandTime) {
		this.dateandTime = dateandTime;
	}

	@Override
	public String toString() {
		return "ErrorLog [ID=" + ID + ", page_Name=" + page_Name + ", error=" + error + ", citizen=" + citizen + ", dateandTime=" + dateandTime + "]";
	}

	/**
	 * @param iD
	 * @param page_Name
	 * @param error
	 * @param error_Description
	 * @param citizen
	 * @param dateandTime
	 */
	public ErrorLog(long iD, String page_Name, String error, CitizenRegistration citizen,
			Timestamp dateandTime) {
		super();
		ID = iD;
		this.page_Name = page_Name;
		this.error = error;
		this.citizen = citizen;
		this.dateandTime = dateandTime;
	}

	/**
	 * 
	 */
	public ErrorLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
}
