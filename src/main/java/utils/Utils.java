package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Utils {
	private static int APPIUM_SERVER_PORT;
	private static String APK_PATH;
	private static String AUTOMATION_NAME;
	private static String PLATFORM_NAME;
	private static String DEVICE_NAME;
	private static Properties prop = new Properties();
    private static String loadAndroidPropertyFile = "og_android.properties";

	private static void loadConfigProp(String propertyFileName) throws IOException {
		System.err.println("shiva Oleti-oletishiva@gmail.com "+System.getProperty("user.dir"));
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/" + propertyFileName);
		prop.load(fis);
		APPIUM_SERVER_PORT = Integer.parseInt(prop.getProperty("appium.server.port"));
		APK_PATH = prop.getProperty("application.app");
		DEVICE_NAME = prop.getProperty("device.name");
		AUTOMATION_NAME = prop.getProperty("AutomationName");
		PLATFORM_NAME = prop.getProperty("platform.name");
	}
	
	private static DesiredCapabilities setCapabilities() throws IOException {
	    loadConfigProp(loadAndroidPropertyFile);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, AUTOMATION_NAME);
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME,PLATFORM_NAME);
		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,DEVICE_NAME);
		//capabilities.setCapability(MobileCapabilityType.APP, APK_PATH);

		//ToDo - Move to properties file
		capabilities.setCapability("newCommandTimeout", 200);
		capabilities.setCapability("skipUnlock", true);
		capabilities.setCapability("appPackage", "de.komoot.android");
		capabilities.setCapability("appActivity", "de.komoot.android.app.InspirationActivity");
		return capabilities;
	}
	
	public static AndroidDriver<MobileElement> createAndroidDriver() throws MalformedURLException {
        AndroidDriver<MobileElement> driver = null;
        try {
            DesiredCapabilities dc = setCapabilities();
            URL serverURl = new URL("http://0.0.0.0:" + APPIUM_SERVER_PORT + "/wd/hub");
            driver = new AndroidDriver<MobileElement>(serverURl, dc);
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        } catch (IOException e) {
            e.printStackTrace();
        }
		return driver;
	}
}

