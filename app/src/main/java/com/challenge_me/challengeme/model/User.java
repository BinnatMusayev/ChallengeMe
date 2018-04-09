package com.challenge_me.challengeme.model;

import android.support.annotation.NonNull;

public class User implements Comparable<User> {

	private int user_id;
	private String username,password, firstname, surname, profile_photo, desc;
	private int ranking;

	public User(int user_id) {
		this.user_id = user_id;
		//butun data webserverden gelecek
	}

	//just in case
	public User(int user_id, String username, String password, String firstname, String surname, String profile_photo, String desc, int ranking) {
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.surname = surname;
		this.profile_photo = profile_photo;
		this.desc = desc;
		this.ranking = ranking;
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

	public int getRanking() {
		return ranking;
	}

	public void setRanking(int ranking) {
		this.ranking = ranking;
	}

	@Override
	public int compareTo(@NonNull User o) {
		if (this.getRanking() < o.getRanking())
			return 1;
		else return -1;
	}
}
