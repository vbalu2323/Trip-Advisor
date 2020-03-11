package framework;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.LogManager;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.Markup;


public class configMethods {
	
	
	@BeforeSuite
	public void beforesuite(ITestContext ctx) {
		Data.suiteName=ctx.getCurrentXmlTest().getSuite().getName();
		Logs.initializelog();
		UtilityFiles.processtokill();
	}
	@AfterSuite
	public void aftersuite() {
		Logs.FinalizeReport();
	}
	@BeforeTest
	public void beforeTest(ITestContext ctx) {
		Data.testname=ctx.getCurrentXmlTest().getName();
	    Data.maintest=Data.reports.createTest(Data.testname);
	
	}
	@AfterTest
	public void afterTest() {

	}
	@BeforeMethod
	public void beforemethod(Method method) {
		Data.Methodname=method.getName();
		Data.test=Data.maintest.createNode(Data.Methodname);
	}
	@AfterMethod
	public void resultstatus(ITestResult results) {
		try {
		if(results.getStatus()==ITestResult.FAILURE) {
			Data.test.log(Data.status.FAIL, "this test case is failed" +results.getName());
			
				Data.test.log(Data.status.FAIL, "this test case is failed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityFiles.capturescreenshot(Data.Methodname)).build());
			
			
		}
			else if(results.getStatus()==ITestResult.SUCCESS) {
				Data.test.log(Data.status.PASS, "This test case is passed" +results.getName());
				Data.test.log(Data.status.PASS, "This test case is passed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityFiles.capturescreenshot(Data.Methodname)).build());
				
			}
			else if(results.getStatus()==ITestResult.SKIP) {
				Data.test.log(Data.status.SKIP, "This test case is skipped" +results.getName());
				Data.test.log(Data.status.SKIP, "This test case is passed" +results.getThrowable(),
						MediaEntityBuilder.createScreenCaptureFromPath(UtilityFiles.capturescreenshot(Data.Methodname)).build());
				
				
		}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
   
}
