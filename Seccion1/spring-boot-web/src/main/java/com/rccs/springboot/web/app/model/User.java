package com.rccs.springboot.web.app.model;

public class User {
	private String name;
	private String lastName;
	private String mail;

	public User() {
	}

	public User(String name, String lastName, String mail) {
		this.name = name;
		this.lastName = lastName;
		this.mail = mail;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

}
