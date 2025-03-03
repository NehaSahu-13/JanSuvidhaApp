package com.appbackend.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appbackend.Entities.CitizenRegistration;


public interface CitizenRepository extends JpaRepository<CitizenRegistration,Long>{

	@Query("select u from CitizenRegistration u where u.email=:email")
	public Optional<CitizenRegistration> findByUsername(@Param("email") String email) ;
	
	
	 
}
