package pageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class HomePage extends Utils {
    SoftAssert softAssert=new SoftAssert();

    /*Locators*/

    By addtoCartListElements =By.xpath("//div/div/div[2]/div[3]/div[2]/input[1]");
    By currencyDropdown=By.xpath("//select[@id=\"customerCurrency\"]/option[2]");
    By curren=By.xpath("//div/div[4]/div[2]/div[@class='item-box']/div/div[2]/div[3]/div[1]/span[1]");

    public void verifyAddtoCartButton()
    {

        List<WebElement> addtoCartList=driver.findElements(addtoCartListElements);

        for(WebElement element :addtoCartList) {

            Assert.assertEquals("Add to cart", element.getAttribute("value"),"Add to cart");
            System.out.println(element.getAttribute("value"));
        }

    }
    public void currencyConvertor()
    {
       // driver.findElement(By.xpath("//select[@id=\"customerCurrency\"]/option[2]")).click();
        click_Element(currencyDropdown);
        List<WebElement> currency=driver.findElements(curren);
        for (WebElement element: currency)
        {

          // System.out.println( currency.size());

            //System.out.println(element.getText().charAt(0));

            softAssert.assertEquals(element.getText().charAt(0),'Ђ');

            softAssert.assertAll();
          //  Assert.assertEquals("Ђ",str);

        }

    }
}
