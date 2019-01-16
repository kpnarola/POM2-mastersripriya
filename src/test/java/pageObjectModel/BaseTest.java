package pageObjectModel;

import org.codehaus.plexus.util.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import java.io.File;
import java.util.concurrent.TimeUnit;

public class BaseTest extends BasePage {
CrossBrowser cross =new CrossBrowser();
    @BeforeTest
    protected void open_Browser() {

      cross.crossBrowserCalling();

      //set path for chrome driver
     /*   System.setProperty("webdriver.chrome.driver", "src\\browserdriver\\chromedriver.exe");
        driver = new ChromeDriver(); */
        //Set implicit wait to 30 seconds
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);//
        driver.manage().window().fullscreen();

        //open the nopcommerce Webpage
      //  driver.get("http://demo.nopcommerce.com/");




    }

@AfterMethod
public void tear_down(ITestResult result)

{
  //using ITestResult.FAILURE is equals to result.getStatus then it enter into if condition
    if(ITestResult.FAILURE==result.getStatus()){
        try{
            // To create reference of TakesScreenshot
            TakesScreenshot screenshot=(TakesScreenshot)driver;
            // Call method to capture screenshot
            File src=screenshot.getScreenshotAs(OutputType.FILE);
            // Copy files to specific location
            // result.getName() will return name of test case so that screenshot name will be same as test case name
            FileUtils.copyFile(src, new File("src\\test\\Screenshot"+" "+result.getName()+".jpeg"));
            System.out.println("Successfully captured a screenshot");
        }catch (Exception e){
            System.out.println("Exception while taking screenshot "+e.getMessage());
        }
    }

}


    @AfterTest
    protected void close_Browser()
    {
    driver.quit();

    }

}