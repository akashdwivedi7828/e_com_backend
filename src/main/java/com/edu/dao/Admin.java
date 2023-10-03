package com.edu.dao;

import javax.persistence.Entity;


public class Admin {
	
    private Integer adminid;
    private String adminname;
    
    private String adminmail;
    private String adminphone;
	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Admin(Integer adminid, String adminname, String adminmail, String adminphone) {
		super();
		this.adminid = adminid;
		this.adminname = adminname;
		this.adminmail = adminmail;
		this.adminphone = adminphone;
	}
	public Integer getAdminid() {
		return adminid;
	}
	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminmail() {
		return adminmail;
	}
	public void setAdminmail(String adminmail) {
		this.adminmail = adminmail;
	}
	public String getAdminphone() {
		return adminphone;
	}
	public void setAdminphone(String adminphone) {
		this.adminphone = adminphone;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", adminmail=" + adminmail + ", adminphone="
				+ adminphone + "]";
	}

   
    
}
