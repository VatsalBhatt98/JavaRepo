package com.lead.assignment.exception;

import java.util.List;

public class ErrorResponse {

    private String code;
    private String message;
	public String getCode() {
		return code;
	}
	public ErrorResponse(String code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

    // Constructors, getters, and setters
}