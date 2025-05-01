package com.appbackend.Controller;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.ComplaintAndSuggestionDTO;
import com.appbackend.DTO.NoticeDTO;
import com.appbackend.DTO.OfficeDTO;
import com.appbackend.DTO.OfficerDTO;
import com.appbackend.DTO.SchemeDTO;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.Notice;
import com.appbackend.Entities.Office;
import com.appbackend.Entities.OfficerRegistration;
import com.appbackend.Entities.Scheme;
import com.appbackend.Service.ComplaintAndSuggestionService;
import com.appbackend.Service.NoticeService;
import com.appbackend.Service.OfficerService;
import com.appbackend.Service.SchemeService;

import jakarta.validation.Valid;

@CrossOrigin(origins = "*")
@RestController
public class OfficerController {
	
	
	@Autowired
	private OfficerService officerService;
	
	@Autowired
	private SchemeService schemeService;
	
	@Autowired
	private NoticeService noticeService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private ComplaintAndSuggestionService complaintService;	
	
	
	@GetMapping("/officer/{id}")
	public ResponseEntity<?> getOfficer(@PathVariable("id") long id){
		
		OfficerRegistration officer= officerService.getOfficerById(id);
		
		return ResponseEntity.ok(officer);
		
	}
	
	
	@PutMapping("/officer")
	public ResponseEntity<?> updateOfficer(@Valid @RequestBody OfficerDTO officerDto,BindingResult result) {
		
		 if (result.hasErrors()) {
		        
		        List<String> errors = result.getFieldErrors().stream()
		            .map(error -> error.getDefaultMessage())
		            .collect(Collectors.toList());
		        
		        return ResponseEntity.badRequest().body(errors);
		    }
		 
		    officerService.updateOfficer(officerDto);
		    
		    return ResponseEntity.ok("Office updated successfully!");
			    
  }
	
	
	@PostMapping("/officer/changepassword/{id}")
	public ResponseEntity<?> ChangePassword(@PathVariable("id") long id,@RequestParam("currpassword") String currpassword,@RequestParam("newpassword") String newpassword,@RequestParam("confirmpassword") String confirmpassword) {
		
    	OfficerRegistration officer=officerService.getOfficerById(id);
    	
		if (!newpassword.equals(confirmpassword)) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("New password and confirm password do not match.");
        }
        if(!passwordEncoder.matches(currpassword, officer.getPassword())) {
        	  return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Current password do not match.");
        }
     
        officerService.changePassword(id, newpassword);
        
	    return ResponseEntity.ok("Password Changed Successfully !!");

	}
	
	
	@PostMapping("/officer/uploadNotice/{id}")
	public ResponseEntity<?> uploadNotice(@PathVariable("id") long id,@RequestPart("notice") NoticeDTO notice,
            @RequestPart(value = "file", required = false) MultipartFile file){
		
	    	noticeService.addNotice(id, notice, file);
		
	    	return ResponseEntity.ok("Notice uploaded Successfully !!");
		
	}
	
	
	@PutMapping("/officer/updateNotice")
	public ResponseEntity<?> updateNotice(@RequestPart("notice") NoticeDTO notice,
            @RequestPart(value = "file", required = false) MultipartFile file){
		
	    	noticeService.updateNotice( notice, file);
		
	    	return ResponseEntity.ok("Notice updated Successfully !!");
		
	}
	
	@DeleteMapping("/officer/deleteNotice/{id}")
	public ResponseEntity<?> deleteNotice(@PathVariable("id") long id){
		
		noticeService.deleteNotice(id);
		
		return ResponseEntity.ok("Notice deleted Successfully !!");
		
	}
	
	
	@GetMapping("/officer/getNotice/{id}")
    public ResponseEntity<?> getNotice(@PathVariable("id") long id){
		
		Notice notice=noticeService.getNoticeByID(id);
		
		return ResponseEntity.ok(notice);
		
	}
	
	
	@GetMapping("/officer/getAllNotice")
    public ResponseEntity<?> getAllNotice(){
		
		List<Notice> notices=noticeService.getAllNoticeForOfficer();
		Collections.reverse(notices);
		return ResponseEntity.ok(notices);
		
	}
	
	@GetMapping("/officer/getAllNoticeUploadedByOfficer/{id}")
    public ResponseEntity<?> getAllNoticeUploadedByOfficer(@PathVariable("id") long id){
		
		List<Notice> notices=noticeService.getAllNotices();
		Collections.reverse(notices);
		return ResponseEntity.ok(notices);
		
	}
	
	
	@PostMapping("/officer/addScheme/{id}")
	public ResponseEntity<?> addScheme(@PathVariable("id") long id,@RequestPart("scheme") SchemeDTO scheme,
            @RequestPart(value = "file", required = false) MultipartFile file){
		
		schemeService.addScheme(scheme, file, id);
		
		return ResponseEntity.ok("Scheme added Successfully !!");
		
	}
	
	@GetMapping("/officer/getScheme/{id}")
	public ResponseEntity<?> getScheme(@PathVariable("id") long id){
		
		Scheme scheme=schemeService.getSchemeById(id);
		
		return ResponseEntity.ok(scheme);
		
	}
	
	@PutMapping("/officer/updateScheme")
	public ResponseEntity<?> updateScheme(@RequestPart("scheme") SchemeDTO scheme,
            @RequestPart(value = "file", required = false) MultipartFile file){
		
		  schemeService.updateScheme(scheme, file);
		  
		  return ResponseEntity.ok("Scheme updated Successfully !!");
		
		
	}
	
	@DeleteMapping("/officer/deleteScheme/{id}")
    public ResponseEntity<?> deleteScheme(@PathVariable("id") long id){
		
		schemeService.deleteScheme(id);
		
		return ResponseEntity.ok("Scheme deleted Successfully !!");
		
	}
	
	
	@GetMapping("/officer/getAllScheme")
	public ResponseEntity<?> getAllScheme(){
		
		List<Scheme> schemes=schemeService.getAllSchemes();
		Collections.reverse(schemes);
		return ResponseEntity.ok(schemes);
		
	}
	
	
	@GetMapping("/officer/getAllSchemeByDepartment/{id}")
	public ResponseEntity<?> getAllSchemeByDepartment(@PathVariable("id") long id){
		
		List<Scheme> schemes=schemeService.getAllSchemesByDepartment(id);
		Collections.reverse(schemes);
		return ResponseEntity.ok(schemes);
		
	}


	@PostMapping("/officer/resolveComplaint/{complaintId}")
	public ResponseEntity<?> resolveComplaint(@PathVariable("complaintId") long complaintId,@RequestPart("solution") String solution,
            @RequestPart(value = "file", required = false) MultipartFile file){
	
		complaintService.solution(complaintId, solution, file);
		
		return ResponseEntity.ok("Complaint/Suggestion resolved successfully !!");
		
	}
	
	
	
}
