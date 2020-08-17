package com.cos.logtest.controller;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.logtest.model.User;

@RestController
public class IndexController {
	
	@GetMapping({"","/"})
	public String index() {
		return "<h1>IndexPage입니다.</h1>";
	}
	
	@PostMapping("/user")
	public ResponseEntity<?> user(@Valid @RequestBody User user, BindingResult bindingResult) {
		
	
		
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}
}
