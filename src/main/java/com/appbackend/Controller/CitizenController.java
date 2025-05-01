package com.appbackend.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.CitizenDTO;
import com.appbackend.DTO.ComplaintAndSuggestionDTO;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.Notice;
import com.appbackend.Entities.Scheme;
import com.appbackend.Service.ActivityService;
import com.appbackend.Service.CitizenService;
import com.appbackend.Service.CitizenServiceImpl;
import com.appbackend.Service.ComplaintAndSuggestionService;
import com.appbackend.Service.CustomUserDetailsService;
import com.appbackend.Service.ErrorService;
import com.appbackend.Service.NoticeService;
import com.appbackend.Service.SchemeService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class CitizenController {
	
	@Autowired
	private CitizenService citizenService;
	
	@Autowired
	private ComplaintAndSuggestionService complaintService;
	
	@Autowired
	private SchemeService schemeService;

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private NoticeService noticeService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private ErrorService errorService;
	
	  

	@PostMapping("/public/register")
	public ResponseEntity<?> addCitizen(@Valid @RequestBody CitizenDTO citizen,BindingResult result) {
		
		 if (result.hasErrors()) {
		        
		        List<String> errors = result.getFieldErrors().stream()
		            .map(error -> error.getDefaultMessage())
		            .collect(Collectors.toList());
		        
		        return ResponseEntity.badRequest().body(errors);
		    }
		    
		    
		    return ResponseEntity.ok(citizenService.registerCitizen(citizen));
			    
	}
	
	
	@GetMapping("/citizen/{id}")
	public ResponseEntity<?> getCitizen(@PathVariable("id") long id){
		
		CitizenRegistration citizen=citizenService.getCitizenById(id);
		
//		 Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//	        
//	        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
//	            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//	            System.out.println( "Current User: " + userDetails.getUsername());
//	        }
		
		return ResponseEntity.ok(citizen);
		
	}
	
	
	
	 
	    @PutMapping("/citizen")
		public ResponseEntity<?> updateCitizen(@Valid @RequestBody CitizenDTO citizen,BindingResult result) {
			
			 if (result.hasErrors()) {
			        
			        List<String> errors = result.getFieldErrors().stream()
			            .map(error -> error.getDefaultMessage())
			            .collect(Collectors.toList());
			        
			        return ResponseEntity.badRequest().body(errors);
			    }
			 
			    citizenService.updateCitizen(citizen);
			    
			    return ResponseEntity.ok("Citizen updated successfully!");
				    
		}
	    
	    
	    @PostMapping("/citizen/changepassword/{id}")
		public ResponseEntity<?> ChangePassword(@PathVariable("id") long id,@RequestParam("currpassword") String currpassword,@RequestParam("newpassword") String newpassword,@RequestParam("confirmpassword") String confirmpassword) {
			
	    	CitizenRegistration citizen=citizenService.getCitizenById(id);
	    	
			if (!newpassword.equals(confirmpassword)) {
	            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New password and confirm password do not match.");
	        }
		
			
	        if(!passwordEncoder.matches(currpassword, citizen.getPassword())) {
	        	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Current password do not match.");
	        }
	     
	        citizenService.changePassword(id, newpassword);
	        
		    return ResponseEntity.ok("Password Changed Successfully !!");

		}
	    
	    
	    @PostMapping("/citizen/complaint/{id}")
	    public ResponseEntity<?> complaintAndSuggestion(@PathVariable("id") long id,@RequestPart("complaint") ComplaintAndSuggestionDTO complaint,
	            @RequestPart(value = "file", required = false) MultipartFile file){
	    	
	    	 complaintService.addComplaintAndSuggestion(id,complaint, file);
	    	
	    	return ResponseEntity.ok("Complaint/Suggestion added Successfully !!");

	    	
	    }
	    
	    
	    @GetMapping("/citizen/getNotice/{id}")
	    public ResponseEntity<?> getNotice(@PathVariable("id") long id){
			
			Notice notice=noticeService.getNoticeByID(id);
			
			return ResponseEntity.ok(notice);
			
		}
		
		
		@GetMapping("/citizen/getAllNotice")
	    public ResponseEntity<?> getAllNotice(){
			
			List<Notice> notices=noticeService.getAllNoticeForCitizen();
			Collections.reverse(notices);
			return ResponseEntity.ok(notices);
			
		}
		
		@GetMapping("/citizen/getScheme/{id}")
		public ResponseEntity<?> getScheme(@PathVariable("id") long id){
			
			Scheme scheme=schemeService.getSchemeById(id);
			
			return ResponseEntity.ok(scheme);
			
		}
		
		@GetMapping("/citizen/getAllScheme")
		public ResponseEntity<?> getAllScheme(){
			
			List<Scheme> schemes=schemeService.getAllSchemes();
			Collections.reverse(schemes);
			return ResponseEntity.ok(schemes);
			
		}

		@PostMapping("/citizen/addActivity")
		public ResponseEntity<?> addActivity(@RequestParam("user_ID") long user_ID,@RequestParam("pageName") String pageName,@RequestParam("activity") String activity,@RequestParam("data") String data){
			
			activityService.addActivity(user_ID, pageName, activity, data);
			
			return ResponseEntity.ok("Actvity added successfully !!");
			
		}

		@PostMapping("/addError/{id}")
		public ResponseEntity<?> addError(@PathVariable("id") long id,@RequestParam("error") String error,@RequestParam("pageName") String pageName,@RequestParam("error_Description") String error_Description){
			
			errorService.addError(id, error, pageName, error_Description);
			
			return ResponseEntity.ok("Error added successfully !!");
			
		}
	 
}
