package com.appbackend.Controller;

import org.apache.commons.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import com.appbackend.DTO.AuthRequset;
import com.appbackend.DTO.AuthResponse;
import com.appbackend.Service.CustomUserDetailsService;
import com.appbackend.Service.CustomUserPrincipal;
import com.appbackend.Util.JwtUtil;

@RestController
public class AuthController {
	
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private JwtUtil  jwtUtil;
    
 
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

