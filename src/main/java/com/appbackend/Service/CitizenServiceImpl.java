package com.appbackend.Service;



import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.appbackend.DTO.CitizenDTO;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.District;
import com.appbackend.Repository.CitizenRepository;
import com.appbackend.Repository.DistrictRepository;


import jakarta.transaction.Transactional;

@Service
public class CitizenServiceImpl implements CitizenService{

	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private DistrictRepository districtRepository;
	
	
	@Autowired
	private PasswordEncoder  bCryptPasswordEncoder;
	
	
	@Override
	public CitizenRegistration getCitizenById(long id) {
		CitizenRegistration citizen=citizenRepository.findById(id).get();
		return citizen;
	}
	
	@Override
	public String registerCitizen(CitizenDTO citizenDto) {
		
		if(citizenRepository.existsById(Long.parseLong(citizenDto.getPhone_Number()))) {
			return "Phone Number already exists";
		}
		
		if (citizenDto.getEmail() != null) {
	        Optional<CitizenRegistration> existingCitizen = citizenRepository.findByUsername(citizenDto.getEmail());
	        if (existingCitizen.isPresent()) {
	            System.out.println("Found existing citizen: " + existingCitizen.get().getEmail());
	            return "Email already exists";
	        }
	    }
		
		CitizenRegistration citizen=new CitizenRegistration();
		citizen.setAddress(citizenDto.getAddress());
		citizen.setEmail(citizenDto.getEmail());
		citizen.setGender(citizenDto.getGender());
		citizen.setPassword( bCryptPasswordEncoder.encode(citizenDto.getPassword()));
		citizen.setPhone_Number(citizenDto.getPhone_Number());
		citizen.setRegistrationDate(new Date());
		citizen.setUser_ID(Long.parseLong(citizenDto.getPhone_Number()));
		citizen.setUser_Name(citizenDto.getUser_Name());
		District district=districtRepository.findById(citizenDto.getDistrict_ID()).get();
		citizen.setDistrict(district);
	    citizenRepository.save(citizen);
		
		return "You registered successfully!";
	}


	@Override
	public CitizenRegistration updateCitizen(CitizenDTO citizenDto) {
		CitizenRegistration citizen=citizenRepository.findById(citizenDto.getId()).get();
		citizen.setAddress(citizenDto.getAddress());
		citizen.setEmail(citizenDto.getEmail());
		citizen.setGender(citizenDto.getGender());
		citizen.setUser_Name(citizenDto.getUser_Name());
		CitizenRegistration updated_citizen=citizenRepository.save(citizen);
		return updated_citizen;
		
	}

	@Override
	public void changePassword(long id,String newPassword) {
	    
	     	CitizenRegistration citizen=citizenRepository.findById(id).get();
	        citizen.setPassword(bCryptPasswordEncoder.encode(newPassword));
	        citizenRepository.save(citizen);
		    

	}
		

	
	
	
}
