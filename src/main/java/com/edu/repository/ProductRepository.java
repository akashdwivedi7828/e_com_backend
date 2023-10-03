package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.edu.dao.Product;
import com.edu.error.GlobalException;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{

	@Query(value="select * from Product where sellerid=?1", nativeQuery=true)
	public List<Product> getProductBySellerId(Integer sellerid);
	
	@Query(value="select * from Product ", nativeQuery=true)
	public List<Product> findAll();
//	public Product updateProductById(Integer productid, Product product) throws GlobalException;
	
	 @Query("SELECT p FROM Product p WHERE " +
	           "(:searchField = 'productname' AND p.productname LIKE %:search%) OR " +
	           "(:searchField = 'productdetail' AND p.productdetail LIKE %:search%) OR " +
	           "(:searchField = 'categoryid' AND CAST(p.categoryid AS SIGNED) = :search)")
	    List<Product> searchByProductNameOrId( String search, String searchField);
	 
}
