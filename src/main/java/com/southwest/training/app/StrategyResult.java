package com.southwest.training.app;


public class StrategyResult implements IStrategyResult{
	private String responseType;
	private String responseDescription;

	public String getResponseType() {
		return responseType;
	}

	public void setResponseType(String responseType) {
		this.responseType = responseType;
	}

	public String getResponseDescription() {
		return responseDescription;
	}


	public void setResponseDescription(String responseDescription) {
		this.responseDescription = responseDescription;
	}

	public StrategyResult decodificar() {
		return this;
	}

	@Override
	public String toString() {
		return "StrategyResult [responseType=" + responseType + ", responseDescription=" + responseDescription + "]";
	}
	
	
	
	

}
