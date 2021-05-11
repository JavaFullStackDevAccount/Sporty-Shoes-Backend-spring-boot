package com.shortyshoes.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Category {
	
/* Id of the category class */
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/* Name column  */
	@Column(name = "name", unique = true, nullable = false)
	private String name;

	/*  Picture url will be stored in this columns */
	@Column(name = "picture")
	private String picture;


	/* Relation with the product table */
	@OneToMany(mappedBy = "category")
	private List<Product> products;

	/* Empty constructor */
	
	public Category() {
	}

	/*
	 *  Constructor with the fields
	 */
	public Category(Integer id, String name, String picture, List<Category> children) {
		this.id = id;
		this.name = name;
		this.picture = picture;
	}

	/*
	 *  Getters and Setters function
	 */
	public Integer getId() {
		return id;
	}

	
	public void setId(Integer id) {
		this.id = id;
	}

	
	public String getName() {
		return name;
	}

	
	public void setName(String name) {
		this.name = name;
	}

	
	public String getPicture() {
		return picture;
	}

	
	public void setPicture(String picture) {
		this.picture = picture;
	}
}


