package com.example.entity;

public class MUser {
	private final String userId;
	private final String password;
	private final String userName;
	
	public MUser(String userId, String password, String userName) {
		this.userId = userId;
		this.password = password;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public String getPassword() {
		return password;
	}

	public String getUserName() {
		return userName;
	}
}
