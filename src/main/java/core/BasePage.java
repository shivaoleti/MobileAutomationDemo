package core;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import utils.Log4Test;

import java.util.HashMap;

/**
 * Created by 
 * <p>
 * General Page
 */
public class BasePage  extends TestBase{



    

    protected AndroidDriver driver;

    public BasePage(AndroidDriver driver){
        this.driver = driver;
    }

    /**
     * Press Back button on android device
     */
    public void pressBackButton() {
    	test.log(Status.INFO," Back Button Press");
        sendKeyEvent(Key.BACK_BUTTON);
    }

    /**
     * Press button from Key enum
     */
    public void pressButton(Key key) {
    
        test.log(Status.INFO,	key + "  Button Press");
        sendKeyEvent(key);
    }

    /**
     * Send key event method, for pressing android keys
     */
    public void sendKeyEvent(Key key) {
    	 test.log(Status.INFO,	key + "  Key Event Send to Driver");
        ((AndroidDriver) driver).pressKeyCode(key.getValue());
    }

    
    /**
     * Tap an element
     * @param element - element to tap
     */
    protected void tap(MobileElement element){
    	 test.log(Status.INFO,"Tapping On The Element Using Touch Action " + element.getText());
        new TouchAction(driver).tap(element).perform();
    }

    public static void scrollToElement(AndroidDriver driver, String elementName, boolean scrollDown) {
        String listID = ((RemoteWebElement) driver.findElementByAndroidUIAutomator("new UiSelector().className(\"android.widget.ListView\")")).getId();
        String direction;
        if (scrollDown) {
            direction = "down";
        } else {
            direction = "up";
        }
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", direction);
        scrollObject.put("element", listID);
        scrollObject.put("text", elementName);
        driver.executeScript("mobile: scrollTo", scrollObject);
    }

    public MobileElement scrollToElementByName(String elementName, String listId) {
        MobileElement element = (MobileElement) ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"" + listId + "\"))" +
                ".scrollIntoView(new UiSelector().text(\"" + elementName + "\"));");
        return element;
    }

public void waitSeconds(int sec)
{
    try
    {
        Thread.sleep(sec);
    }
    catch (Exception e)
    {

    }
}

    public void clickElementUsingBy(By ele)
    {
        waitForVisibilityOf(ele);
        test.log(Status.INFO,"Clicking On The Element " + driver.findElement(ele).getText());
        driver.findElement(ele).click();
    }
    public void clickButtonUsingFindBy(MobileElement element)
    {
    	test.log(Status.INFO,"Clicking On The Element " + element.getText());
    	element.click();
    }

    public void clear(MobileElement element)
    {
    	test.log(Status.INFO,"Clearing the data");
    	element.clear();
    }

    public void enterText(MobileElement element,String text)
    {
        element.sendKeys(text);
    }

    protected void waitForVisibilityOf(By mobileElement) {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(mobileElement));


    }

    public Boolean verifyElementPresent(MobileElement element)
    {
    	Boolean result=false;
        try
        {
            if(element.isDisplayed())
            {
	            test.log(Status.INFO,"<font color='green'>"+element.getText()+"</font>"+ "Is Present");
	            result=true;
            }
        }
        catch(Exception e)
        {
         
            test.log(Status.INFO," Element Is not Present");
            return false;
        }
		return result;
    }
    
    public Boolean verifyElementExists(MobileElement element,String text)
    {
    	Boolean result=false;
        try
        {
            if(element.isDisplayed())
            {  
            	test.log(Status.INFO,"<font color='green'>"+text +" :</font>"+ "Is Present");
            	result=true;
            }
        }
        catch(Exception e)
        {
         //   Reporter.log("<font color='red'>"+element+"</font>"+ "Is not Present" ,true);
            test.log(Status.INFO,"<font color='red'>"+text+" :</font>"+ "Is Not Present");
            return false;
        }
		return result;
    }

    public Boolean scrollAndVerifyElement(String elementName, String listId) {
        // appiumDriver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))").click();


        MobileElement element = (MobileElement) ((AndroidDriver) driver).findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()" +
                ".resourceId(\"" + listId + "\"))" +
                ".scrollIntoView(new UiSelector().text(\"" + elementName + "\"));");

      /*  MobileElement element = appiumDriver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().resourceId(\""+listId+"\")).getChildByText("
                        + "new UiSelector().className(\""+className+"\"), \""+elementName+"\")"));*/

        Boolean result=false;
        try
        {
            if(element.isDisplayed())
            {
            	test.log(Status.INFO,"<font color='green'>"+ elementName +" :</font>"+ "Is Present");
            	result=true;
            }
            	
        }
        catch (Exception e)
        {  
        	
        	test.log(Status.INFO,"<font color='red'>"+elementName+" :</font>"+ "Is Not Present");
             return false;
        	
        }


        return result;
    }

}
