package com.edu.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import com.edu.dao.Product;
import com.edu.error.GlobalException;
import com.edu.service.ProductService;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
public class ProductController {
       
	   @Autowired
	   public ProductService productService;
	   
//	
//	@postMapping
//	//by path var seller id
//	addProductBySellerId(@requestBody Product product, sellerId){
//		productRepo.save(product);
//	
//}
	   @GetMapping("/getAllProducts")
//		List<Product> getAllProducts(){
//			return productService.getAllProducts();
//			
//		}
	   public ResponseEntity<?> getAllProducts() {
		    try {
		        List<Product> products = productService.getAllProducts();
		        if (!products.isEmpty()) {
		            System.out.println("sohit@123--------- " + products);
		            return new ResponseEntity<>(products, HttpStatus.OK);
		        } else {
		            return new ResponseEntity<>("No products found", HttpStatus.BAD_REQUEST);
		        }
		    } catch (Exception e) {
		        String errorMessage = "Error fetching products: " + e.getMessage();
		        System.out.println(errorMessage);
		        return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}

	   
	   @PostMapping("/addProduct/{sellerId}/{categoryid}")   
	    public ResponseEntity<Product> addProduct(@RequestBody Product product , @PathVariable("sellerId") Integer sellerId, @PathVariable("categoryid") Integer categoryid ) {
	        System.out.println("add product "+sellerId);
	        System.out.println(sellerId);
	        
	        
			Product products = productService.addProduct(product , sellerId, categoryid);

//		   productService.addProduct(product , sellerId);
	        return new ResponseEntity<Product>(products, HttpStatus.CREATED);
	    }
	   
	   @GetMapping("/getProductBySellerId/{sellerid}")
		
		public List<Product> findByDepartmetname(@PathVariable("sellerid") Integer sellerid) throws GlobalException
		{
			return productService.getProductBySellerId(sellerid);
			
		}
	   
	   @GetMapping("/searchByProductNameOrId/{search}/{searchField}")
		public List<Product> searchByProductNameOrId(@PathVariable("search") String search, @PathVariable("searchField") String searchField) throws GlobalException
		{
			return productService.searchByProductNameOrId(search, searchField);
			
		}

	   
	   @PutMapping("/updateProductById/{productid}")//http://localhost:8991/updateDepartmentById/5
		public Product updateProductById(@PathVariable("productid") Integer productid,@RequestBody Product product) throws GlobalException
		{
			System.out.println("controller");
			return productService.updateProductById(productid,product);
			
		}
	   
	   @DeleteMapping("/deleteProductById/{productid}")//http://localhost:8991/deleteDepartmentById/3
		ResponseEntity<String> deleteDepartmentById(@PathVariable("productid") Integer productid) throws GlobalException {
		   return productService.deleteProductById(productid);
			
		}
}

