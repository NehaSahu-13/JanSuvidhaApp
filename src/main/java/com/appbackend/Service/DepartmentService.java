package com.appbackend.Service;

import java.util.List;

import com.appbackend.Entities.Department;
import com.appbackend.Response.DepartmentResponse;

public interface DepartmentService {

	public Department addDepartment(String departmentName_Eng,String department_Hindi);
	
	public Department getDepartmentById(long id);
	
	public boolean deleteDepartment(long id);
	
	public Department updateDepartment(long id,String departmentName_Eng,String department_Hindi);
	
	public List<Department> getAllDepartment();
	
	public DepartmentResponse getDepartmentResponse(Department department);
	
}
