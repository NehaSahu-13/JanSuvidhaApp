package com.appbackend.Service;

import java.util.List;

import com.appbackend.DTO.OfficeDTO;
import com.appbackend.Entities.Office;

public interface OfficeService {

	public Office addOffice(OfficeDTO officeDto);
	
	public Office getOfficeById(long id);
	
	public boolean deleteOffice(long id);
	
	public Office updateOffice(OfficeDTO officeDto);
	
	public List<Office> getAllOffice();
	
	public OfficeDTO getOfficeResponse(Office office);
	
}
