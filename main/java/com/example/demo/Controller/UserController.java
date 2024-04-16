package com.example.demo.Controller;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.UserDetails;
import com.example.demo.service.UserService;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping(path = "/user")

public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(path = "/signup")
	public ResponseEntity<Map<String, String>> SignupUser(@Valid @RequestBody UserDetails userdata)  {

	    Map<String, String> createdUser;
	    try {
	        createdUser = userService.signupUser(userdata);
	    } catch (Exception e) {
	        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	    }
	    return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}
	@PostMapping(path="/login")
	public
	ResponseEntity<Map<String, String>> loginUser(@Valid @RequestBody  Map<String, String> body) {
		String email = body.get("email");
		String password = body.get("password");
		Map<String, String> loggedInUser;
		try {
			 loggedInUser = userService.loginUser(email, password);
 
		} catch (Exception e) {
			e.printStackTrace();
			
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return new ResponseEntity<>(loggedInUser, HttpStatus.CREATED);
	}
	
	
	
}