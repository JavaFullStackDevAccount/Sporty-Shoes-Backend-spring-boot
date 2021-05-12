package com.shortyshoes.controllers;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortyshoes.models.Product;
import com.shortyshoes.models.ShoppingCart;
import com.shortyshoes.models.SportyShoesUserDetails;
import com.shortyshoes.repositories.ProductRepository;
import com.shortyshoes.repositories.ShoppingCartRepository;
import com.shortyshoes.repositories.SportyShoesUserDetailsRepository;
import com.shortyshoes.templates.AddToCartTemplate;

@RestController
@RequestMapping("/api/cart")
@CrossOrigin("*")
public class ShoppingCartController {

	@Autowired
	ShoppingCartRepository shoppingCartRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SportyShoesUserDetailsRepository sportyShoesUserDetailsRepository;

	@GetMapping("/test/add")
	public void addCartItems() {

		SportyShoesUserDetails user = this.sportyShoesUserDetailsRepository.findById(8).get();

		Product product = this.productRepository.findById(2).get();

		Product product2 = this.productRepository.findById(3).get();

		Set<Product> productSet = new HashSet<Product>();

		productSet.add(product2);

		productSet.add(product);

		ShoppingCart cart = new ShoppingCart();

		cart.setProductDetails(productSet);

		cart.setId(user.getId());

		shoppingCartRepository.save(cart);
	}

	@PostMapping("/add")
	public ShoppingCart addToCart(@RequestBody AddToCartTemplate addToCartTemplate) {

		try {

			ShoppingCart cart = new ShoppingCart();

			cart.setId(addToCartTemplate.getCartId());

			Set<Product> existingProductsInCart = this.getCartItems(addToCartTemplate.getCartId()).getProductDetails();

			if (existingProductsInCart == null || existingProductsInCart.size() == 0) {

				Set<Product> freshProductInCart = new HashSet<Product>();

				freshProductInCart.add(this.productRepository.findById(addToCartTemplate.getProductId()).get());

				cart.setProductDetails(freshProductInCart);

			} else {

				existingProductsInCart.add(this.productRepository.findById(addToCartTemplate.getProductId()).get());

				cart.setProductDetails(existingProductsInCart);
			}

			this.shoppingCartRepository.save(cart);

			return cart;

		} catch (Exception e) {

			return null;

		}

	}

	@GetMapping("/get")
	public ShoppingCart getCartItems(@RequestParam("id") int userId) {

		try {

			System.out.println("Got user id for cart as -> " + userId);

			ShoppingCart existingCart = shoppingCartRepository.findById(userId).get();

			existingCart.setSportyShoesUserDetails(null);

			return existingCart;

		} catch (Exception e) {

			return null;

		}

	}

}

/**
 * drop TABLE category; drop TABLE product; drop TABLE hibernate_sequence; drop
 * TABLE sporty_shoes_user_details;
 */
