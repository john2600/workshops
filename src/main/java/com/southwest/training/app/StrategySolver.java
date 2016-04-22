package com.southwest.training.app;

public class StrategySolver {
	private String status;
	private String message;
	
	public StrategySolver(){
		
	}
	public StrategySolver(String status, String message) {
		
		this.status = status;
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
