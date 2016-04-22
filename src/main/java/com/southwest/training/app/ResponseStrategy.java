package com.southwest.training.app;

public interface ResponseStrategy {
	void setDescriptionMessage(String message);
	StrategyResult decode();
}
