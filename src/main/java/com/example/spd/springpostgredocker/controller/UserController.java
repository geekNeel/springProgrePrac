package com.example.spd.springpostgredocker.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/public")
public class UserController {
	
	 @GetMapping("/home")
	    public ResponseEntity<String> getHome() {
	        return ResponseEntity.ok("Home");
	    }
	 @GetMapping("/login")
	    public ResponseEntity<String> getauthenticate() {
	        return ResponseEntity.ok("Home");
	    }
	 @GetMapping("/register")
	    public ResponseEntity<String> getAuthorize() {
	        return ResponseEntity.ok("Home");
	    }

}
