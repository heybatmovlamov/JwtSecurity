package com.example.securityjwt.controller;

import com.example.securityjwt.entity.AuthRequest;
import com.example.securityjwt.repository.UserRepository;
import com.example.securityjwt.sevice.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @GetMapping("/")
    public String helloJwt(){
        return "Hello JWT";
    }

    @PostMapping("/authenticate")
    public String generateToken(@RequestBody AuthRequest authRequest)throws  Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword())
            );
        }catch (Exception exception){
        throw  new Exception("invalid name or password");
        }
        return jwtService.generateToken(authRequest.getUsername());
    }
}
