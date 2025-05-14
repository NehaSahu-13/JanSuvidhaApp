package com.appbackend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appbackend.Entities.Block;
import com.appbackend.Entities.District;
import com.appbackend.Entities.NNN;
import com.appbackend.Entities.Panchayat;
import com.appbackend.Repository.BlockRepository;
import com.appbackend.Repository.DistrictRepository;
import com.appbackend.Repository.NNNRepository;


@RestController
@RequestMapping("/public")
@CrossOrigin(origins = "*")
public class PublicController {
	

	    @Autowired
	    private DistrictRepository disRepo;
	    
	    @Autowired
	    private BlockRepository BlockRepo;
	    
	    @Autowired
	    private NNNRepository NNNRepo;
	   
	    @GetMapping("/getAllDistricts")
	    public ResponseEntity<List<District>> getAllDistrict(){
		   
		  List<District>districts= disRepo.findAll();
		  
		  return ResponseEntity.ok(districts);
		   
	   }
	    
	   
	   
	   @GetMapping("/getAllBlocks/{districtID}")
	   public ResponseEntity<List<Block>> getAllBlocks(@PathVariable("districtID") int districtID){
		   
		   District district=disRepo.findById(districtID).get();
		   List<Block>blocks= district.getBlocks();
		   return ResponseEntity.ok(blocks);
		   
	   }
	   
	   
	   @GetMapping("/getAllPanchayats/{blockID}")
	   public ResponseEntity<List<Panchayat>> getAllPanchayat(@PathVariable("blockID") int blockID){
		   
		   Block block=BlockRepo.findById(blockID).get();
		   List<Panchayat>panchayat= block.getPanchayat();
		   return ResponseEntity.ok(panchayat);
		   
	   }
	   
	   @GetMapping("/getAllNNN/{districtID}")
	   public ResponseEntity<List<NNN>> getAllNNN(@PathVariable("districtID") int districtID){
		   
		   List<NNN>NNN=NNNRepo.findByDistrict(districtID);
		   return ResponseEntity.ok(NNN);
		   
	   }
	   
	 
	
}
