package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static String reportName;
	public static String screenShotDir;
	 public static String reportLocation ;
	
	public static ExtentReports getInstance(){
		
		if(extent==null){
			
			Date d = new Date();
			File folder = new File(getOutputFolder());
	        folder.mkdirs();
			reportName= "AutomationReport_"+d.toString().replace(":", "_").replace(" ", "_") + ".html";
			extent = new ExtentReports();
		//	htmlReporter=new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"\\Reports\\"+reportName));
			htmlReporter=new ExtentHtmlReporter(reportLocation+"\\"+reportName);
			htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/Extent-Config.xml"));
			extent.setSystemInfo("Platform", "Android");
			extent.setSystemInfo("ExecutedBy", "Shiva Oleti");
			extent.setSystemInfo("Email", "oletishiva@gmail.com");
			extent.setSystemInfo("Mobile", "9849586161");
			extent.setSystemInfo("APK Version", "3.x");
			extent.attachReporter(htmlReporter);
		}
		
		return extent;
		
	}
	
	 protected static String getOutputFolder() {
		 reportLocation=System.getProperty("user.dir")+"\\Reports\\"+generateTimeStampString();
	        return reportLocation;
	    }
	 
	 public static String generateTimeStampString() {

	        Date today = Calendar.getInstance().getTime();
	        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
	        String timestampStr = formatter.format(today);
	        return timestampStr;
	    }

}
