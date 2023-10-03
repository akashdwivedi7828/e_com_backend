package com.edu.service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

import com.edu.dao.Product;
import com.edu.dao.PurchaseItem;
import com.edu.dao.User;
import com.edu.repository.ProductRepository;
import com.edu.repository.PurchaseItemRepository;
import com.edu.repository.SellerRepository;
import com.edu.repository.UserRepository;


@Service
public class PurchaseItemServiceImpl implements PurchaseItemService  {
	
	@Autowired
	public PurchaseItemRepository purchaseItemRepository;

	@Override
	public PurchaseItem addProductToUserPurchase(User user, Product product, int quantity, double totalPrice) {
		// TODO Auto-generated method stub
		PurchaseItem purchaseItem = new PurchaseItem();
        purchaseItem.setUser(user);
        purchaseItem.setProduct(product);
        purchaseItem.setPurchaseQuantity(quantity);
        // Calculate the total price based on the product's price and quantity
        purchaseItem.setPurchaseitemprice(totalPrice);

        // Save the purchase item to the database
        purchaseItemRepository.save(purchaseItem);
		
		return purchaseItemRepository.save(purchaseItem);
	}
	@Transactional
	@Override
	public void updateProductQuantity(Integer productid, int quantity) {
		// TODO Auto-generated method stub
		System.out.println("@@@updateProductQuantity--- "+productid+" "+quantity);
		purchaseItemRepository.updateProductQuantity(productid, quantity);
	}
	
}
