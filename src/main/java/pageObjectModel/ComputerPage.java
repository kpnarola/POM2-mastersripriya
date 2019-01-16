package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class ComputerPage extends Utils {

    /*------------------------Locators--------------------------------*/
    By computers=By.linkText("Computers");
    By noteBooks=By.linkText("Notebooks");
    By appleMacBookPro13=By.linkText("Apple MacBook Pro 13-inch");
    By addtoCartButton4=By.id("add-to-cart-button-4");
    By shoppingCart=By.xpath("//li[@id=\"topcartlink\"]/a");
    By selectCountry=By.id("CountryId");
    By postcode=By.id("ZipPostalCode");
    By checkOut=By.id("checkout");
    By actualValue = By.xpath("//div[@id=\"terms-of-service-warning-box\"]");
/*----------------------------------------------------------------------*/

    LoadProp load=new LoadProp();
    public  void acceptTermsAndConditions() {

    String expectedValue="Please accept the terms of service before the next step.";
        //click on Computers
        click_Element(computers);

        //click on Notebooks
        click_Element(noteBooks);

        // Click on Apple MacBook Pro 13-inch
        click_Element(appleMacBookPro13);

        //Click on Add to Cart
        click_Element(addtoCartButton4);

        //Click on Shopping Cart
        click_Element(shoppingCart);

        //Select Country
        select_Element_ByValue(selectCountry, (233));

        //Enter Postcode
        enter_Element(postcode, load.getProperty("postcode") );

        //Click on Checkout
        click_Element(checkOut);

    // String actual=   getTextonly(actualValue); //Get the Path for the message
       String actual_Value = getTextonly(actualValue);

        Assert.assertEquals( actual_Value, expectedValue); //Compare the Expected messgae with actual message

    }
}