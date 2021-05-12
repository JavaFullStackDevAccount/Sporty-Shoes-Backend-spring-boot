package com.shortyshoes.models;

import javax.persistence.*;
import java.util.*;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@OneToOne
	private SportyShoesUserDetails sportyShoesUserDetails;

	@OneToOne
	private Product products;

	private Date purchaseDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public SportyShoesUserDetails getSportyShoesUserDetails() {
		return sportyShoesUserDetails;
	}

	public void setSportyShoesUserDetails(SportyShoesUserDetails sportyShoesUserDetails) {
		this.sportyShoesUserDetails = sportyShoesUserDetails;
	}

	public Product getProducts() {
		return products;
	}

	public void setProducts(Product products) {
		this.products = products;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", sportyShoesUserDetails=" + sportyShoesUserDetails + ", products=" + products
				+ ", purchaseDate=" + purchaseDate + "]";
	}

}
