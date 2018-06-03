package tests;

import core.TestBase;
import org.testng.annotations.Test;
import pages.HomePage;

public class HomePageTests extends TestBase {



   @Test
    public void verifyHomePageItems()
    {

        HomePage h1=new HomePage(new TestBase().getDriver());
        h1.verifyLogosInHomePage();
        h1.verifyLoginwithFaceBook();
        h1.verifyTermsAndConditonsText();
       
    }

    






}
