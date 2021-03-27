package com.example.springblog.blogapp.Controller;

import com.example.springblog.blogapp.Service.Authservice;
import com.example.springblog.blogapp.dto.LoginRequest;
import com.example.springblog.blogapp.dto.RegisterRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    
    @Autowired
    private Authservice authservice;

    @PostMapping("/signup")
    public ResponseEntity signUp(@RequestBody RegisterRequest registerRequest){
        authservice.signUp(registerRequest);
        return new ResponseEntity(HttpStatus.OK);
    }
    @PostMapping("/login")
    public String login(@RequestBody LoginRequest loginRequest){
       return authservice.login(loginRequest);
    }
    

}
