package com.edu.dao;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userid;
	
	@Column(nullable = false , length = 50)
	@NotBlank(message = " Enter the User name ")
	private String username;
	
	@Column(nullable = false , length = 50 , unique = true)
	@NotBlank(message = " Enter the Mail Id ")
	private String usermailid;
	
	@Column(nullable = false)
	@NotBlank(message = " Enter the Password ")
	private String userpassword;
	
	@Column(nullable = false , unique = true)
	@NotNull(message = " Enter the Phone Number ")
	private String phonenumber;
	
	@Column(nullable = false)
	@NotNull(message = " Enter the Address ")
	private String useraddress;

	@OneToMany(mappedBy = "user", cascade= CascadeType.ALL)
//	@JoinColumn(name = "purchaseid")
	public List<PurchaseItem> purchaseitem;
	public List<PurchaseItem> getPurchaseitem() {
		return purchaseitem;
	}

	public void setPurchaseitem(List<PurchaseItem> purchaseitem) {
		this.purchaseitem = purchaseitem;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String username, String usermailid, String userpassword, String phonenumber, String useraddress) {
		super();
		this.username = username;
		this.usermailid = usermailid;
		this.userpassword = userpassword;
		this.phonenumber = phonenumber;
		this.useraddress = useraddress;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUsermailid() {
		return usermailid;
	}

	public void setUsermailid(String usermailid) {
		this.usermailid = usermailid;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getUseraddress() {
		return useraddress;
	}

	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}

	@Override
	public String toString() {
		return "User [userid=" + userid + ", username=" + username + ", usermailid=" + usermailid + ", userpassword="
				+ userpassword + ", phonenumber=" + phonenumber + ", useraddress=" + useraddress + "]";
	}

}
