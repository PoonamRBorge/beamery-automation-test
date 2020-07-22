package main.java.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import main.java.core.BasePage;

public class RegistrationFormPage extends BasePage{

	private By title_mr = By.id("id_gender1");
	private By title_mrs = By.id("id_gender2");
	private By textBox_firstName = By.id("customer_firstname");
	private By textBox_lastName = By.id("customer_lastname");
	private By textBox_password = By.id("passwd");
	private By select_day = By.id("days");
	private By select_month = By.id("months");
	private By select_year = By.id("years");
	private By checkbox_newsLetter = By.id("newsletter");
	private By checkbox_offer = By.id("optin");
	private By textBox_company = By.id("company");
	private By textBox_addr1 = By.id("address1");
	private By textBox_addr2 = By.id("address2");
	private By textBox_city = By.id("city");
	private By select_state = By.id("id_state");
	private By textBox_zip = By.id("postcode");
	private By select_country = By.id("id_country");
	private By textArea_additionalInfo = By.id("other");
	private By textBox_homePhone = By.id("phone");
	private By textBox_mobile = By.id("phone_mobile");
	private By textBox_addrAlias = By.id("alias");
	private By button_register = By.id("submitAccount");
	
	public RegistrationFormPage(WebDriver driver) {
		super(driver);
	}

	@Override
	protected By getUniqueElement() {
		return By.className("account_creation");
	}
	
	public void addName(String title, String firstName, String lastName){
		if(title.equalsIgnoreCase("Mr"))
			driver.findElement(title_mr).sendKeys(title);
		else
			driver.findElement(title_mrs).sendKeys(title);
		driver.findElement(textBox_firstName).sendKeys(firstName);
		driver.findElement(textBox_lastName).sendKeys(lastName);
	}
	
	public void addPassword(String password){
		driver.findElement(textBox_password).sendKeys(password);
	}
	
	public void createAccountWithMandatoryInfo(String title, String firstName, String lastName, String password, String addr1, String city, String state, String zip, String country, String mobile, String alias) throws Exception{
		if(title.equalsIgnoreCase("Mr"))
			driver.findElement(title_mr).sendKeys(title);
		else
			driver.findElement(title_mrs).sendKeys(title);
		driver.findElement(textBox_firstName).sendKeys(firstName);
		driver.findElement(textBox_lastName).sendKeys(lastName);
		driver.findElement(textBox_password).sendKeys(password);
		driver.findElement(textBox_addr1).sendKeys(addr1);
		driver.findElement(textBox_city).sendKeys(city);
		dropDownSelectValueByVisibleText(select_state, state);
		driver.findElement(textBox_zip).sendKeys(zip);
		dropDownSelectValueByVisibleText(select_country, country);
		driver.findElement(textBox_mobile).sendKeys(mobile);
		driver.findElement(textBox_addrAlias).clear();
		driver.findElement(textBox_addrAlias).sendKeys(alias);
	}

	public void createAccountWithAllInfo(String title, String firstName, String lastName, String password, String day, String month, String year, String newsLetter, String offers, String company, String addr1, String addr2, String city, String state, String zip, String country, String additionalInfo, String homePhone, String mobile, String alias) throws Exception{
		if(title.equalsIgnoreCase("Mr"))
			driver.findElement(title_mr).sendKeys(title);
		else
			driver.findElement(title_mrs).sendKeys(title);
		driver.findElement(textBox_firstName).sendKeys(firstName);
		driver.findElement(textBox_lastName).sendKeys(lastName);
		driver.findElement(textBox_password).sendKeys(password);
		dropDownSelectValueByVisibleText(select_day, day);
		dropDownSelectValueByVisibleText(select_month , month);
		dropDownSelectValueByVisibleText(select_year, year);
		if(newsLetter.equalsIgnoreCase("yes")){
			driver.findElement(checkbox_newsLetter).click();
		}
		if(offers.equalsIgnoreCase("yes")){
			driver.findElement(checkbox_offer).click();
		}
		driver.findElement(textBox_company).sendKeys(company);
		driver.findElement(textBox_addr1).sendKeys(addr1);
		driver.findElement(textBox_addr2).sendKeys(addr2);
		driver.findElement(textBox_city).sendKeys(city);
		dropDownSelectValueByVisibleText(select_state, state);
		driver.findElement(textBox_zip).sendKeys(zip);
		dropDownSelectValueByVisibleText(select_country, country);
		driver.findElement(textArea_additionalInfo).sendKeys(additionalInfo);
		driver.findElement(textBox_homePhone).sendKeys(homePhone);
		driver.findElement(textBox_mobile).sendKeys(mobile);
		driver.findElement(textBox_addrAlias).clear();
		driver.findElement(textBox_addrAlias).sendKeys(alias);
	}
	
	public void clickRegister(){
		driver.findElement(button_register).click();
	}
	
	public boolean registrationFailed(){
		boolean error = false;
		try{
			driver.findElement(By.xpath("//p[contains(text(), 'error')]"));
			error = true;
		}catch(NoSuchElementException e){
			error = false;
		}
		return error;
	}
	
	public boolean registrationSuccessful(){
		boolean elementPresent = false;
		if(elementVisible(By.xpath("//a[contains(text(), 'Sign out')]"))){
			elementPresent = true;
		}
		return elementPresent;
	}
}
