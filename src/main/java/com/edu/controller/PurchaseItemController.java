package com.edu.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Product;
import com.edu.dao.PurchaseItem;
import com.edu.dao.User;
import com.edu.error.GlobalException;
import com.edu.service.ProductService;
import com.edu.service.PurchaseItemService;
import com.edu.service.UserService;

@RestController
public class PurchaseItemController {
	
	
	    @Autowired
	    private PurchaseItemService purchaseItemService;
	    
	    @Autowired
	    private UserService userService;
	    
	    @Autowired
	    private ProductService productService;

	    @PostMapping("/addProductToUserPurchase")
	    public ResponseEntity<PurchaseItem> addProductToUserPurchase(
	    		@RequestBody AddProductToUserPurchaseRequest request
	    ) throws GlobalException {
	    	System.out.println("inside addProductToUserPurchase");
	        User user = userService.getUserByUserid(request.getUserid());
	        Product product = productService.getProductById(request.getProductid());
	     //   System.out.println(userid);
	     //   System.out.println(productid);
	        System.out.println("@@@@user---- "+user+" "+request.getUserid());
	        System.out.println("@@@@product---- "+product+" "+ request.getProductid());
	        System.out.println("@@@@quantity---- "+request.getQuantity());
	        System.out.println("@@@@price---- "+request.getTotalPrice());
	        if (user == null || product == null) {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	        
//	        if(product.getNoofproduct() < request.getQuantity()) {
//	        	
//	        }

	        PurchaseItem purchaseItem = purchaseItemService.addProductToUserPurchase(user, product, request.getQuantity(), request.getTotalPrice());
	        //emailservice.sendEMail("froma drss", user.getEmail)
	        //subjectm=, contrnt
	       
	        int quantity = product.getNoofproduct() - request.getQuantity();
	        purchaseItemService.updateProductQuantity(product.getProductid(), quantity);
	        return new ResponseEntity<>(purchaseItem, HttpStatus.CREATED);
	    }
           
	    
	}

