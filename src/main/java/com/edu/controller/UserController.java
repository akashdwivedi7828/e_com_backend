package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.User;
import com.edu.service.UserService;

@RestController
//@CrossOrigin(origins = "http://localhost:56121")
public class UserController {
	
	@Autowired
	public UserService userService;
	
	 @PostMapping("/signupUser")
	    public ResponseEntity<?> signupUser(@Valid @RequestBody User user, BindingResult bindingResult) {
	        if (bindingResult.hasErrors()) {
	        	CustomResponse<Object> errorResponse = new CustomResponse<>();
		        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
		        errorResponse.setData(bindingResult.getAllErrors());
		        return ResponseEntity.badRequest().body(errorResponse);
	        }
	        
	        userService.signupUser(user);
	        CustomResponse<User> successResponse = new CustomResponse<>();
		    successResponse.setStatusCode(HttpStatus.OK.value());
		    successResponse.setData(user);

		    return ResponseEntity.ok(successResponse);
	    }

	    @PostMapping("/loginUser")
	    public ResponseEntity<?> loginUser(@RequestBody User user) {
	    	
//	        if (bindingResult.hasErrors()) {
//	            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
//	        }
	        
	        User authenticatedUser = userService.loginUser(user.getUsermailid(), user.getUserpassword());
	        System.out.println("akash12345 ");
	        if (authenticatedUser != null) {
	        	 CustomResponse<User> successResponse = new CustomResponse<>();
		     	    successResponse.setStatusCode(HttpStatus.OK.value());
		     	    successResponse.setData(authenticatedUser);
		     	   return ResponseEntity.ok(successResponse);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	
	
	
	
	@PostMapping("/addUser") //  http://localhost:8909/addUser
	public User addUser(@RequestBody User user) {
		return userService.addUser(user);
		
	}
	
	@GetMapping("/getAllUser")   //  http://localhost:8909/getAllUser
	public List<User> getAllUser(){
		return userService.getAllUser();
	}

}
