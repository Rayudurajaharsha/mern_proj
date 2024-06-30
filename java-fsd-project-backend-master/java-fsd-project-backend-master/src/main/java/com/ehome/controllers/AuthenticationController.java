package com.ehome.controllers;


import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.ehome.entities.User;
import com.ehome.payload.LoginUserDto;
import com.ehome.payload.RegisterUserDto;
import com.ehome.responses.CustomResponse;
import com.ehome.responses.LoginResponse;
import com.ehome.services.AuthenticationService;
import com.ehome.services.JwtService;

@RequestMapping("/api/auth")
@RestController
public class AuthenticationController {
    private final JwtService jwtService;
    private final AuthenticationService authenticationService;

    public AuthenticationController(JwtService jwtService, AuthenticationService authenticationService) {
        this.jwtService = jwtService;
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup")
    public ResponseEntity<CustomResponse> register(@RequestBody RegisterUserDto registerUserDto) {
    	boolean result = authenticationService.emailExists(registerUserDto.getEmail());
    	if(result)
    	{
    		CustomResponse  response = new CustomResponse(false,200,"user already registred");
			return ResponseEntity.ok().body(response);
    	}
    	else
    	{
        User registeredUser = authenticationService.signup(registerUserDto);
		CustomResponse response = new CustomResponse(true,200,"user registred successfully!!!");
		return ResponseEntity.ok().body(response);
    	}
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> authenticate(@RequestBody LoginUserDto loginUserDto) {
        User authenticatedUser = authenticationService.authenticate(loginUserDto);

        String jwtToken = jwtService.generateToken(authenticatedUser);
        
       String userName = authenticatedUser.getFullName();
        
         Integer userid = authenticatedUser.getId();
        LoginResponse loginResponse = new LoginResponse().setToken(jwtToken).setExpiresIn(jwtService.getExpirationTime()).
        		setUserid(userid).setUsername(userName);
        
        return ResponseEntity.ok(loginResponse);
    }
}