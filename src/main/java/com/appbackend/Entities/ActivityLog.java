package com.appbackend.Entities;

import java.sql.Timestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ActivityLog {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long ID;
	
	@ManyToOne
	private CitizenRegistration citizen;
	
	private String pageName;
	
	private String activity;
	
	private Timestamp dateAndTime;
	
	private String data;

	public long getID() {
		return ID;
	}

	public void setID(long iD) {
		ID = iD;
	}

	public CitizenRegistration getCitizen() {
		return citizen;
	}

	public void setCitizen(CitizenRegistration citizen) {
		this.citizen = citizen;
	}

	public String getPageName() {
		return pageName;
	}

	public void setPageName(String pageName) {
		this.pageName = pageName;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public Timestamp getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Timestamp dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "ActivityLog [ID=" + ID + ", citizen=" + citizen + ", pageName=" + pageName + ", activity=" + activity
				+ ", dateAndTime=" + dateAndTime + ", data=" + data + "]";
	}

	/**
	 * @param iD
	 * @param citizen
	 * @param pageName
	 * @param activity
	 * @param dateAndTime
	 * @param data
	 */
	public ActivityLog(long iD, CitizenRegistration citizen, String pageName, String activity, Timestamp dateAndTime,
			String data) {
		super();
		ID = iD;
		this.citizen = citizen;
		this.pageName = pageName;
		this.activity = activity;
		this.dateAndTime = dateAndTime;
		this.data = data;
	}

	/**
	 * 
	 */
	public ActivityLog() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	
	
	
	
	
}
