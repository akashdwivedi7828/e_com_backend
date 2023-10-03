
	
	package com.edu.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

	import com.edu.dao.Seller;
	import com.edu.repository.SellerRepository;

	@Service
	public class SellerServiceImpl implements SellerService {
		
		@Autowired
		public SellerRepository sellerRepository;
		
		@Override
		 public void signup(Seller seller) {
		        // Encrypt the seller's password before saving it
		        seller.setSellerpassword(seller.getSellerpassword());
		        sellerRepository.save(seller);
		    }
			@Override
		    public Seller login(String sellermailid, String password) {
		        Seller seller = sellerRepository.findBySellermailid(sellermailid);

		        if (seller != null && password.equals(seller.getSellerpassword()) ) {
		            return seller;
		        }

		        return null;
		    }
			@Override
			public Seller addSeller(Seller seller) {
				
				return sellerRepository.save(seller);
			}

			@Override
			public List<Seller> getAllSeller() {
				// TODO Auto-generated method stub
				return sellerRepository.findAll();
			}
			
		

	}
	


