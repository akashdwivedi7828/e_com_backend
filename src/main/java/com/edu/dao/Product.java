package com.edu.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer productid;
	
	@Column(nullable = false , length = 50)
	@NotBlank(message = " Enter the Product name ")
	private String productname;
	
	@Column
	@NotNull
	private float productprice;
	
	@Column(nullable = false)
	@NotBlank
	private String productdetail;
	
	@Column(nullable = false)
	private int noofproduct;
	
	@Lob // This annotation is used for large objects, like images
    private String productimage; // Byte array to store the image data
	
	
	public String getProductimage() {
		return productimage;
	}

	public void setProductimage(String productimage) {
		this.productimage = productimage;
	}

	@ManyToOne
    @JoinColumn(name = "sellerid")
    private Seller seller;
	
	@ManyToOne
    @JoinColumn(name = "categoryid")
    private Category category;
	
	@OneToMany(mappedBy = "product", cascade= CascadeType.ALL)
	public List<PurchaseItem> purchaseitem;
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<PurchaseItem> getPurchaseitem() {
		return purchaseitem;
	}

	public void setPurchaseitem(List<PurchaseItem> purchaseitem) {
		this.purchaseitem = purchaseitem;
	}
	
	
	public Seller getSeller() {
		return seller;
	}

	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productname, float productprice, String productdetail, 
			int noofproduct) {
		super();
		this.productname = productname;
		this.productprice = productprice;
		this.productdetail = productdetail;
		
		this.noofproduct = noofproduct;
	}

	public Integer getProductid() {
		return productid;
	}

	public void setProductid(Integer productid) {
		this.productid = productid;
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

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + ", productprice=" + productprice
				+ ", productdetail=" + productdetail + ", productreview=" + ", noofproduct="
				+ noofproduct + "]";
	}
	
	

}
