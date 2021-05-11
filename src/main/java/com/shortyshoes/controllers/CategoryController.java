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

import com.shortyshoes.models.Category;
import com.shortyshoes.repositories.CategoryRepository;
import com.shortyshoes.templates.CategoryRequestTemplate;

@RestController
@RequestMapping("/api/categories")
@CrossOrigin("*")
public class CategoryController {

	/** The category repository. */
	@Autowired
	private CategoryRepository categoryRepository;

	/**
	 * Gets all categories.
	 *
	 */
	@GetMapping(value = "/all")
	public List<Category> getAll() {
		return categoryRepository.findAll();
	}
	/**
	 * Gets category.
	 *
	 */
	@GetMapping(value = "/get")
	public Category get(@RequestParam("id") int id) {
		return categoryRepository.findById(id).get();
	}
	/**
	 * Persist category.
	 *
	 */
	@PostMapping(value = "/add")
	public List<Category> persist(@RequestBody CategoryRequestTemplate categoryToAdd) {
		
	
		Category category = new Category();
		category.setName(categoryToAdd.getName());
		category.setPicture("na");
		
		categoryRepository.save(category);
		return categoryRepository.findAll();
	}
	/**
	 * Delete category.
	 *
	 */
	@DeleteMapping(value = "/delete")
	public List<Category> delete(@PathVariable int id) {
		categoryRepository.deleteById(id);
		return categoryRepository.findAll();
	}
	/**
	 * Put category.
	 *
	 */
	@PutMapping(value = "/put/{id}")
	public List<Category> put(@PathVariable int id, @RequestBody Category category) {
		if (categoryRepository.existsById(id)) {
			categoryRepository.deleteById(id);
			categoryRepository.save(category);
		}
		
		return categoryRepository.findAll();
	}
}

