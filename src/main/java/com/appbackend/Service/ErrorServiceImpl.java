package com.appbackend.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.ErrorLog;	
import com.appbackend.Repository.CitizenRepository;
import com.appbackend.Repository.ErrorLogRepository;

@Service
public class ErrorServiceImpl implements ErrorService{
	
	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private ErrorLogRepository errorRepository;

	@Override
	public ErrorLog addError(long userID, String error, String pageName, String error_Description) {
		ErrorLog errorlog=new ErrorLog();
		CitizenRegistration citizen=citizenRepository.findById(userID).get();
		errorlog.setCitizen(citizen);
		errorlog.setDateandTime(Timestamp.from(Instant.now()));
		errorlog.setError(error);
		errorlog.setErrorDetail(error_Description);
		errorlog.setPage_Name(pageName);
		citizen.getErrors().add(errorlog);
		errorRepository.save(errorlog);
		citizenRepository.save(citizen);
		return errorlog;
		
	}

	@Override
	public ErrorLog getErrorById(long id) {
		ErrorLog error=errorRepository.findById(id).get();
		return error;
	}

	@Override
	public List<ErrorLog> getAllError() {
		List<ErrorLog> errors=errorRepository.findAll();
		return errors;
	}

	@Override
	public List<ErrorLog> getAllErrorOfUser(long userID) {
		CitizenRegistration citizen=citizenRepository.findById(userID).get();
		List<ErrorLog>errors=citizen.getErrors();
		return errors;
	}

}
