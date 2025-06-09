package com.appbackend.DTO;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class OfficeDTO {

	
	private long office_ID;
	
	private String office_Type;
	
	private String office_Name_Eng;
	
	private String office_Name_Hindi;
	
	private String office_Address;
	
	@Size(min = 10, max = 10, message = "Phone number must be 10 digits")
	private String office_Phone;
	
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",message = "Invalid Email Address!!" )
	private String office_Email;
	
	private long department_ID;

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
		return office_Name_Eng;
	}

	public void setOffice_Name_Eng(String office_Name_Eng) {
		this.office_Name_Eng = office_Name_Eng;
	}

	public String getOffice_Name_Hindi() {
		return office_Name_Hindi;
	}

	public void setOffice_Name_Hindi(String office_Name_Hindi) {
		this.office_Name_Hindi = office_Name_Hindi;
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

	public long getDepartment_ID() {
		return department_ID;
	}

	public void setDepartment_ID(long department_ID) {
		this.department_ID = department_ID;
	}

	@Override
	public String toString() {
		return "OfficeDTO [office_ID=" + office_ID + ", office_Type=" + office_Type + ", Office_Name_Eng="
				+ office_Name_Eng + ", Office_Name_Hindi=" + office_Name_Hindi + ", office_Address=" + office_Address
				+ ", office_Phone=" + office_Phone + ", office_Email=" + office_Email + ", department_ID="
				+ department_ID + "]";
	}

	/**
	 * @param office_ID
	 * @param office_Type
	 * @param office_Name_Eng
	 * @param office_Name_Hindi
	 * @param office_Address
	 * @param office_Phone
	 * @param office_Email
	 * @param department_ID
	 */
	public OfficeDTO(long office_ID, String office_Type, String office_Name_Eng, String office_Name_Hindi,
			String office_Address, String office_Phone,
			@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Invalid Email Address!!") String office_Email,
			long department_ID) {
		super();
		this.office_ID = office_ID;
		this.office_Type = office_Type;
		this.office_Name_Eng = office_Name_Eng;
		this.office_Name_Hindi = office_Name_Hindi;
		this.office_Address = office_Address;
		this.office_Phone = office_Phone;
		this.office_Email = office_Email;
		this.department_ID = department_ID;
	}

	/**
	 * 
	 */
	public OfficeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
