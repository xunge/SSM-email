package com.xunge.springemp.pojo;

public class User {
	private String email;
	private String username;
	private String password;
	private Integer state;
	private String code;
	
	public String getEmail(){
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

	public User(){

	}

	public User(String userName, String email, String password, Integer state, String code) {
		this.username = userName;
		this.email = email;
		this.password = password;
		this.state = state;
		this.code = code;
	}
}
