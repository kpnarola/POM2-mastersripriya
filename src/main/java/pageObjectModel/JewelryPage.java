package pageObjectModel;

import org.openqa.selenium.By;
import org.testng.Assert;

public class JewelryPage extends Utils {
    LoadProp load= new LoadProp();


    /*-----------------------------Locator---------------------------------------------------*/

    By jewelry=By.linkText("Jewelry");
    By vintageStyleEngagementRing=By.xpath("//div/a[@href=\"/vintage-style-engagement-ring\"]");
    By emailaFreind=(By.xpath("//div/div[3]/input[@type=\"button\"]"));
    By friendEmail=By.id("FriendEmail");
    By yourEmailAddress=By.id("YourEmailAddress");
    By pesonalMessage=By.id("PersonalMessage");
    By sendEmail=By.xpath("//div/input[@type=\"submit\"]");
    By actualMessgae=By.xpath("//div[@class=\"message-error validation-summary-errors\"]/ul/li");
/*---------------------------------------------------------------------------------------------*/

    public void unRegisteredUser() {

        String expectedValue="Only registered customers can use email a friend feature";

        //Click on Jewelry
        click_Element(jewelry);

        //Click on Vintage Style Engagement Ring
        click_Element(vintageStyleEngagementRing);

        //Click on Email a Friend
        click_Element(emailaFreind);

        //Enter friends email
        enter_Element(friendEmail,load.getProperty("friendEmail"));
        //Enter Your email
        enter_Element(yourEmailAddress, load.getProperty("yourEmailAddress"));

        //Enter Personal Messgae
        enter_Element(pesonalMessage, load.getProperty("pesonalMessage"));

        //click on Send email
        click_Element(sendEmail);

        //Comparing  Actual message with Expected message
        assertEquals(actualMessgae,expectedValue  );


    }
}
