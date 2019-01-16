package pageObjectModel;

import org.openqa.selenium.By;

public class RegistrationPage extends Utils {
    LoadProp load=new LoadProp();

/*--------------Locator-------------------*/
    By register=By.linkText("Register");
    By femaleRadioButton=By.id("gender-female");
    By firstName=By.id("FirstName");
    By lastName=By.id("LastName");
    By dateDOB=By.name("DateOfBirthDay");
    By monthDOB=By.name("DateOfBirthMonth");
    By yearDOB=By.name("DateOfBirthYear");
    By emailAddress=By.id("Email");
    By company=By.id("Company");
    By newsletter=By.name("Newsletter");
    By password=By.name("Password");
    By confirmPassword=By.name("ConfirmPassword");
    By registerbutton= By.id("register-button");
    By logOut=By.linkText("Log out");
    By actualValue=By.xpath("//div[@class='result']");

 /*------------------------------------------*/

    public void userRegisteration() {

        String expectedValue="Your registration completed";

       // current date and Time in HHMMSS format
        simpleDateFormat();

        // click Register button
        click_Element(register);
        //click 'Female' radio button
        click_Element(femaleRadioButton);

        //Enter First Name
        enter_Element(firstName, load.getProperty ("firstName"));

        //Enter Last Name
        enter_Element(lastName,load.getProperty ("lastName"));

        //Select the Date in Date of Birth
        select_Element_ByIndex(dateDOB,30);

        //Select the Month in Date of Birth
        select_Element_ByValue(monthDOB, 12);

        //Select the Year in Date of Birth
        select_Element_ByVisibleText(yearDOB,"1996");

        //Enter the Email Address
        enter_Element(emailAddress,("sripriyasethuraman+date1@gmail.com"));

        //Enter the Company
        enter_Element(company, (load.getProperty("company")));

        //Select the Newsletter Checkbox

     //   WebElement newsletter_Chkbox= driver.findElement(By.name("Newsletter"));
      //  newsletter_Chkbox.isSelected( );
        ckhbox_Method(newsletter);

        //Enter Password
        enter_Element(password, load.getProperty("password"));

        //Enter Confirm Password
        enter_Element(confirmPassword,load.getProperty("confirmPasswword"));

        //Click on Register
        click_Element(registerbutton);



     //   String actual_Value =driver.findElement(By.xpath("//div[@class='result']")).getText(); //Get the Path for Actual Message
      //  Assert.assertEquals("Your registration completed",actual_Value); //Compare Expected messgae with Actaul message
        assertEquals(actualValue,expectedValue);


        //logout the webpage
        click_Element(logOut);

    }
}
