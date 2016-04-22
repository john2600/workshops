package com.southwest.training.test;


import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeTest;
import com.southwest.training.app.StrategyFactory;
import com.southwest.training.app.StrategyResult;
import com.southwest.training.app.StrategySolver;
import com.southwest.training.util.Utilitary;


public class TestMainMessage {
	
	StrategySolver inputMessage2;
	StrategySolver inputMessage;
	StrategySolver inputMessage3;
	StrategySolver inputMessage4;
	StrategySolver inputMessage5;
	StrategySolver inputMessageNull=null;
	StrategySolver bussinesStrategy=null;
	StrategySolver unknowstatus=null;
	static StrategyFactory StrategyFactory=null;
	
	@BeforeMethod
	@BeforeTest
	public void setUp() {
		inputMessage = new StrategySolver("EX_ERROR",Utilitary.ERROR_NOT_MESSAGE);
		inputMessage3 = new StrategySolver(" ","ABCErrors,sB,l:aba,lba");
		inputMessage4 = new StrategySolver("MENSAJE ","Mensaje No Valido");
		inputMessage5 = new StrategySolver("COMPLETE","Mensaje No Valido");
		unknowstatus = new StrategySolver("BAD","BAD MESSAGE");
		StrategyFactory = new StrategyFactory();
	}
	@Test
	public void shouldSolverObjectBeNotNull() {
		AssertJUnit.assertNotNull(inputMessage);
	}
	
	@Test
	public void shouldReturnetStrategyResultWhenStrategyFactoryRecivedSolverInstace() throws Exception {
		AssertJUnit.assertTrue(StrategyFactory.getService(inputMessage) instanceof StrategyResult);
	}
	
	@Test
	public void shouldReturnSomeMessageWhenCompleteStratey() throws Exception{
		StrategyResult result = StrategyFactory.getService(inputMessage5);
		AssertJUnit.assertEquals(new String("SUCCESSFUL").toString(), result.getResponseType());
	}
	
	@Test
	public void shouldReturnSomeMessageWhenBadRequestStratey() throws Exception{
		AssertJUnit.assertEquals("SERVER_ERROR",StrategyFactory.getService(inputMessage).getResponseType());
	}
	
	@Test
	public void shouldReturnSomeMessageWhenBussinesRequestStratey() throws Exception{
		AssertJUnit.assertEquals("BUSINESS_ERROR",StrategyFactory.getService(inputMessage3).getResponseType());
	}
	
	@Test
	public void shouldReturnSomeMessageWhenStrateyUnknown() throws Exception{
		AssertJUnit.assertEquals("UNKNOWN",StrategyFactory.getService(unknowstatus).getResponseType());
	}
	
	@Test(expectedExceptions = Exception.class)
	public void shouldReturnExceptionWhenIsnull() throws Exception{
		AssertJUnit.assertNull(StrategyFactory.getService(null));
	}
	

}
