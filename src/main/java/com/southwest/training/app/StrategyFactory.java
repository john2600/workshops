package com.southwest.training.app;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.southwest.training.util.Utilitary;

public class StrategyFactory {

	StrategyResult messageDecode;
	ResponseStrategy responseStrategy;
	ApplicationContext context = new ClassPathXmlApplicationContext(Utilitary.fileSpringXml);

	public StrategyResult getService(StrategySolver strategySolver) throws Exception {
		try {
			if (strategySolver == null) {
				throw new Exception();
			} else if (strategySolver.getStatus().equals(Utilitary.statusMessage)) {
				responseStrategy = (ResponseStrategy) context.getBean(Utilitary.beanCompleteStrategy);
			} else if (strategySolver.getStatus().equals(Utilitary.SERVER_ERROR)
					|| Utilitary.stablishResponse(strategySolver.getMessage())) {
				responseStrategy = (ResponseStrategy) context.getBean(Utilitary.BeanBadRequestStrategy);
			} else if (StringUtils.substringBefore(strategySolver.getMessage(), "\n").contains("Errors")) {
				responseStrategy = (ResponseStrategy) context.getBean("bunisessExceptionStrategy");
				responseStrategy.setDescriptionMessage(strategySolver.getMessage());
			} else {
				responseStrategy = (ResponseStrategy) context.getBean("unknowExceptionStrategy");
			}
		} catch (Exception err) {
			throw new Exception();
		}

		return messageDecode = responseStrategy.decode();
	}

}
