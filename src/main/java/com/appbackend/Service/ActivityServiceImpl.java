package com.appbackend.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appbackend.Entities.ActivityLog;
import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Repository.ActivityLogRepository;
import com.appbackend.Repository.CitizenRepository;

@Service
public class ActivityServiceImpl implements ActivityService{

	@Autowired
	private CitizenRepository citizenRepository;
	
	@Autowired
	private ActivityLogRepository activityRepository;
	
	
	@Override
	public ActivityLog addActivity(long user_ID, String pageName, String activity, String data) {
		
		CitizenRegistration citizen=citizenRepository.findById(user_ID).get();
		ActivityLog activitylog=new ActivityLog();
		activitylog.setActivity(activity);
		activitylog.setCitizen(citizen);
		activitylog.setData(data);
		activitylog.setDateAndTime(Timestamp.from(Instant.now()));
		activitylog.setPageName(pageName);
		
		citizen.getActivities().add(activitylog);
		
		citizenRepository.save(citizen);
		
		return activitylog;
		
	}

	@Override
	public ActivityLog getActivityById(long id) {
		ActivityLog activity=activityRepository.findById(id).get();
		return activity;
	}

	@Override
	public List<ActivityLog> getAllActvitiesOfUser(long user_ID) {
		CitizenRegistration citizen=citizenRepository.findById(user_ID).get();
		List<ActivityLog> activities=citizen.getActivities();
		return activities;
	}

	@Override
	public List<ActivityLog> getAllActivites() {
		
		List<ActivityLog> activities=activityRepository.findAll();
		return activities;
		
	}

	
	
	
}
