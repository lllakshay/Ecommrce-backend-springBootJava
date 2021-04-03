package com.app.security.payload.response;

public class MessageResponse {
	private String message;

	
	public MessageResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageResponse(String message) {
	    this.message = message;
	  }

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
