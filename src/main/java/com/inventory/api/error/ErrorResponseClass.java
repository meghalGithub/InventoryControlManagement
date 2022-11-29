package com.inventory.api.error;

import java.util.Date;

public class ErrorResponseClass {

	private String message;
	private Date date;
	
	public ErrorResponseClass() {
	}
	
	public ErrorResponseClass(String message, Date date) {
		super();
		this.message = message;
		this.date = date;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}