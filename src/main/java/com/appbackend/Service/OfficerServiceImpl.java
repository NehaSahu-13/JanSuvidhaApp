package com.appbackend.Service;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appbackend.DTO.OfficerDTO;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.Department;
import com.appbackend.Entities.Office;
import com.appbackend.Entities.OfficerRegistration;
import com.appbackend.Repository.DepartmentRepository;
import com.appbackend.Repository.OfficeRepository;
import com.appbackend.Repository.OfficerRepository;


@Service
public class OfficerServiceImpl implements OfficerService{
	
	@Autowired
	private DepartmentRepository departmentRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private OfficerRepository officerRepository;
	
	@Autowired
	private PasswordEncoder  bCryptPasswordEncoder;

	@Override
	public OfficerRegistration addOfficer(OfficerDTO officerDto) {
		
		
		OfficerRegistration officer=new OfficerRegistration();
		officer.setCreated_By(officerDto.getCreated_By());
		officer.setCreation_Date(new Date());
		Department department=departmentRepository.findById(officerDto.getDepartment_ID()).get();
		officer.setDepartment(department);
		Office office=officeRepository.findById(officerDto.getOffice_ID()).get();
		officer.setOffice(office);
		officer.setOfficer_Designation(officerDto.getOfficer_Designation());
		officer.setEmail(officerDto.getEmail());
	;
		
		 Random random = new Random();
		 
		int randomNumber = random.nextInt(Integer.MAX_VALUE); 

		long uniqueId=Long.parseLong(String.valueOf(officerDto.getDepartment_ID())+String.valueOf(officerDto.getOffice_ID())+String.valueOf(randomNumber));
		
		while(officerRepository.findById(uniqueId).isPresent()) {
			randomNumber = random.nextInt(Integer.MAX_VALUE);
			uniqueId=Long.parseLong(String.valueOf(officerDto.getDepartment_ID())+String.valueOf(officerDto.getOffice_ID())+String.valueOf(randomNumber));
		}
		
		officer.setOfficer_ID(uniqueId);
		
		officer.setOfficer_Name(officerDto.getOfficer_Name());
		officer.setOfficer_PhoneNumber(officerDto.getOfficer_PhoneNumber());
		officer.setPassword(bCryptPasswordEncoder.encode(officerDto.getPassword()));
		department.getOfficers().add(officer);
		office.getOfficers().add(officer);
		
	   departmentRepository.save(department);
		
		return officer;
		
	}

	@Override
	public OfficerRegistration getOfficerById(long id) {
		OfficerRegistration officer=officerRepository.findById(id).get();
		return officer;
	}

	@Override
	public boolean deleteOfficer(long id) {
		OfficerRegistration officer=officerRepository.findById(id).get();
		officerRepository.delete(officer);
		return true;
	}

	@Override
	public OfficerRegistration updateOfficer(OfficerDTO officerDto) {
		
		OfficerRegistration officer=officerRepository.findById(officerDto.getOfficer_ID()).get();
		Department department=departmentRepository.findById(officerDto.getDepartment_ID()).get();
		officer.setDepartment(department);
		Office office=officeRepository.findById(officerDto.getOffice_ID()).get();
		officer.setOffice(office);
		officer.setOfficer_Designation(officerDto.getOfficer_Designation());
		officer.setOfficer_Name(officerDto.getOfficer_Name());
		officer.setOfficer_PhoneNumber(officerDto.getOfficer_PhoneNumber());
		OfficerRegistration updated_officer=officerRepository.save(officer);
		
		return updated_officer;
		
	}

	@Override
	public void changePassword(long id, String newPassword) {
		

     	OfficerRegistration officer=officerRepository.findById(id).get();
        officer.setPassword(bCryptPasswordEncoder.encode(newPassword));
        officerRepository.save(officer);
		
	}

}
