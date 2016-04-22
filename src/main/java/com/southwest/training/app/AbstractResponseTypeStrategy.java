package com.southwest.training.app;

public class AbstractResponseTypeStrategy implements ResponseStrategy {
	private String message;
	private String status;

	public AbstractResponseTypeStrategy() {

	}

	public AbstractResponseTypeStrategy(String status, String message) {
		this.message = message;
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setDescriptionMessage(String message) {
		this.message = message;
	}

	public StrategyResult decode() {
		return null;
	}

}
