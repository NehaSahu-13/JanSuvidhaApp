package com.appbackend.DTO;

import java.sql.Timestamp;
import java.util.Date;

public class ComplaintAndSuggestionDTO {

	
	private int type;
	
	private String application_Type;
	
	private String details;
	

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
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

	/**
	 * @param type
	 * @param application_Type
	 * @param details
	 */
	public ComplaintAndSuggestionDTO(int type, String application_Type, String details) {
		super();
		this.type = type;
		this.application_Type = application_Type;
		this.details = details;
	}

	/**
	 * 
	 */
	public ComplaintAndSuggestionDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "ComplaintAndSuggestionDTO [type=" + type + ", application_Type=" + application_Type + ", details="
				+ details + "]";
	}

	
	
	
	
}
