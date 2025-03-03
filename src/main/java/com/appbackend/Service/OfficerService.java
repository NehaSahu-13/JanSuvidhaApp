package com.appbackend.Service;

import com.appbackend.DTO.OfficerDTO;
import com.appbackend.Entities.OfficerRegistration;

public interface OfficerService {

	public OfficerRegistration addOfficer(OfficerDTO officerDto);
	
	public OfficerRegistration getOfficerById(long id);
	
	public boolean deleteOfficer(long id);
	
	public OfficerRegistration updateOfficer(OfficerDTO officerDto);
	
	public void changePassword(long id,String newPassword);
	
}
