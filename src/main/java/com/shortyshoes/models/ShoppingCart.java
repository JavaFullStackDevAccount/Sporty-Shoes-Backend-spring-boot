package com.shortyshoes.models;

import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class ShoppingCart {

	@Id
	private Integer id;

	@OneToOne
	@MapsId
	private SportyShoesUserDetails sportyShoesUserDetails;

	@ManyToMany
	private Set<Product> productDetails;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public SportyShoesUserDetails getSportyShoesUserDetails() {
		return sportyShoesUserDetails;
	}

	public void setSportyShoesUserDetails(SportyShoesUserDetails sportyShoesUserDetails) {
		this.sportyShoesUserDetails = sportyShoesUserDetails;
	}

	public Set<Product> getProductDetails() {
		return productDetails;
	}

	public void setProductDetails(Set<Product> productDetails) {
		this.productDetails = productDetails;
	}

	@Override
	public String toString() {
		return "ShoppingCart [id=" + id + ", sportyShoesUserDetails=" + sportyShoesUserDetails + ", productDetails="
				+ productDetails + "]";
	}

	
	
}
