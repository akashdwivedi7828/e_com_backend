package com.edu.dao;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer categoryid;
    
    private String categoryname;
    
    @JsonIgnore
    @OneToMany(mappedBy = "category")
    private List<Product> products;
    
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Category( String categoryname) {
		super();
		this.categoryname = categoryname;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Category(String categoryname, List<Product> products) {
		super();
		this.categoryname = categoryname;
		this.products = products;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
    
    
}
