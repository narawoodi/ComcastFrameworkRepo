package practice.test;

import org.testng.Reporter;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class ReporterMessagesDisplay 
{
	@BeforeSuite
	public void BS()
	{
		System.out.println("execute BS");
		Reporter.log("executing");
	}
	@Test
	public void BS1()
	{
		System.out.println("execute BS1");
		Reporter.log("executing1");
	}

}
