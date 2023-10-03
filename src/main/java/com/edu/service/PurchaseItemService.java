package com.edu.service;

import com.edu.dao.Product;
import com.edu.dao.PurchaseItem;
import com.edu.dao.User;

public interface PurchaseItemService {
    
	
	public PurchaseItem addProductToUserPurchase(User user, Product product, int quantity, double totalPrice);
	public void updateProductQuantity(Integer productid, int quantity);
}