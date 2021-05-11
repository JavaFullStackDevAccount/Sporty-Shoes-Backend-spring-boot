package com.shortyshoes.templates;

import com.sun.istack.NotNull;

public class AuthenticationRequestTemplate {
	
	@NotNull
	private String email;
	
	@NotNull
	private String password;

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

	@Override
	public String toString() {
		return "AuthenticationRequestTemplate [email=" + email + ", password=" + password + "]";
	}
	
	
	

}