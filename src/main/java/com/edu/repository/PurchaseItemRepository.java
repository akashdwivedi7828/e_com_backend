package com.edu.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.dao.Product;
import com.edu.dao.PurchaseItem;


@Repository
public interface PurchaseItemRepository extends JpaRepository<PurchaseItem , Integer> {
	@Modifying
	@Query(value="update product set noofproduct = ?2 where productid=?1", nativeQuery=true)
	public void updateProductQuantity(Integer productid, int quantity);

}