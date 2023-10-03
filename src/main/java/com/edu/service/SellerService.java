package com.edu.service;

import java.util.List;

import javax.validation.Valid;

import com.edu.dao.Seller;

public interface SellerService {

		public Seller addSeller(Seller seller);
		public void signup(Seller seller);
		public Seller login(String sellermailid, String password);
		public List<Seller> getAllSeller();

	}


