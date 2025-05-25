package com.appbackend.Controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appbackend.DTO.OfficeDTO;
import com.appbackend.DTO.OfficerDTO;
import com.appbackend.Entities.ActivityLog;
import com.appbackend.Entities.ComplaintAndSuggestion;
import com.appbackend.Entities.Department;
import com.appbackend.Entities.ErrorLog;
import com.appbackend.Entities.Office;
import com.appbackend.Response.DepartmentResponse;
import com.appbackend.Service.ActivityService;
import com.appbackend.Service.ComplaintAndSuggestionService;
import com.appbackend.Service.DepartmentServiceImpl;
import com.appbackend.Service.ErrorService;
import com.appbackend.Service.OfficeService;
import com.appbackend.Service.OfficerService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/admin")
// @CrossOrigin(origins = "*")
public class AdminController {

	@Autowired
	private DepartmentServiceImpl departmentService;
	
	@Autowired
	private OfficeService officeService;
	
	@Autowired
	private ComplaintAndSuggestionService complaintService;	
	
	@Autowired
	private OfficerService officerService;

	@Autowired
	private ActivityService activityService;

	@Autowired
	private ErrorService errorService;

	
	@PostMapping("/addOfficer")
	public ResponseEntity<?> addOfficer(@Valid @RequestBody OfficerDTO officerDto,BindingResult result) {
		
		 if (result.hasErrors()) {
		        
		        List<String> errors = result.getFieldErrors().stream()
		            .map(error -> error.getDefaultMessage())
		            .collect(Collectors.toList());
		        
		        return ResponseEntity.badRequest().body(errors);
		    }
		    
		    
		    return ResponseEntity.ok(officerService.addOfficer(officerDto));
			    
	}
	

	@PostMapping("/department")
     public ResponseEntity<?> addDepartment(@RequestParam("departmentName_Eng") String departmentName_Eng, 
    		    @RequestParam("department_Hindi") String department_Hindi){
    	 
		Department department= departmentService.addDepartment(departmentName_Eng, department_Hindi);
		
		return ResponseEntity.ok(department);
		
     }
	
	
	@GetMapping("/department/{id}")
	public ResponseEntity<Department> getDepartment(@PathVariable("id") long id){
		
		Department department= departmentService.getDepartmentById(id);
		
		return ResponseEntity.ok(department);
		
	}
	
	
	@PutMapping("/department/{id}")
	 public ResponseEntity<?> updateDepartment(@PathVariable("id") long id,@RequestParam String departmentName_Eng, 
 		    @RequestParam String department_Hindi){
 	 
		Department department= departmentService.updateDepartment(id,departmentName_Eng, department_Hindi);
		
		return ResponseEntity.ok(department);
		
  }
	
	
	@GetMapping("/department")
	public ResponseEntity<List<DepartmentResponse>> getAllDepartment(){
		
		List<Department>departments= departmentService.getAllDepartment();
		
		List<DepartmentResponse>depRes = new ArrayList<>();
		
		for(Department dep:departments) {
			depRes.add(departmentService.getDepartmentResponse(dep));
		}
		
		return ResponseEntity.ok(depRes);
		
	}
	
	
	@DeleteMapping("/department/{id}")
	public ResponseEntity<String> deleteDepartment(@PathVariable("id") long id){
		
		departmentService.deleteDepartment(id);
		
		return ResponseEntity.ok("Department with ID: "+id+" deleted successfully !!");
		
	}
	
	
	
	
	@PostMapping("/office")
	public ResponseEntity<?> addOffice(@Valid @RequestBody OfficeDTO officeDto,BindingResult result) {
		
		 if (result.hasErrors()) {
		        
		        List<String> errors = result.getFieldErrors().stream()
		            .map(error -> error.getDefaultMessage())
		            .collect(Collectors.toList());
		        
		        return ResponseEntity.badRequest().body(errors);
		    }
		    
		    
		    return ResponseEntity.ok(officeService.addOffice(officeDto));
			    
	}
	
	
	
	@GetMapping("/office/{id}")
	public ResponseEntity<?> getOffice(@PathVariable("id") long id){
		
		Office office= officeService.getOfficeById(id);
		
		return ResponseEntity.ok(office);
		
	}
	
	
	@DeleteMapping("/office/{id}")
	 public ResponseEntity<?> deleteOffice(@PathVariable("id") long id){
		   
		 officeService.deleteOffice(id);
		 
		 return ResponseEntity.ok("Office with ID "+id+" deleted successfully!");
		 
	 }
	
	
	
	   @PutMapping("/office")
		public ResponseEntity<?> updateOffice(@Valid @RequestBody OfficeDTO officeDto,BindingResult result) {
			
			 if (result.hasErrors()) {
			        
			        List<String> errors = result.getFieldErrors().stream()
			            .map(error -> error.getDefaultMessage())
			            .collect(Collectors.toList());
			        
			        return ResponseEntity.badRequest().body(errors);
			    }
			 
			    officeService.updateOffice(officeDto);
			    
			    return ResponseEntity.ok("Office updated successfully!");
				    
	  }
	   
	   
	   @GetMapping("/office")
		public ResponseEntity<List<OfficeDTO>> getAllOffice(){
			
			List<Office>office= officeService.getAllOffice();
			
			List<OfficeDTO>officeRes = new ArrayList<>();
			
			for(Office of:office) {
				officeRes.add(officeService.getOfficeResponse(of));
			}
			
			return ResponseEntity.ok(officeRes);
			
		}


		 @GetMapping("/getAllComplaintAndSuggestion")
	   public ResponseEntity<List<ComplaintAndSuggestion>> getAllComplaintAndSuggestion(){
		   
		   List<ComplaintAndSuggestion> objs= complaintService.getAllComplaintAndSuggestion();
		   Collections.reverse(objs);
		   return ResponseEntity.ok(objs);
		   
	   }
	
	   @PostMapping("/complaintAssignment/{complaintId}")
	   public ResponseEntity<?> complaintAssignment(@PathVariable("complaintId") long complaintId,@RequestParam("officeId") long officeId){
		   
		    complaintService.Assignment(complaintId, officeId);
		    
		    return ResponseEntity.ok("Complaint/Suggestion assigned successfully !!");
		   
	   }


	    @GetMapping("/getActivity/{id}")
	   public ResponseEntity<?> getActivity(@PathVariable("id") long id){
		   
		  ActivityLog activity= activityService.getActivityById(id);
		   
		  return ResponseEntity.ok(activity);
		   
	   }
	   
	   @GetMapping("/getAllActivityOfUser/{id}")
	   public ResponseEntity<?> getAllActivityOfUser(@PathVariable("id") long id){
		   
		  List<ActivityLog> activities= activityService.getAllActvitiesOfUser(id);
		  Collections.reverse(activities);
		  return ResponseEntity.ok(activities);
		   
	   }
	   
	   @GetMapping("/getAllActivity")
	   public ResponseEntity<?> getAllActivity(){
		   
		  List<ActivityLog> activities= activityService.getAllActivites();
		  Collections.reverse(activities);
		  return ResponseEntity.ok(activities);
		   
	   }
	   
	    @GetMapping("/getError/{id}")
	   public ResponseEntity<ErrorLog> getErrorById(@PathVariable("id") long id){
		   
		   ErrorLog error= errorService.getErrorById(id);
		   
		   return ResponseEntity.ok(error);
		   
	   }
	   
	   @GetMapping("/getAllError")
	   public ResponseEntity<List<ErrorLog>> getAllError(){
		   
		   List<ErrorLog>errors = errorService.getAllError();
		   
		   return ResponseEntity.ok(errors);
		   
	   }
	
	   
	  
}
