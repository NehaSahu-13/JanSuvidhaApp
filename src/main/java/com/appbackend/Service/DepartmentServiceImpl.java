package com.appbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appbackend.Entities.Department;
import com.appbackend.Repository.DepartmentRepository;
import com.appbackend.Response.DepartmentResponse;

@Service
public class DepartmentServiceImpl implements DepartmentService{
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department addDepartment(String departmentName_Eng, String department_Hindi) {
		Department department=new Department();
		department.setDepartment_Name_Eng(departmentName_Eng);
		department.setDepartment_Name_Hindi(department_Hindi);
		Department savedDepartment=departmentRepository.save(department);
		return savedDepartment;
	}

	@Override
	public Department getDepartmentById(long id) {
		Department department=departmentRepository.findById(id).get();
		return department;
	}

	@Override
	public boolean deleteDepartment(long id) {
		Department department=departmentRepository.findById(id).get();
		departmentRepository.delete(department);
		return true;
	}

	@Override
	public Department updateDepartment(long id,String departmentName_Eng, String department_Hindi) {
		Department department=departmentRepository.findById(id).get();
		department.setDepartment_Name_Eng(departmentName_Eng);
		department.setDepartment_Name_Hindi(department_Hindi);
		Department updatedDepartment=departmentRepository.save(department);
		return updatedDepartment;
		
	}

	@Override
	public DepartmentResponse getDepartmentResponse(Department department) {
		DepartmentResponse res=new DepartmentResponse();
		res.setDepartment_ID(department.getDepartment_ID());
		res.setDepartment_Name_Eng(department.getDepartment_Name_Eng());
		res.setDepartment_Name_Hindi(department.getDepartment_Name_Hindi());
		return res;
	}

	@Override
	public List<Department> getAllDepartment() {
		List<Department>departments=departmentRepository.findAll();
		return departments;
	}

	
	
}
