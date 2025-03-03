package com.appbackend.Service;

import java.util.List;

import com.appbackend.Entities.ActivityLog;

public interface ActivityService {

	public ActivityLog addActivity(long user_ID,String pageName,String activity,String data);
	
	public ActivityLog getActivityById(long id);
	
	public List<ActivityLog> getAllActvitiesOfUser(long user_ID);
	
	public List<ActivityLog> getAllActivites();
	
	
}
