package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import utils.ExtentManager;
import utils.GetScreenShot;
import utils.Utils;

import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;

/**
 * Created 
 *
 * Test base class
 */

public  class TestBase {
	
    public static ExtentReports reports;
    public static ExtentTest test;
    public static AndroidDriver<MobileElement> appiumDriver;

    @BeforeSuite(alwaysRun = true)
    protected void setUp() throws MalformedURLException {
        System.err.println("Before Suite:");
        appiumDriver = Utils.createAndroidDriver();
        reports=new ExtentManager().getInstance();
    
    }

    
   
    

    public AndroidDriver<MobileElement> getDriver()
    {

        return  appiumDriver;
    }

    @AfterSuite(alwaysRun = true)
    protected void tearDown(){

        appiumDriver.quit();
    
    }
    
    @BeforeTest()
    public void extentSetup()
    {
    	
    }
    
    @BeforeMethod
    public void register(Method method)
    {
    	
    	ExtentManager.htmlReporter.setAppendExisting(true);
    	System.err.println("Before Method Opening App");
    	appiumDriver.launchApp();
    	String testname=method.getName();
    	test=reports.createTest(testname);
    	   	
    }
    
    @AfterMethod
    public void captureStatus(ITestResult result) throws IOException
    {
    	
    	
    	if(result.getStatus()==ITestResult.SUCCESS)
    	{
    		test.log(Status.PASS,"The Test Method Named as "+result.getName()+ "is Passed");
    		String screenShotPath = GetScreenShot.capture(appiumDriver, result.getName());
    		System.err.println("screenShotPath:"+screenShotPath);
            test.log(Status.PASS, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
    	}
    	else if(result.getStatus()==ITestResult.FAILURE)
    		{
    		test.log(Status.FAIL,"The Test Method Named as "+result.getName()+ "is failed");
    		test.log(Status.FAIL, "Test Failure" + result.getThrowable());
    		String screenShotPath = GetScreenShot.capture(appiumDriver, result.getName());
    		System.err.println("screenShotPath:"+screenShotPath);
            test.log(Status.FAIL, "Snapshot below: " + test.addScreenCaptureFromPath(screenShotPath));
    		}
    	else if(result.getStatus()==ITestResult.SKIP)
    	{
    		test.log(Status.SKIP,"The Test Method Named as "+result.getName()+ "is SKIPPED");
    	}
    	
    
    	reports.flush();
    	System.err.println("After Method closing app");
    	appiumDriver.closeApp();
    }
    
    @AfterTest
    public void cleanUp()
    {
    	
    }
    
   
}


