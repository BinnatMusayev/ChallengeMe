package com.challenge_me.challengeme.model;

public class Notification {

	private int notification_id, notification_to, notification_from;
	private String notification_type;

	public Notification(int notification_id, int notification_to, int notification_from, String notification_type) {
		this.notification_id = notification_id;
		this.notification_to = notification_to;
		this.notification_from = notification_from;
		this.notification_type = notification_type;
	}

	public int getNotification_id() {
		return notification_id;
	}

	public void setNotification_id(int notification_id) {
		this.notification_id = notification_id;
	}

	public int getNotification_to() {
		return notification_to;
	}

	public void setNotification_to(int notification_to) {
		this.notification_to = notification_to;
	}

	public int getNotification_from() {
		return notification_from;
	}

	public void setNotification_from(int notification_from) {
		this.notification_from = notification_from;
	}

	public String getNotification_type() {
		return notification_type;
	}

	public void setNotification_type(String notification_type) {
		this.notification_type = notification_type;
	}
}
