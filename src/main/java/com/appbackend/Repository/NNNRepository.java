package com.appbackend.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.appbackend.Entities.NNN;

public interface NNNRepository extends JpaRepository<NNN,Integer>{

    @Query("select u from NNN u where u.district_ID=:districtID")
	public List<NNN> findByDistrict(@Param("districtID") int districtID) ;

}

