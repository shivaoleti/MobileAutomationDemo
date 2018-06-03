package pages;

import core.BasePage;

import core.TestBase;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import pageObjects.HomePageObjects;
import com.aventstack.extentreports.Status;



import java.util.Arrays;
import java.util.List;

public class HomePage extends TestBase {


    

    HomePageObjects homepageObjects;
    public HomePage(AndroidDriver<?> appiumDriver){
    	super();
       	homepageObjects=new HomePageObjects(appiumDriver);
    }
   
  

    public MobileElement getHomePageLogo()

	 {
		return homepageObjects.home_KomootLogo;
	 
	 }
    
    public MobileElement getHomePageText()

	 {
		return homepageObjects.home_logoText;
	 
	 }
    
    public MobileElement getFaceBookFragment()

	 {
		return homepageObjects.home_FaceBookBtn;
	 
	 }
    
    public MobileElement getFaceBookLogo()

	 {
		return homepageObjects.home_FaceBookLogo;
	 
	 }
    
    public MobileElement getFaceBookText()

	 {
		return homepageObjects.home_FaceBookLogoText;
	 
	 }
    
    
    public MobileElement getEmailFragment()

	 {
		return homepageObjects.home_emailBtn;
	 
	 }
    
    public MobileElement getEmailLogo()

	 {
		return homepageObjects.home_emailBtnImage;
	 
	 }
    
    public MobileElement getEmailText()

	 {
		return homepageObjects.home_emailLogoText;
	 
	 }
    
    public MobileElement getTermsAndConditions()

	 {
		return homepageObjects.home_TermsAndConditions;
	 
	 }
  
   
    public void verifyLogosInHomePage()
    {
    	BasePage base=new BasePage(new TestBase().getDriver());
    	base.verifyElementPresent(getHomePageLogo());
    	base.verifyElementPresent(getFaceBookLogo());
    	base.verifyElementPresent(getEmailLogo());
    }
    
    public void verifyTermsAndConditonsText()
    {
    	
    	if(getTermsAndConditions().getText().equalsIgnoreCase("Log in to explore the great outdoors and discover special places"))
        	test.log(Status.PASS, getTermsAndConditions().getText());
        else
        	test.log(Status.FAIL, "Expected:Log in to explore the great outdoors and discover special places"+"\t But Found: "+getTermsAndConditions().getText());
    }
    
    public void verifyLoginwithFaceBook()
    {
    	String clickable=getFaceBookFragment().getAttribute("clickable");
    	if(clickable.equalsIgnoreCase("true"))
    		test.log(Status.PASS, "Face book Login Button is Clickable");
    	else
    		test.log(Status.PASS, "Face book Login Button is not Clickable");
    	
    	if(getFaceBookText().getText().equalsIgnoreCase("CONTINUE WITH FACEBOOK"))
        	test.log(Status.PASS, "Expected:CONTINUE WITH FACEBOOK"+"\t Found: "+getFaceBookText().getText());
        else
        	test.log(Status.FAIL, "Expected:CONTINUE WITH FACEBOOK"+"\t But Found: "+getFaceBookText().getText());
    	
    }
    
    
}
