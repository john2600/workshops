package com.southwest.training.util;

import org.apache.commons.lang.StringUtils;

public class Utilitary {
	public final static String fileSpringXml = "applicationContext.xml";
	public final static String beanCompleteStrategy = "completeStrategy";
	public final static String BeanBadRequestStrategy = "badRequestStrategy";
	public final static String errorUnkown= "the message should contain ',' and ':'  ";
	
	public final static String statusMessage = "COMPLETE";
	public static final String ERROR_NOT_MESSAGE = "Could not send Message.";
	public static final String SERVER_ERROR = "EX_ERROR";

	public static boolean stablishResponse(String pMessage) {
		String fline = StringUtils.substringBefore(pMessage, "\n");

		if (StringUtils.substringAfterLast(fline, ":").trim().equals(ERROR_NOT_MESSAGE)
				|| fline.trim().equals(ERROR_NOT_MESSAGE)) {
			return true;
		} else {
			return false;
		}

	}
}
