package com.appbackend.Service;

import java.util.List;

import com.appbackend.Entities.ErrorLog;

public interface ErrorService {

	public ErrorLog addError(long userID,String error,String pageName,String error_Description);
	
	public ErrorLog getErrorById(long id);
	
	public List<ErrorLog> getAllError();
	
	public List<ErrorLog> getAllErrorOfUser(long userID);
}
