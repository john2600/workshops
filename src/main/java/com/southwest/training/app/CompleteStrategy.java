package com.southwest.training.app;

public class CompleteStrategy extends AbstractResponseTypeStrategy{

	StrategyResult result;
	
	public CompleteStrategy(){
		super();
	}
	public CompleteStrategy(StrategyResult result) {
		this.result = result;
	}
	
	public void setDescriptionMessage(String message) {
		this.setMessage(message);
	}

	@Override
	public StrategyResult decode() {
		return this.result;
	}

}
