package com.example.school_api.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.cors(cors -> cors.disable()).csrf(csrf->csrf.disable())
                .sessionManagement(sm-> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(req->{
                    req.requestMatchers(HttpMethod.POST,"/login","/users/create").permitAll();
                    req.requestMatchers("/v3/api-docs/**","/swagger-ui.html" ,"/swagger-ui/**").permitAll();
                    req.requestMatchers(HttpMethod.POST,"/administration","/classroom","/general","/professor","/grade","/report","/subject","/student").hasRole("ADMIN");
                    req.requestMatchers(HttpMethod.PUT,"/administration","/classroom","/general","/professor","/grade","/report","/subject","/student").hasRole("ADMIN");
                    req.requestMatchers(HttpMethod.DELETE,"/administration","/classroom","/general","/professor","/grade","/report","/subject","/student").hasRole("ADMIN");
                    req.anyRequest().authenticated();
                }).addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class).build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }

}
