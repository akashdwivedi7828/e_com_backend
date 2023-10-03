package com.edu.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Seller {
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer sellerid;
	
	@Column(nullable = false , length = 50)
	@NotBlank(message = " Enter the Seller name ")
	private String sellername;
	
	@Column(nullable = false , length = 50 , unique = true)
	@NotBlank(message = " Enter the Seller Company name ")
	private String sellercompanyname;
	
	@Column(nullable = false , length = 10 , unique = true)
	@NotNull(message = " Enter the Phone number ")
	private Long sellerphonenumber;
	
	@Column(nullable = false , length = 50 , unique = true)
	@NotBlank(message = " Enter the Mail id ")
	private String sellermailid;
	
	@Column(nullable = false , length = 50)
	@NotBlank(message = " Enter the password ")
	private String sellerpassword;
	
	@Column(nullable = false , length = 50)
	@NotBlank(message = " Enter the Company address ")
	private String selleraddress;
	
	
	@OneToMany
	private List<Product> productList;
	//craeet getters and setters
	
   //@OneToMany(mappedBy = "seller")
   //private List<Product> products = new ArrayList<>();

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

	
	public Seller() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Seller(String sellername, String sellercompanyname, Long sellerphonenumber, String sellermailid,
			String sellerpassword, String selleraddress) {
		super();
		this.sellername = sellername;
		this.sellercompanyname = sellercompanyname;
		this.sellerphonenumber = sellerphonenumber;
		this.sellermailid = sellermailid;
		this.sellerpassword = sellerpassword;
		this.selleraddress = selleraddress;
	}

	public Integer getSellerid() {
		return sellerid;
	}

	public void setSellerid(Integer sellerid) {
		this.sellerid = sellerid;
	}

	public String getSellername() {
		return sellername;
	}

	public void setSellername(String sellername) {
		this.sellername = sellername;
	}

	public String getSellercompanyname() {
		return sellercompanyname;
	}

	public void setSellercompanyname(String sellercompanyname) {
		this.sellercompanyname = sellercompanyname;
	}

	public Long getSellerphonenumber() {
		return sellerphonenumber;
	}

	public void setSellerphonenumber(Long sellerphonenumber) {
		this.sellerphonenumber = sellerphonenumber;
	}

	public String getSellermailid() {
		return sellermailid;
	}

	public void setSellermailid(String sellermailid) {
		this.sellermailid = sellermailid;
	}

	public String getSellerpassword() {
		return sellerpassword;
	}

	public void setSellerpassword(String sellerpassword) {
		this.sellerpassword = sellerpassword;
	}

	public String getSelleraddress() {
		return selleraddress;
	}

	public void setSelleraddress(String selleraddress) {
		this.selleraddress = selleraddress;
	}

	@Override
	public String toString() {
		return "Seller [sellerid=" + sellerid + ", sellername=" + sellername + ", sellercompanyname="
				+ sellercompanyname + ", sellerphonenumber=" + sellerphonenumber + ", sellermailid=" + sellermailid
				+ ", sellerpassword=" + sellerpassword + ", selleraddress=" + selleraddress + "]";
	}
	

	
	
	
}
