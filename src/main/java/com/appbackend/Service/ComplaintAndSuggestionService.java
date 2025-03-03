package com.appbackend.Service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.ComplaintAndSuggestionDTO;
import com.appbackend.Entities.ComplaintAndSuggestion;

public interface ComplaintAndSuggestionService {
	
	public ComplaintAndSuggestion addComplaintAndSuggestion(long id,ComplaintAndSuggestionDTO ComplaintAndSuggestionDto,MultipartFile file);
	
	public ComplaintAndSuggestion getComplaintAndSuggestionById(long id);
	
	public boolean deleteComplaintAndSuggestion(long id);
	
	public List<ComplaintAndSuggestion> getAllComplaintAndSuggestion();
	
	public ComplaintAndSuggestion Assignment(long complaintAndsuggestionID,long officeID);
	
	public ComplaintAndSuggestion solution(long id,String solution,MultipartFile file);

	
}
