package pageObjectModel;

import org.openqa.selenium.By;

public class LoginPage extends Utils {

    LoadProp load=new LoadProp();

   /*-------------Locators----------------------------------------------------*/

    By login=By.xpath("//a[@href=\"/login\"]");
    By email=By.id("Email");
    By password=By.id("Password");
    By loginbutton= By.xpath("//div/input[@class=\"button-1 login-button\"]");

    /*--------------------------------------------------------------------------*/

    public void user_Login()
    {
        //Click on Login
        click_Element(login);

        //Enter your email
        enter_Element(email,load.getProperty("yourEmailAddress"));

        //Enter Password
        enter_Element(password, load.getProperty("password"));

        //Click on Login
        click_Element(loginbutton);
    }
}
