package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.edu.dao.Category;
import com.edu.dao.Product;
import com.edu.dao.Seller;
import com.edu.error.GlobalException;
import com.edu.repository.CategoryRepository;
import com.edu.repository.ProductRepository;
import com.edu.repository.SellerRepository;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    public ProductRepository productRepository;
    
    @Autowired
    public SellerRepository sellerRepository;
	
    @Autowired
    public CategoryRepository categoryRepository;
   
    
    
	@Override
	public Product addProduct(Product product, Integer sellerid, Integer categoryid) {
		Seller seller = sellerRepository.findById(sellerid)
	            .orElseThrow(() -> new IllegalArgumentException("Seller not found with id: " + sellerid));

	    // Associate the Seller with the Product
		
		Category category = categoryRepository.findById(categoryid).orElse(null); // Retrieve the category
		System.out.println("@@@@----------- "+category.getCategoryid());
		if (category != null) {
		    product.setCategory(category);
		}
		System.out.println(seller);
	    product.setSeller(seller);

	    return productRepository.save(product);
	}





	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		
		return productRepository.findAll();
	}

	@Override
	public Product getProductById(Integer productid) throws GlobalException {
		// TODO Auto-generated method stub
		Optional<Product> pr = productRepository.findById(productid);
		Product productob = null;
		if(!pr.isPresent()) {
			throw new GlobalException("Product is not found");
		}
		productob =  productRepository.findById(productid).get();
		return productob;
	}

	@Override
	public ResponseEntity<String>  deleteProductById(Integer productid) throws GlobalException {
		Optional<Product> pr = productRepository.findById(productid);
		Product productob = null;
		if(!pr.isPresent()) {
			throw new GlobalException("Product is not found");
		}
	productRepository.deleteById(productid);
	 return ResponseEntity.status(HttpStatus.OK).body("Record is Deleted");
	}


	@Override
	public String deleteAllProducts() {
		// TODO Auto-generated method stub
		productRepository.deleteAll();
		return "All Products Are Deleted" ;
	}
    
	@Override
	public List<Product> getProductBySellerId(Integer sellerid) throws GlobalException {
		
		List<Product> products =  productRepository.getProductBySellerId(sellerid);
		
		if(products.isEmpty() ) {
			throw new GlobalException("No products found for seller with ID " + sellerid);
		}
		
		return products;
		
	}
	@Override
	public Product updateProductById(Integer productid, Product product) throws GlobalException {
		Optional<Product> prod=productRepository.findById(productid);
		Product product1=null;
	       if(!prod.isPresent()) {
	    	   throw new GlobalException("Product with id "+productid+" not found");
	       }
	       product1=productRepository.findById(productid).get();
	      if(product1!=null) {
	    	  product1.setProductname(product.getProductname());
	    	  product1.setProductdetail(product.getProductdetail());
	    	  product1.setProductprice(product.getProductprice());
	    	  productRepository.save(product1);
	      }
			return product1;
	}





	@Override
	public List<Product> searchByProductNameOrId(String search , String searchField) throws GlobalException {
		// TODO Auto-generated method stub
		productRepository.searchByProductNameOrId(search, searchField);
		return null;
	}
	
}
