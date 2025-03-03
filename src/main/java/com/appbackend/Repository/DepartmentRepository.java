package com.appbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appbackend.Entities.Department;

public interface DepartmentRepository extends JpaRepository<Department,Long>{

}
