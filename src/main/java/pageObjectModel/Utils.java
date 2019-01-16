package pageObjectModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils extends BasePage {


    protected static String  date1;

    public static void click_Element(By by)

    {
        driver.findElement(by).click();
    }

    public static void enter_Element(By by, String text)
    {
        driver.findElement(by).sendKeys(text);

    }
    public  static void select_Element_ByVisibleText( By by, String str)
    {
        Select byText=new Select(driver.findElement(by));
        byText.selectByVisibleText(str);

    }
    public  static void select_Element_ByIndex( By by, int data)
    {
        Select byData=new Select(driver.findElement(by));
        byData.selectByIndex(data);

    }
    public  static void select_Element_ByValue( By by, int value)
    {
        Select byValue=new Select(driver.findElement(by));
        byValue.selectByIndex(value);

    }
public static String simpleDateFormat()
{
    //Current month day and year minutes and seconds
    DateFormat dt=new SimpleDateFormat( "MMddYYYHHMMSS");
    Date date=new Date();//Current month day and year minutes and seconds
    return date1=dt.format(date);
}

public static  boolean ckhbox_Method(By by )
{
    return driver.findElement(by).isSelected();

}
public static String getText(By by)
{
    return (driver.findElement(by).getText().substring(1));

}
    public  static String getTextonly(By by)
    {

        return (driver.findElement(by).getText());
    }


public static void assertEquals(By by, String expectedValue)
{
    String actual_Value =driver.findElement(by).getText();
    Assert.assertEquals(expectedValue,actual_Value); //Compare Expected messgae with Actaul message

}

public static void assertTrue(boolean bool, String str)
{

        Assert.assertTrue(bool, str);

}
    public void explicit_Wait(By by, int timeout)
    {

     WebDriverWait wait= new WebDriverWait(driver,timeout);
     wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }

}
