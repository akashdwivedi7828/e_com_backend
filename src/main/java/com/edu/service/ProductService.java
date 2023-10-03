package com.edu.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.edu.dao.Product;
import com.edu.error.GlobalException;

public interface ProductService {

	public Product addProduct(Product product, Integer sellerid, Integer categoryid);

	public List<Product> getAllProducts();
	public List<Product> searchByProductNameOrId(String search , String searchField)throws GlobalException;
	public Product getProductById(Integer productid) throws GlobalException;

	public ResponseEntity<String> deleteProductById(Integer productid) throws GlobalException;
	
	public List<Product> getProductBySellerId(Integer sellerid) throws GlobalException;
	public Product updateProductById(Integer productid, Product product) throws GlobalException;
	public String deleteAllProducts();

}
