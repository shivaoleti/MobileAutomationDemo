package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

import java.util.Arrays;
import java.util.List;

import core.BasePageObject;

public class HomePageObjects extends BasePageObject {





    public HomePageObjects(AndroidDriver driver) {
		super(driver);
	}
   
    @AndroidFindBy(id = "de.komoot.android:id/jka_v2_logo_iv")
    public MobileElement home_KomootLogo;
    
    @AndroidFindBy(xpath="//android.widget.TextView[@text='Log in to explore the great outdoors and discover special places']")
    public MobileElement home_logoText;
    
	@AndroidFindBy(id ="de.komoot.android:id/jka_v2_proceed_with_facebook_fragment")
	public MobileElement home_FaceBookBtn;
	
	@AndroidFindBy(id ="de.komoot.android:id/imageview_btn_fb")
	public  MobileElement home_FaceBookLogo;
	
	@AndroidFindBy(id ="de.komoot.android:id/textview_fb_txt")
	public MobileElement home_FaceBookLogoText;
	
	
    @AndroidFindBy(id="de.komoot.android:id/jka_v2_proceed_with_email_fragment")
    public MobileElement home_emailBtn;
    
    @AndroidFindBy(id="de.komoot.android:id/imageview_btn_signup")
    public MobileElement home_emailBtnImage;

    @AndroidFindBy(id="de.komoot.android:id/textview_mail_register_txt")
    public MobileElement home_emailLogoText;
          

    @AndroidFindBy(id ="de.komoot.android:id/jka_v2_tos_text_ttv")
    public  MobileElement home_TermsAndConditions;

    
}
