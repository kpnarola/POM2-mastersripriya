package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Electronics extends Utils {

    LoginPage log =new LoginPage();
    LoadProp load=new LoadProp();
/*--------------------Locators--------------*/

By electronics=By.linkText("Electronics");
By cellphones=By.partialLinkText("Cell");
By hTCOneminiblue=By.partialLinkText("HTC One Mini");
By addToCartButton19=By.id("add-to-cart-button-19");
By shoppingCart=By.xpath("//li[@id=\"topcartlink\"]/a");
By termofservice=By.name("termsofservice");
By checkout=By.id("checkout");
By contin=By.xpath("//*[@id=\"billing-buttons-container\"]/input");
By shippingMethodContinue=By.xpath("//*[@class=\"button-1 shipping-method-next-step-button\"]");
By creditCard=By.xpath("//input[@id=\"paymentmethod_1\"]");
By paymentContinue=By.xpath("//input[@type='button'][@class=\"button-1 payment-method-next-step-button\"]");
By visa=By.xpath("//select[@id=\"CreditCardType\"]");
By cardholderName=By.id("CardholderName");
By creditCardNo=By.id("CardNumber");
By crditCardExpMonth=By.id("ExpireMonth");
By creditCardExpYear=By.id("ExpireYear");
By creditCardCode=By.id("CardCode");
By paymentInfoContinue=By.xpath("//input[@class=\"button-1 payment-info-next-step-button\"]");
By confirmationOrder=By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]");
By actualValue=By.xpath("//div[@class=\"section order-completed\"]/div/strong");
By orderProcCompleted=By.xpath("//input[@class=\"button-1 order-completed-continue-button\"]");
By logOut=By.linkText("Log out");

//--------------------------------------------------------------------
    public void registeredUserBuyProduct() {

        //calling user_Login method()
        log.user_Login();

        //click on Electronics
        click_Element(electronics);

        //click on cellphones
        click_Element(cellphones);

        //Click on HTC one mini blue
        click_Element(hTCOneminiblue);

        //click on Add to Cart
        click_Element(addToCartButton19);

        //.................1. Billing Address.................................
        //Click on shopping cart
        click_Element(shoppingCart);

        //if Terms of Service not Selected then

            //Click Check on Terms of Service
            click_Element(termofservice);

        //Click on check out
        click_Element(checkout);

        //Click on Continue
        click_Element(contin);

        //.......................2. Shipping Address...........................

     //   WebDriverWait wait = new WebDriverWait(driver, 30);
      //  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class=\"button-1 shipping-method-next-step-button\"]")));
//explicit_Wait(By.xpath("//*[@class=\"button-1 shipping-method-next-step-button\"]"), 30);
        //..................3. Shipping Method..............................

        //Click Continue
        click_Element(shippingMethodContinue);

        //...........................4. Payment Method..........................

        //WebDriverWait wait1 = new WebDriverWait(driver, 30);
        //wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id=\"paymentmethod_1\"]")));
     //   explicit_Wait(By.xpath("//input[@id=\"paymentmethod_1\"]"),30);
        //Click Credit Card
        click_Element(creditCard);
        click_Element(paymentContinue); //Click on Continue

//.................... 5. Payment information..............................

   //     WebDriverWait wait2 = new WebDriverWait(driver, 30);
    //    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id=\"CreditCardType\"]")));

   //     explicit_Wait(By.xpath("//select[@id=\"CreditCardType\"]"), 30);
        //Select Visa card
        select_Element_ByVisibleText(visa,("Visa"));

        //Enter the cardholder name
        enter_Element(cardholderName, load.getProperty("cardholderName"));

        //Enter the card details
        enter_Element(creditCardNo, load.getProperty("creditCardNo"));

        //Select the card Expiry Month
        select_Element_ByVisibleText(crditCardExpMonth,("02"));

        //Select the card Expiry year
        select_Element_ByIndex(creditCardExpYear, (2));

        //Enter the Card Code
        enter_Element(creditCardCode, load.getProperty("creditCardCode"));

        //Click on Continue
        click_Element(paymentInfoContinue);

//...........................6. Confirm Order...................................
   //     explicit_Wait (By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]"),30);
      //  WebDriverWait wait3 = new WebDriverWait(driver, 30);
       // wait3.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@class=\"button-1 confirm-order-next-step-button\"]")));

        //Click Confirm
        click_Element(confirmationOrder);

//................Thank you... Your Order has been Successfully Processed...............
    //   explicit_Wait(By.xpath("//div[@class=\"section order-completed\"]/div/strong"),30);

      //  WebDriverWait wait4 = new WebDriverWait(driver, 30);
       // wait4.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class=\"section order-completed\"]/div/strong")));

        String actual_Value = getTextonly(actualValue); //Get the path for the actual message
        String expected_Value="Your order has been successfully processed!";

        //Comparing Expected value with actual value
        Assert.assertEquals(expected_Value, actual_Value);

        //click on continue
        click_Element(orderProcCompleted);

        //logout the webpage
        click_Element(logOut);

    }
}
