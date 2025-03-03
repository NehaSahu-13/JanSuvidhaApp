package com.appbackend.Response;

public class DepartmentResponse {

    private long department_ID;
	
	private String department_Name_Eng;
	
	private String department_Name_Hindi;

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

	@Override
	public String toString() {
		return "DepartmentResponse [department_ID=" + department_ID + ", department_Name_Eng=" + department_Name_Eng
				+ ", department_Name_Hindi=" + department_Name_Hindi + "]";
	}

	/**
	 * @param department_ID
	 * @param department_Name_Eng
	 * @param department_Name_Hindi
	 */
	public DepartmentResponse(long department_ID, String department_Name_Eng, String department_Name_Hindi) {
		super();
		this.department_ID = department_ID;
		this.department_Name_Eng = department_Name_Eng;
		this.department_Name_Hindi = department_Name_Hindi;
	}

	/**
	 * 
	 */
	public DepartmentResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
}
