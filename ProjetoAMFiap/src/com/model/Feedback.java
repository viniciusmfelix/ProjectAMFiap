package com.model;

public class Feedback {
	private int jo_code;
	private String feedback_message;
	
	public Feedback(int jo_code, String feedback_message) {
		super();
		this.jo_code = jo_code;
		this.feedback_message = feedback_message;
	}

	public int getJo_code() {
		return jo_code;
	}

	public void setJo_code(int jo_code) {
		this.jo_code = jo_code;
	}

	public String getFeedback_message() {
		return feedback_message;
	}

	public void setFeedback_message(String feedback_message) {
		this.feedback_message = feedback_message;
	}
	
}
