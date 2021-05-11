package com.shortyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class SportyShoesUserDetails {

	/** id */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(unique = true, nullable = false)
	private String username;

	/** email */
	@Column(unique = true, nullable = false)
	private String email;

	/** password */
	@Column(nullable = false)
	private String password;

	/** admin */
	private boolean isAdmin;

	/**
	 * Empty Constructor
	 */
	public SportyShoesUserDetails() {
	}

	/**
	 * Instantiates a new user.
	 *
	 */
	public SportyShoesUserDetails(String username, String email, String password, boolean isAdmin) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}
	
	/*
	 * Getters and Setters
	 */

	public String getUsername() {
		return username;
	}

	
	public void setUsername(String username) {
		this.username = username;
	}

	
	public String getEmail() {
		return email;
	}

	
	public void setEmail(String email) {
		this.email = email;
	}

	
	public String getPassword() {
		return password;
	}

	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean isAdmin() {
		return isAdmin;
	}
	

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "SportyShoesUserDetails [id=" + id + ", username=" + username + ", email=" + email + ", password="
				+ password + ", isAdmin=" + isAdmin + "]";
	}

	
	
}
