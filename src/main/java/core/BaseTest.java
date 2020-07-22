package main.java.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {
	private static WebDriver driver;

    
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("http://automationpractice.com/index.php");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
    }

    
    public void afterSuite() {
        if(null != driver) {
            driver.close();
            driver.quit();
        }
    }
    
    public WebDriver getDriver() {
        return BaseTest.driver;
    }
}
