package com.southwest.training.app;

import com.southwest.training.util.Utilitary;

public class BunisessExceptionStrategy extends AbstractResponseTypeStrategy {
	
	StrategyResult result;

	public BunisessExceptionStrategy() {
		super();
	}

	public BunisessExceptionStrategy(StrategyResult result) {
		super();
		this.result = result;
	}

	public BunisessExceptionStrategy(String status, String message) {
		super(status, message);
	}

	public void setDescriptionMessage(String message) {
		try {
			int points = message.indexOf(":");
			int comma = message.indexOf(",");
			if (points > comma) {
				result.setResponseDescription(message.substring(comma, points));
			} else if (points < comma) {
				result.setResponseDescription(message.substring(points, comma));
			} else {
				result.setResponseDescription(message);
			}
		} catch (Exception err) {
			result.setResponseDescription(Utilitary.errorUnkown+" "+err.toString());
		}
	}

	@Override
	public StrategyResult decode() {
		return result.decodificar();

	}

}
