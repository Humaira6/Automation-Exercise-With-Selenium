package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class webdriverSetup {
public static String browserName=System.getProperty("browserName","Chrome");
    public static final ThreadLocal<WebDriver> LOCAL_BROWSER= new ThreadLocal<>();

    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
    }

    public static void setBrowser(WebDriver browser) {
        webdriverSetup.LOCAL_BROWSER.set(browser);
    }

    public WebDriver getBrowser(String browserName){
        if(browserName.equalsIgnoreCase("Chrome"))
            return new ChromeDriver();
        else if(browserName.equalsIgnoreCase("Firefox"))
            return new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("Edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Browser is not available with the given Name "+browserName);
        }



    }

    @BeforeMethod

    public void openBrowser() {
        WebDriver browser = getBrowser(browserName);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        browser.manage().window().maximize();
        setBrowser(browser);

    }




  @AfterMethod
    public void quitBrowser() {
        getBrowser().quit();
    }
}
