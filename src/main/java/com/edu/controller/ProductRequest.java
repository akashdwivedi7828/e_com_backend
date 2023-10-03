package com.edu.controller;

import org.springframework.web.multipart.MultipartFile;

public class ProductRequest {
    private String productname;
    private float productprice;
    private String productdetail;
    private int noofproduct;
    private MultipartFile productimage;
	public ProductRequest(String productname, float productprice, String productdetail, int noofproduct,
			MultipartFile productimage) {
		super();
		this.productname = productname;
		this.productprice = productprice;
		this.productdetail = productdetail;
		this.noofproduct = noofproduct;
		this.productimage = productimage;
	}
	public ProductRequest() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public float getProductprice() {
		return productprice;
	}
	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}
	public String getProductdetail() {
		return productdetail;
	}
	public void setProductdetail(String productdetail) {
		this.productdetail = productdetail;
	}
	public int getNoofproduct() {
		return noofproduct;
	}
	public void setNoofproduct(int noofproduct) {
		this.noofproduct = noofproduct;
	}
	public MultipartFile getProductimage() {
		return productimage;
	}
	public void setProductimage(MultipartFile productimage) {
		this.productimage = productimage;
	}

    
    // Getter and setter methods for the fields
}
