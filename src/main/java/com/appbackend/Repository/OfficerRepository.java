package com.appbackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appbackend.Entities.CitizenRegistration;
import com.appbackend.Entities.OfficerRegistration;

public interface OfficerRepository extends JpaRepository<OfficerRegistration,Long>{

	@Query("select u from OfficerRegistration u where u.email=:email")
	public Optional<OfficerRegistration> findByUsername(@Param("email") String email) ;
	
}
