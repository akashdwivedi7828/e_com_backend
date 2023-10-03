package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.edu.dao.Seller;
import com.edu.error.GlobalException;
import com.edu.service.SellerService;

@RestController
@CrossOrigin(origins = "http://localhost:56121")
public class SellerController {
	
	@Autowired
	public SellerService sellerService;
	

	@PostMapping("/signup")
	public ResponseEntity<?> signup(@Valid @RequestBody Seller seller, BindingResult bindingResult) {
	    System.out.println("signup");
	    if (bindingResult.hasErrors()) {
	        CustomResponse<Object> errorResponse = new CustomResponse<>();
	        errorResponse.setStatusCode(HttpStatus.BAD_REQUEST.value());
	        errorResponse.setData(bindingResult.getAllErrors());
	        return ResponseEntity.badRequest().body(errorResponse);
	    }

	    sellerService.signup(seller);

	    CustomResponse<Seller> successResponse = new CustomResponse<>();
	    successResponse.setStatusCode(HttpStatus.OK.value());
	    successResponse.setData(seller);

	    return ResponseEntity.ok(successResponse);
	}


	    @PostMapping("/login")
	    public ResponseEntity<?> login( @RequestBody Seller seller) {
	    	
//	        if (bindingResult.hasErrors()) {
//	            return ResponseEntity.badRequest().body(bindingResult.getAllErrors());
//	        }
	    	
	        Seller authenticatedSeller = sellerService.login(seller.getSellermailid(), seller.getSellerpassword());
	        System.out.println("seller@123 ");
	        System.out.println("login akash123 "+ authenticatedSeller);
	        if (authenticatedSeller != null) {
	        	
	        	 CustomResponse<Seller> successResponse = new CustomResponse<>();
	     	    successResponse.setStatusCode(HttpStatus.OK.value());
	     	    successResponse.setData(authenticatedSeller);
	     	   return ResponseEntity.ok(successResponse);
	        } else {
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
	        }
	    }
	
	

}