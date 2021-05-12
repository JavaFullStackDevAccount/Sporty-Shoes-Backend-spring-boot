package com.shortyshoes.templates;

import java.util.List;


public class OrdersRequestTemplate {
	
	private int userId;
	
	private List<Integer> productsPurchaseByUser;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Integer> getProductsPurchaseByUser() {
		return productsPurchaseByUser;
	}

	public void setProductsPurchaseByUser(List<Integer> productsPurchaseByUser) {
		this.productsPurchaseByUser = productsPurchaseByUser;
	}

	@Override
	public String toString() {
		return "OrdersRequestTemplate [userId=" + userId + ", productsPurchaseByUser=" + productsPurchaseByUser + "]";
	}

	

}
