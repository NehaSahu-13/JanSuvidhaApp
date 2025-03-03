package com.appbackend.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appbackend.DTO.OfficeDTO;
import com.appbackend.Entities.Department;
import com.appbackend.Entities.Office;
import com.appbackend.Repository.DepartmentRepository;
import com.appbackend.Repository.OfficeRepository;

@Service
public class OfficeServiceImpl implements OfficeService{

	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Office addOffice(OfficeDTO officeDto) {
		Office office=new Office();
		Department department=departmentRepository.findById(officeDto.getDepartment_ID()).get();
		office.setDepartment(department);
		office.setOffice_Address(officeDto.getOffice_Address());
		office.setOffice_Email(officeDto.getOffice_Email());
		office.setOffice_Name_Eng(officeDto.getOffice_Name_Eng());
		office.setOffice_Name_Hindi(officeDto.getOffice_Name_Hindi());
		office.setOffice_Phone(officeDto.getOffice_Phone());
		office.setOffice_Type(officeDto.getOffice_Type());
		Office saved_Office=officeRepository.save(office);
		return saved_Office;
	}

	@Override
	public Office getOfficeById(long id) {
		Office office = officeRepository.findById(id).get();
		return office;
	}

	@Override
	public boolean deleteOffice(long id) {
		Office office = officeRepository.findById(id).get();
		officeRepository.delete(office);
		return true;
	}

	@Override
	public Office updateOffice(OfficeDTO officeDto) {
		Office office=officeRepository.findById(officeDto.getOffice_ID()).get();
		office.setOffice_Address(officeDto.getOffice_Address());
		office.setOffice_Email(officeDto.getOffice_Email());
		office.setOffice_Name_Eng(officeDto.getOffice_Name_Eng());
		office.setOffice_Name_Hindi(officeDto.getOffice_Name_Hindi());
		office.setOffice_Phone(officeDto.getOffice_Phone());
		office.setOffice_Type(officeDto.getOffice_Type());
		Office updated_Office=officeRepository.save(office);
		return updated_Office;
	}

	@Override
	public OfficeDTO getOfficeResponse(Office office) {
		
		OfficeDTO officeDto=new OfficeDTO();
		officeDto.setOffice_Address(office.getOffice_Address());
		officeDto.setOffice_Email(office.getOffice_Email());
		officeDto.setOffice_ID(office.getOffice_ID());
		officeDto.setOffice_Name_Eng(office.getOffice_Name_Eng());
		officeDto.setOffice_Name_Hindi(office.getOffice_Name_Hindi());
		officeDto.setOffice_Phone(office.getOffice_Phone());
		officeDto.setOffice_Type(office.getOffice_Type());
		officeDto.setDepartment_ID(office.getDepartment().getDepartment_ID());
		
		return officeDto;
		
	}

	@Override
	public List<Office> getAllOffice() {
		
		List<Office> office= officeRepository.findAll();
		
		return office;
	}

	
	
}
