package com.shortyshoes.templates;

public class CredentialsUpdateRequestTemplate {

	
	private int id;
		
	private String newPassword;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	@Override
	public String toString() {
		return "CredentialsUpdateRequestTemplate [id=" + id + ", newPassword=" + newPassword + "]";
	}
	
	
	
	
	
}
