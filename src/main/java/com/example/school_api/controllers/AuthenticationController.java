package com.example.school_api.controllers;

import com.example.school_api.domain.User;
import com.example.school_api.dtos.DadosTokenJwt;
import com.example.school_api.dtos.authenticationData;
import com.example.school_api.services.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DadosTokenJwt> makeLogin(@RequestBody @Valid authenticationData dados){
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(),dados.password());
        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        String tokenJwt = tokenService.generateToken((User) authentication.getPrincipal());
        return ResponseEntity.ok(new DadosTokenJwt(tokenJwt));
    }


}
