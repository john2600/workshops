package com.southwest.training.app;



public class BadRequestStrategy  extends AbstractResponseTypeStrategy{
	StrategyResult result;
	
	
	public BadRequestStrategy() {
		super();
	}

	public BadRequestStrategy(StrategyResult result) {		
		this.result = result;
	}

	public BadRequestStrategy(String status, String message) {
		super(status, message);
	}

	@Override	
	public StrategyResult decode() {
		return result.decodificar();
	}

	

}