package pageObjectModel;

import org.openqa.selenium.By;



public class BooksPage extends Utils {

    //-----------------Locators--------------------------//

    By books = By.linkText("Books");
    By firstPrizePies= By.partialLinkText("First");
    By emailAFriend =By.xpath("//div/div[3]/input[@type=\"button\"]");
    By friendEmail=By.id("FriendEmail");
    By sendEmail=By.xpath("//div/input[@type=\"submit\"]");
    By actualValue=By.xpath("//div[@class=\"result\"]");
    By logout=By.linkText("Log out");
    By highToLow=By.id("products-orderby");
    By firstProduct=By.xpath("//div[1]/div/div[2]/div[3]/div/span[2]");
    By lastProduct=By.xpath("//div/div[3]/div/div[2]/div[3]/div/span[2]");

    //----------------------------------------------------------------------


    LoginPage log=new LoginPage();
    LoadProp load=new LoadProp();

    public void sendEmail() {


        String expectedValue="Your message has been sent.";
        //Click on login
        log.user_Login();
        //Click on books
        click_Element(books);
        //click on First Prize Pies
        click_Element(firstPrizePies);

        //click on Email a Friend
        click_Element(emailAFriend);

        //Enter friends email
        enter_Element(friendEmail,load.getProperty("friendEmail") );

        //click on Send email
        click_Element(sendEmail);

       assertEquals(actualValue,expectedValue);  //Comparing Expected message with Actual message

        //logout the webpage
        click_Element(logout);

    }

    public void sortByPriceHightoLow() {

        //click on books
        click_Element(books);

        //Select Price: High to Low
        select_Element_ByVisibleText(highToLow,"Price: High to Low");
     //  String first_Product = firstProduct; //Get the Path for first product price and remove $ from it (51.00)
        String first_Product= getText(firstProduct);
        String last_Product=getText(lastProduct);
     //  String last_Product = driver.findElement(By.xpath("//div/div[3]/div/div[2]/div[3]/div/span[2]")).getText().substring(1); //Get the Path for last product price and remove $ from it (24.00)
       //Converting first_Value string into float
        float first_Value = Float.parseFloat(first_Product);

        //Converting last_Value string into float
        float last_Value = Float.parseFloat(last_Product);

        //checking first_Value>last_Value or not

        assertTrue((first_Value > last_Value), "Test case Failed");

    }
}
