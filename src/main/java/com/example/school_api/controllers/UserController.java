package com.example.school_api.controllers;

import com.example.school_api.domain.User;
import com.example.school_api.dtos.DataCreatUser;
import com.example.school_api.infra.exceptions.DuplicatedLoginException;
import com.example.school_api.services.UserService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    @Transactional
    public ResponseEntity<Void> createUser(@RequestBody DataCreatUser data, UriComponentsBuilder componentsBuilder) throws Exception {
        User user = userService.createUser(data);
        URI uri  = componentsBuilder.path("/user/create/{id}").buildAndExpand(user.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

}
