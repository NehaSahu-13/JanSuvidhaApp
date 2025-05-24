package com.appbackend.Controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.appbackend.Service.CustomUserPrincipal;
import com.appbackend.Service.ErrorService;

import jakarta.servlet.http.HttpServletRequest;


@RestControllerAdvice
@CrossOrigin(origins = "*")
public class GlobalExceptionHandler {

    @Autowired
    private ErrorService errorService;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex, HttpServletRequest request) {

    	
    	Long userID = getCurrentUserId(); 
        if (userID == null) {
            userID = -1L; 
        }
     
        String error = ex.getMessage() != null ? ex.getMessage() : "Unknown error";
        String pageName = request.getRequestURI(); 
        String errorDetails = Arrays.toString(ex.getStackTrace()); 
         
        if (errorDetails != null && errorDetails.length() > 1000) {
            errorDetails = errorDetails.substring(0, 1000) + "... [truncated]";
        }
        
       
       errorService.addError(userID, error, pageName, errorDetails);

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                            .body("An error occurred...");
    }

    
    private Long getCurrentUserId() {
    	Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getPrincipal() instanceof CustomUserPrincipal) {
            CustomUserPrincipal userPrincipal = (CustomUserPrincipal) authentication.getPrincipal();
            return userPrincipal.getId();
        }
        System.out.println("No authenticated user found or principal is not CustomUserPrincipal.");
        return null;
    }
    
}

