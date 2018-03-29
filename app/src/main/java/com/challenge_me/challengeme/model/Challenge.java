package com.challenge_me.challengeme.model;

import java.util.Date;

public class Challenge {

	private int challenge_id, creator_id, challenger_id;
	private Date start_time, end_time;
	private String creator_photo, challenger_photo;
	private User creator, challenger;

	public Challenge(int challenge_id) {
		this.challenge_id = challenge_id;
		//butun data webserverden gelecek
	}

	//just in case
	public Challenge(int challenge_id, int creator_id, int challenger_id, Date start_time, Date end_time,
					 String creator_photo, String challenger_photo, User creator, User challenger) {
		this.challenge_id = challenge_id;
		this.creator_id = creator_id;
		this.challenger_id = challenger_id;
		this.start_time = start_time;
		this.end_time = end_time;
		this.creator_photo = creator_photo;
		this.challenger_photo = challenger_photo;
		this.creator = creator;
		this.challenger = challenger;
	}

	public int getChallenge_id() { return challenge_id;}

	public void setChallenge_id(int challenge_id) {
		this.challenge_id = challenge_id;
	}

	public int getCreator_id() {
		return creator_id;
	}

	public void setCreator_id(int creator_id) {
		this.creator_id = creator_id;
	}

	public int getChallenger_id() {
		return challenger_id;
	}

	public void setChallenger_id(int challenger_id) {
		this.challenger_id = challenger_id;
	}

	public Date getStart_time() {
		return start_time;
	}

	public void setStart_time(Date start_time) {
		this.start_time = start_time;
	}

	public Date getEnd_time() {
		return end_time;
	}

	public void setEnd_time(Date end_time) {
		this.end_time = end_time;
	}

	public String getCreator_photo() {
		return creator_photo;
	}

	public void setCreator_photo(String creator_photo) {
		this.creator_photo = creator_photo;
	}

	public String getChallenger_photo() {
		return challenger_photo;
	}

	public void setChallenger_photo(String challenger_photo) {
		this.challenger_photo = challenger_photo;
	}

	//user stuff


	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public User getChallenger() {
		return challenger;
	}

	public void setChallenger(User challenger) {
		this.challenger = challenger;
	}
}
