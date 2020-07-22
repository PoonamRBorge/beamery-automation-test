package main.java.pages;

import main.java.core.BasePage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{

	private By link_signIn = By.xpath("//a[contains(text(), 'Sign in')]");
	private By textbox_email = By.id("email_create");
	private By button_createAccount = By.id("SubmitCreate");
	public HomePage(WebDriver driver) {
		super(driver);
	}
	
	@Override
	protected By getUniqueElement() {
		return By.id("header_logo") ;
	}
	public void clickSignIn(){
		driver.findElement(link_signIn).click();
	}

	public void createAccount(String email){
		driver.findElement(textbox_email).sendKeys(email);
		driver.findElement(button_createAccount).click();
	}

	public boolean isAccountCreateError(){
		boolean error = false;
		try{
			driver.findElement(By.id("create_account_error"));
			error = true;
		}catch(NoSuchElementException e){
			error = false;
		}
		return error;
		
	}
	
	
}
