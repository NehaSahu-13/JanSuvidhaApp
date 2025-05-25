package com.appbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.appbackend.Service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;
    
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
    	
        return config.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//          http.csrf().disable()
//            .authorizeHttpRequests(auth -> auth
//            	.requestMatchers("/login").permitAll() 
//                .requestMatchers("/citizen/**").hasAuthority("CITIZEN")
//                .requestMatchers("/officer/**").hasAuthority("OFFICER") 
//                .requestMatchers("/admin/**").hasAuthority("ADMIN") 
//                
//                 .anyRequest().authenticated()) 
//            .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//            .authenticationProvider(authenticationProvider())
//            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//
//        return http.build();

    	// correct code
    // 	 http
    //      .csrf(csrf -> csrf.disable())  
    //     //  .cors(cors->cors.disable())
    //      .authorizeHttpRequests(request -> request
    //          .requestMatchers("/citizen/**").hasAuthority("CITIZEN") 
    //          .requestMatchers("/officer/**").hasAuthority("OFFICER") 
    //          .requestMatchers("/admin/**").hasAuthority("ADMIN") 
    //          .requestMatchers("/**").permitAll()  
    //          .anyRequest().authenticated()  
    //      )
         
    //      .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) 
    //      .authenticationProvider(authenticationProvider()) 
    //   .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class); 

    //  return http.build();


      http
        .csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration configuration = new CorsConfiguration();
            configuration.setAllowedOrigins(java.util.List.of("*")); // Your frontend origin
            configuration.setAllowedMethods(java.util.List.of("POST", "GET", "OPTIONS", "DELETE", "PUT"));
            configuration.setAllowedHeaders(java.util.List.of("*"));
            configuration.setAllowCredentials(true);
            return configuration;
        }))
        .authorizeHttpRequests(request -> request
            .requestMatchers("/citizen/**").hasAuthority("CITIZEN")
            .requestMatchers("/officer/**").hasAuthority("OFFICER")
            .requestMatchers("/admin/**").hasAuthority("ADMIN")
            .requestMatchers("/**").permitAll()
            .anyRequest().authenticated()
        )
        .sessionManagement(sess -> sess.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
        .authenticationProvider(authenticationProvider())
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

   
        return http.build();	


    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
    	
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder());
        return provider;
        
    }
}

