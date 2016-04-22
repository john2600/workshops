package com.southwest.training.app;

public class UnKnowRequestStrategy extends AbstractResponseTypeStrategy {
	StrategyResult result;

	public UnKnowRequestStrategy() {
		super();
	}

	public UnKnowRequestStrategy(StrategyResult result) {
		this.result = result;

	}

	public UnKnowRequestStrategy(String status, String message) {
		super(status, message);
	}

	public void setDescriptionMessage(String message) {
		result.setResponseDescription("WRONG REQUEST  " + message);

	}

	@Override
	public StrategyResult decode() {
		return result.decodificar();
	}

}