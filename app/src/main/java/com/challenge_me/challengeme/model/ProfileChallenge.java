package com.challenge_me.challengeme.model;

public class ProfileChallenge {

	private String heading;
	private String desc;
	private String image;

	public ProfileChallenge(String heading, String desc, String image) {
		this.heading = heading;
		this.desc = desc;
		this.image = image;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
}
