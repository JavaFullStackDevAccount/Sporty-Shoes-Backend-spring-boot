package com.shortyshoes.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shortyshoes.models.Product;
import com.shortyshoes.repositories.ProductRepository;

@RestController
@RequestMapping("/api/products")
@CrossOrigin("*")
public class ProductController {

	/** The product repository. */
	@Autowired
	private ProductRepository productRepository;

	/**
	 * Gets all products.
	 *
	 */
	@GetMapping(value = "/all")
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	/**
	 * Gets product.
	 *
	 */
	@GetMapping(value = "/get")
	public Product get(@RequestParam("id") int id) {
		return productRepository.findById(id).get();
	}
	/**
	 * Persist product.
	 *
	 */
	@PostMapping(value = "/add")
	public List<Product> persist(@RequestBody Product product) {
		
		System.out.println(product);
		productRepository.save(product);
		return productRepository.findAll();
	}
	/**
	 * Delete product.
	 *
	 */
	@DeleteMapping(value = "/delete")
	public List<Product> delete(@RequestParam int id) {
		productRepository.deleteById(id);
		return productRepository.findAll();
	}
	/**
	 * Put product.
	 */
	@PutMapping(value = "/put/{id}")
	public List<Product> put(@PathVariable int id, @RequestBody Product product) {
		if (productRepository.existsById(id)) {
			
			product.setId(id);
			
			//Product existingProduct = productRepository.findById(id).get();
			
//			existingProduct.setCategory(product.getCategory());
//			
//			existingProduct.setDescription(product.getDescription());
//			
//			existingProduct.setName(product.getName());
//			
//			existingProduct.setPicture1(product.getPicture1());
//			
			//productRepository.deleteById(id);
			productRepository.save(product);
		}
		
		return productRepository.findAll();
	}
}

