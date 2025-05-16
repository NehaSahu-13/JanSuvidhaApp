package com.appbackend.Controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.appbackend.DTO.AuthRequset;
import com.appbackend.DTO.AuthResponse;
import com.appbackend.Entities.Block;
import com.appbackend.Entities.District;
import com.appbackend.Entities.NNN;
import com.appbackend.Entities.Panchayat;
import com.appbackend.Repository.BlockRepository;
import com.appbackend.Repository.DistrictRepository;
import com.appbackend.Repository.NNNRepository;
import com.appbackend.Repository.PanchayatRepository;
import com.appbackend.Service.CustomUserDetailsService;
import com.appbackend.Service.CustomUserPrincipal;
import com.appbackend.Util.JwtUtil;


@RestController
@RequestMapping("/public")
@CrossOrigin(origins = "*")
public class AuthController {
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil  jwtUtil;


      @Autowired
    private DistrictRepository disRepo;
    
    @PostMapping("/district")
    public ResponseEntity<?> addDistrict(@RequestParam("district_ID") int disID,@RequestParam("state_ID") int stateId,@RequestParam("distEng") String distEng,@RequestParam("disHin") String disHin,@RequestParam("abbr") String abbr){
    	
    	District district=new District();
    	district.setAbbreviation(abbr);
    	district.setDistrict_ID(disID);
    	district.setDistrict_Name_Eng(distEng);
    	district.setDistrict_Name_Hindi(disHin);
    	district.setState_ID(stateId);
    	
    	disRepo.save(district);
    	
    	return ResponseEntity.ok(district);
    	
    	
    }




    @Autowired
    private BlockRepository BlockRepo;
    
    @PostMapping("/block")
    public ResponseEntity<?> addBlock(@RequestParam("district_ID") int disID,@RequestParam("state_ID") int stateId,@RequestParam("Eng") String Eng,@RequestParam("Hindi") String Hindi,@RequestParam("blockid") int blockid){
    
    	Block block=new Block();
    	block.setBlock_ID(blockid);
    	block.setBlock_Name_Eng(Eng);
    	block.setBlock_Name_Hindi(Hindi);
    	block.setState_ID(stateId);
    	District dis=disRepo.findById(disID).get();
    	block.setDistrict(dis);
    	dis.getBlocks().add(block);
    	disRepo.save(dis);
    	
    	return ResponseEntity.ok("Block added successfully");
    
    }
    
    
    @Autowired
    private NNNRepository NNNRepo;
    
    @PostMapping("/NNN")
    public ResponseEntity<?> addNNN(@RequestBody NNN obj){
    	
    	NNNRepo.save(obj);
    	
    	return ResponseEntity.ok("NNN added successfully");
    }
    
    
     @Autowired
    private PanchayatRepository panchayatRepo;
    
    @PostMapping("/panchayat")
    public ResponseEntity<?> addPanchayat(@RequestParam("panchayatID") int panchayatID,@RequestParam("district_ID") int disID,@RequestParam("state_ID") int stateId,@RequestParam("Eng") String Eng,@RequestParam("Hindi") String Hindi,@RequestParam("blockid") int blockid){
    
    	Panchayat panch=new Panchayat();
    	panch.setPanchayat_ID(panchayatID);
    	panch.setPanchayat_Name_Eng(Eng);
    	panch.setPanchayat_Name_Hindi(Hindi);
    	panch.setState_ID(stateId);
    	Block block=BlockRepo.findById(blockid).get();
        panch.setBlock(block);
        block.getPanchayat().add(panch);
        District dis=disRepo.findById(disID).get();      
        panch.setDistrict(dis);
        dis.getPanchayat().add(panch);
        
        disRepo.save(dis);
        panchayatRepo.save(panch);
        
        return ResponseEntity.ok("Panchayat added successfully");
    	
    }

    



    
 
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequset request) {
    	
    	   System.out.println(request.getId()+" "+request.getPassword());
    	try {
            // Authenticate using id (as a string for Spring Security)
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(String.valueOf(request.getId()), request.getPassword())
            );
         

            // Load user details
            UserDetails userDetails = userDetailsService.loadUserByUsername(String.valueOf(request.getId()));
            CustomUserPrincipal user = (CustomUserPrincipal) userDetails;

            // Generate JWT token
            String token = jwtUtil.generateToken(user.getId(), user.getRole());
            
            // Return token and role
            return ResponseEntity.ok(new AuthResponse(token, user.getRole()));
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            return new ResponseEntity<>(new AuthResponse(), HttpStatus.BAD_REQUEST);
        }
       
        
    }
}

