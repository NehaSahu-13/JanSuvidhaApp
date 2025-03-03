package com.appbackend.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.SchemeDTO;
import com.appbackend.Entities.Scheme;

public interface SchemeService {

	public Scheme addScheme(SchemeDTO schemeDto,MultipartFile file,long officerID);
	
	public Scheme getSchemeById(long id);
	
	public boolean deleteScheme(long id);
	
	public Scheme updateScheme(SchemeDTO schemeDto,MultipartFile file);
	
	public List<Scheme> getAllSchemes();
	
	public List<Scheme> getAllSchemesByDepartment(long department_ID);
	
}
