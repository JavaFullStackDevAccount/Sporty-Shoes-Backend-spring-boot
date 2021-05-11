package com.shortyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Product {

	/** ID */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true, nullable = false)
	private Integer id;

	/** Name */
	@Column(name = "name", nullable = false)
	private String name;

	/** Description */
	@Column(name = "description")
	private String description;

	/** Weight */
	/** Price. */
	@Column(name = "price", nullable = false)
	private double price;

	/** Picture 1 */
	@Column(name = "picture1")
	private String picture1;


	/** Category */
	@ManyToOne
	private Category category;

	
	/**
	 * Empty Constructor.
	 */
	public Product() {
	}


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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getPicture1() {
		return picture1;
	}


	public void setPicture1(String picture1) {
		this.picture1 = picture1;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price
				+ ", picture1=" + picture1 + ", category=" + category + "]";
	}

	/**
	 * Instantiates a new product.
	 *
	 */
	
}
