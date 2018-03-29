package com.challenge_me.challengeme.model;

public class User {

	private int user_id;
	private String username,password, firstname, surname, profile_photo, desc;

	public User(int user_id) {
		this.user_id = user_id;
		//butun data webserverden gelecek
	}

	//just in case
	public User(int user_id, String username, String password, String firstname, String surname, String profile_photo, String desc) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.surname = surname;
		this.profile_photo = profile_photo;
		this.desc = desc;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getProfile_photo() {
		return profile_photo;
	}

	public void setProfile_photo(String profile_photo) {
		this.profile_photo = profile_photo;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
