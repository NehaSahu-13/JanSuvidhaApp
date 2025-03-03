package com.appbackend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appbackend.Entities.ErrorLog;

public interface ErrorLogRepository extends JpaRepository<ErrorLog,Long>{

}
