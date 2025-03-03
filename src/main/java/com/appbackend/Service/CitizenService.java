package com.appbackend.Service;

import com.appbackend.DTO.CitizenDTO;
import com.appbackend.Entities.CitizenRegistration;

public interface CitizenService {
	
	public String registerCitizen(CitizenDTO citizenDto);
	
    public CitizenRegistration getCitizenById(long id);
    
    public CitizenRegistration updateCitizen(CitizenDTO citizenDto);
    
    public void changePassword(long id,String newPassword);
    
    
    
}
