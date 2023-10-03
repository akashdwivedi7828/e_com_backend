package com.edu.dao;

import java.sql.Date;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class PurchaseItem {
    
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer purchaseid;
	
	@Column
	private double purchaseitemprice;
	
	@JsonIgnore
	@ManyToOne
    @JoinColumn(name = "userid")
    private User user;
    
	
	 
	@JsonIgnore
    @ManyToOne
    @JoinColumn(name = "productid")
    private Product product;
	

    private Integer purchaseQuantity;
	public Integer getPurchaseQuantity() {
		return purchaseQuantity;
	}


	public void setPurchaseQuantity(Integer purchaseQuantity) {
		this.purchaseQuantity = purchaseQuantity;
	}


	public PurchaseItem() {
		super();
		// TODO Auto-generated constructor stub
	}


	public PurchaseItem(double purchaseitemprice, User user, Product product) {
		super();
		this.purchaseitemprice = purchaseitemprice;
		this.user = user;
		this.product = product;
	}


	public Integer getPurchaseid() {
		return purchaseid;
	}


	public void setPurchaseid(Integer purchaseid) {
		this.purchaseid = purchaseid;
	}


	public double getPurchaseitemprice() {
		return purchaseitemprice;
	}


	public void setPurchaseitemprice(double purchaseitemprice) {
		this.purchaseitemprice = purchaseitemprice;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	@Override
	public String toString() {
		return "PurchaseItem [purchaseid=" + purchaseid + ", purchaseitemprice=" + purchaseitemprice + ", user=" + user
				+ ", product=" + product + "]";
	}
 
}
