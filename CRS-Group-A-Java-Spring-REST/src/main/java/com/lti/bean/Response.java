package com.lti.bean;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class Response<T> extends ResponseEntity<T>{
	
	String message;
	
	public Response(T body, HttpStatus status, String message) {
		super(body, status);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		
		return super.toString()+" Response [message=" + message + "]";
	}	

}
