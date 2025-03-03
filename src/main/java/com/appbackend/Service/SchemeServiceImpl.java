package com.appbackend.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.SchemeDTO;
import com.appbackend.Entities.Department;
import com.appbackend.Entities.OfficerRegistration;
import com.appbackend.Entities.Scheme;
import com.appbackend.Repository.DepartmentRepository;
import com.appbackend.Repository.OfficerRepository;
import com.appbackend.Repository.SchemeRepository;

@Service
public class SchemeServiceImpl implements SchemeService{
	
	@Autowired
	private FileService fileService ;
	
	@Autowired
	private OfficerRepository officerRepository;
	
	@Autowired
	private SchemeRepository schemeRepository;
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Scheme addScheme(SchemeDTO schemeDto,MultipartFile file,long officerID) {
		Scheme scheme=new Scheme();
		OfficerRegistration officer=officerRepository.findById(officerID).get();
		Department department=officer.getDepartment();
		scheme.setDepartment(department);
		scheme.setScheme_Description(schemeDto.getScheme_Description());
		scheme.setScheme_Eligiblity(schemeDto.getScheme_Eligiblity());
		scheme.setScheme_Sponsor(schemeDto.getScheme_Sponsor());
		scheme.setScheme_Title(schemeDto.getScheme_Title());
		scheme.setTo_Contact(schemeDto.getTo_Contact());
	     
		
		try {
			if(file!=null) {
			String fileName = fileService.uploadFile(file);
			scheme.setUploaded_FileName(fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		department.getSchemes().add(scheme);
		departmentRepository.save(department);
		return scheme;
		
	}

	@Override
	public Scheme getSchemeById(long id) {
		Scheme scheme=schemeRepository.findById(id).get();
		return scheme;
	}

	@Override
	public boolean deleteScheme(long id) {
		Scheme scheme=schemeRepository.findById(id).get();
		schemeRepository.delete(scheme);
		return true;
	}

	@Override
	public Scheme updateScheme(SchemeDTO schemeDto,MultipartFile file) {
		
		Scheme scheme=schemeRepository.findById(schemeDto.getId()).get();
		scheme.setScheme_Description(schemeDto.getScheme_Description());
		scheme.setScheme_Eligiblity(schemeDto.getScheme_Eligiblity());
		scheme.setScheme_Sponsor(schemeDto.getScheme_Sponsor());
		scheme.setScheme_Title(schemeDto.getScheme_Title());
		scheme.setTo_Contact(schemeDto.getTo_Contact());
	     
		
		try {
			   if(file!=null) {
				String oldFile=scheme.getUploaded_FileName();
				File deleteFile=new ClassPathResource("static/file").getFile();
				File file1=new File(deleteFile,oldFile);
				file1.delete();				
				
				fileService.uploadFile(file);
				
				scheme.setUploaded_FileName(file.getOriginalFilename());
			   }
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		
		return scheme;
	}

	@Override
	public List<Scheme> getAllSchemes() {
		List<Scheme> schemes=schemeRepository.findAll();
		return schemes;
	}

	@Override
	public List<Scheme> getAllSchemesByDepartment(long department_ID) {
		
		Department dep = departmentRepository.findById(department_ID).get();
		
		List<Scheme>schemes =  dep.getSchemes();
		
		return schemes;
				
	}

	
	
}
