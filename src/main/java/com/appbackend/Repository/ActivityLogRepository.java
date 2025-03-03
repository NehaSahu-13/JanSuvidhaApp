package com.appbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appbackend.Entities.ActivityLog;

public interface ActivityLogRepository extends JpaRepository<ActivityLog,Long>{

}
