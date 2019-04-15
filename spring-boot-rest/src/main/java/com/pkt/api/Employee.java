package com.pkt.api;

public class Employee {
	String username;
	String email;
	String password;
	int usergroup;

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

	public int getUsergroup() {
		return usergroup;
	}

	public void setUsergroup(int usergroup) {
		this.usergroup = usergroup;
	}

	public Employee(String username, String email, String password, int usergroup) {
		super();
		this.username = username;
		this.email = email;
		this.password = password;
		this.usergroup = usergroup;
	}

	public Employee() {
	};

}
