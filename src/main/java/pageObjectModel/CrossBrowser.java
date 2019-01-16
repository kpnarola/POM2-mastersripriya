package pageObjectModel;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CrossBrowser extends Utils {
    LoadProp loadProp = new LoadProp();

    public void crossBrowserCalling() {
        {
            String browser = loadProp.getProperty("browser");

            //String browser =System.getProperty("browser");

            if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\Resources\\BrowserDriver\\geckodriver.exe");
                System.setProperty(FirefoxDriver.SystemProperty.DRIVER_USE_MARIONETTE, "true");
                System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "/dev/null");
                driver = new FirefoxDriver();
                driver.get(loadProp.getProperty("url"));
                driver.manage().window().maximize();



            } else if (browser.equalsIgnoreCase("chrome")) {
               System.setProperty("webdriver.chrome.driver", "src\\test\\Resources\\BrowserDriver\\chromedriver.exe");

                ChromeOptions options = new ChromeOptions();
                options.addArguments("disable-infobars");
                options.addArguments("--disable-extensions");
                options.addArguments("--disable-browser-side-navigation");
                options.addArguments("--incognito");
                options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
                driver = new ChromeDriver(options);
                driver.get(loadProp.getProperty("url"));
                driver.manage().window().maximize();


            } else if (browser.equalsIgnoreCase("edge")) {
                System.setProperty("webdriver.edge.driver", "src\\browserdriver\\MicrosoftWebDriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().maximize();


            } else if (browser.equalsIgnoreCase("ie")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\Resources\\BrowserDriver\\IEDriverServer.exe");
               InternetExplorerOptions options = new InternetExplorerOptions();
                options.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                options.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver(options);

             //   driver=new InternetExplorerDriver();
                driver.get(loadProp.getProperty("url"));
                driver.manage().window().maximize();


            } else {
                System.out.println("Type Correct Browser Name" + browser);
            }

        }

    } }

