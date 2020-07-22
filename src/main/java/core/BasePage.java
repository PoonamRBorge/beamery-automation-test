package main.java.core;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
private static final int TIMEOUT = 5;
    
	protected WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        isLoaded();
        wait = new WebDriverWait(driver, TIMEOUT, 100);
     }
    protected abstract By getUniqueElement();
    protected void isLoaded() {
		this.wait = new WebDriverWait(driver, TIMEOUT, 100);
	}
    protected void waitForElementToAppear(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
   
    public boolean isTextVisible(String text){
    	boolean visible = false;
    	try {
			if (driver.findElement(By.xpath("//*[contains(text(),'" + text + "')]")).isDisplayed()) {
				visible = true;
			}
		} catch (NoSuchElementException e) {
			visible = false;
		}
		return visible;
    }
    
    public void dropDownSelectValueByVisibleText(By by, String valueToBeSelected) throws Exception {
		WebElement identifier = driver.findElement(by);
		Select select = new Select(identifier);
		select.selectByVisibleText(valueToBeSelected);
	}
    
    public boolean elementVisible(By by) {
		boolean m_belementFound = false;
		try {
			m_belementFound = driver.findElement(by).isDisplayed();
		} catch (ElementNotVisibleException e) {
			m_belementFound = false;
		}
		return m_belementFound;
	}
    
}
