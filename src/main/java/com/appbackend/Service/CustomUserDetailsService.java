package com.appbackend.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.appbackend.Entities.Admin;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.OfficerRegistration;
import com.appbackend.Repository.CitizenRepository;
import com.appbackend.Repository.OfficerRepository;



@Service
public class CustomUserDetailsService implements UserDetailsService {
	
	
    @Autowired
    private CitizenRepository citizenRepository;

    @Autowired
    private OfficerRepository officerRepository;
   

    @Override
    public UserDetails loadUserByUsername(String userID) throws UsernameNotFoundException {
    	
    	long id;

        try {
            id = Long.parseLong(userID);
        } catch (NumberFormatException e) {
            throw new UsernameNotFoundException("Invalid ID format: ");
        }

     
    	 UserDetails userDetails = null;
    	
    	   if (userDetails == null && id==1234567890L) {
    		   String adminPassword = new BCryptPasswordEncoder().encode("neha@1234");
               System.out.println("custom "+adminPassword);
               userDetails = new CustomUserPrincipal(
            		   1234567890L,
                       adminPassword,
                       Collections.singleton(new SimpleGrantedAuthority("ADMIN")),
                       "ADMIN"
               );
  	       return userDetails;
  	    }

   
    	
    	   
    	 if (userDetails == null) { 
    	    
    	    Optional<CitizenRegistration> citizenById = citizenRepository.findById(id);
            if (citizenById.isPresent()) {
                CitizenRegistration citizen = citizenById.get();
                userDetails = new CustomUserPrincipal(
                        citizen.getUser_ID(),
                        citizen.getPassword(),
                        Collections.singleton(new SimpleGrantedAuthority("CITIZEN")),
                        "CITIZEN"
                );
            }
            
    	 }
    
    	 
    	    if (userDetails == null) {
                Optional<OfficerRegistration> officerById = officerRepository.findById(id);    
                if (officerById.isPresent()) {
                    OfficerRegistration officer = officerById.get();
                    userDetails = new CustomUserPrincipal(
                            officer.getOfficer_ID(),
                            officer.getPassword(),
                            Collections.singleton(new SimpleGrantedAuthority("OFFICER")),
                            "OFFICER"
                    );
                }
            }
    	    
    	   
    	    if (userDetails != null) {
    	        return userDetails;
    	    } else {
    	        throw new UsernameNotFoundException("User not found: " + userID);
    	    }
    }
}
