package com.appbackend.Service;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.appbackend.DTO.ComplaintAndSuggestionDTO;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.ComplaintAndSuggestion;
import com.appbackend.Entities.Office;
import com.appbackend.Repository.CitizenRepository;
import com.appbackend.Repository.ComplaintAndSuggestionRepository;
import com.appbackend.Repository.OfficeRepository;

@Service
public class ComplaintAndSuggestionServiceImpl implements ComplaintAndSuggestionService{
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private OfficeRepository officeRepository;
	
	@Autowired
	private ComplaintAndSuggestionRepository complaintAndSuggestionRepository;
	
	@Autowired
	private FileService fileService;

	@Override
	public ComplaintAndSuggestion addComplaintAndSuggestion(long id,ComplaintAndSuggestionDTO ComplaintAndSuggestionDto,MultipartFile file) {
		
		ComplaintAndSuggestion obj=new ComplaintAndSuggestion();
		obj.setApplication_Type(ComplaintAndSuggestionDto.getApplication_Type());
		CitizenRegistration citizen=citizenRepository.findById(id).get();
		obj.setCitizen(citizen);
		obj.setDetails(ComplaintAndSuggestionDto.getDetails());
		obj.setLodge_Date(new Date());
		obj.setStatus("Pending");
		obj.setType(ComplaintAndSuggestionDto.getType());
		
		try {
			if(file!=null) {
			String fileName=fileService.uploadFile(file);
			obj.setUploaded_FileName(fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		citizen.getComplaintAndSuggestions().add(obj);
		
		citizenRepository.save(citizen);
		
		return obj;
		
	}

	@Override
	public ComplaintAndSuggestion getComplaintAndSuggestionById(long id) {
		ComplaintAndSuggestion obj=complaintAndSuggestionRepository.findById(id).get();
		return obj;
	}

	@Override
	public boolean deleteComplaintAndSuggestion(long id) {
		ComplaintAndSuggestion obj=complaintAndSuggestionRepository.findById(id).get();
		complaintAndSuggestionRepository.delete(obj);
		return true;
	}

	@Override
	public List<ComplaintAndSuggestion> getAllComplaintAndSuggestion() {
		List<ComplaintAndSuggestion>objs=complaintAndSuggestionRepository.findAll();   
		return objs;
	}

	
	@Override
	public ComplaintAndSuggestion Assignment(long complaintAndsuggestionID,long officeID) {
		
		ComplaintAndSuggestion obj=complaintAndSuggestionRepository.findById(complaintAndsuggestionID).get();
		Office office=officeRepository.findById(officeID).get();
		obj.setStatus("Assigned");
		obj.setOffice(office);
		office.getComplaintAndSuggestions().add(obj);
	
		officeRepository.save(office);
		
		return obj;
		
	}

	@Override
	public ComplaintAndSuggestion solution(long id,String solution, MultipartFile file) {
		
		ComplaintAndSuggestion obj=complaintAndSuggestionRepository.findById(id).get();
		obj.setDisposal_DateAndTime(Timestamp.from(Instant.now()));
		obj.setSolution(solution);
		int disposalID=Integer.parseInt(String.valueOf(obj.getOffice().getOffice_ID())+String.valueOf(id));
		obj.setDisposal_ID(disposalID);
		obj.setStatus("Resolved");
		
		try {
			if(file!=null) {
			String fileName=fileService.uploadFile(file);
			obj.setUploaded_FileName_ByOffice(fileName);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		complaintAndSuggestionRepository.save(obj);
		return obj;
	}
 

}
