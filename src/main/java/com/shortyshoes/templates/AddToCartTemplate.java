package com.shortyshoes.templates;

public class AddToCartTemplate {
	
	private int cartId;
	
	private int productId;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	@Override
	public String toString() {
		return "AddToCartTemplate [cartId=" + cartId + ", productId=" + productId + "]";
	}
	
	

}
