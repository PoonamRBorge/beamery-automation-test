package test.java.stepDefinitions;

import org.testng.Assert;

import main.java.core.BaseTest;
import main.java.pages.HomePage;
import main.java.pages.RegistrationFormPage;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class RegistrationStepDef extends BaseTest{

	private HomePage homePage;
	private RegistrationFormPage registrationPage;
	
	@Given("I am on the home page")
	public void i_on_home_page(){
		setup();
		homePage = new HomePage(super.getDriver());
	}
	@When("I click on the sign in")
	public void i_click_signIn(){
		homePage.clickSignIn();
	}
	
	@And("I create an account using an email address:(.*)")
	public void i_create_account(String email){
		homePage.createAccount(email);
	}
	
	@Then("The user is (.*)")
	public void user_created(String status){
		if(status.equalsIgnoreCase("created")){
			Assert.assertTrue(homePage.isTextVisible("Create an account"));
		}
		else{
			Assert.assertTrue(homePage.isAccountCreateError());
		}
		
	}
	
	@Given("I am on the registration form page")
	public void i_on_registration_page(){
		registrationPage = new RegistrationFormPage(super.getDriver());
	}
	
	@When("I fill up the mandatory details title:(.*), firstName:(.*), lastName:(.*), password:(.*), address:(.*), city:(.*), state:(.*), zip:(.*), country:(.*), mobile:(.*), aliasAddr:(.*)")
	public void fil_up_mandatory_details(String title, String firstName, String lastName, String password, String addr1, String city, String state, String zip, String country, String mobile, String alias) throws Exception{
		registrationPage.createAccountWithMandatoryInfo(title, firstName, lastName, password, addr1, city, state, zip, country, mobile, alias);
	}
	
	@And("I click on Register")
	public void i_click_on_register(){
		registrationPage.clickRegister();
	}
	
	@Then("The registration is (.*)")
	public void registration(String status){
		if(status.equalsIgnoreCase("successful")){
			Assert.assertTrue(registrationPage.registrationSuccessful());
		}
		else{
			Assert.assertTrue(registrationPage.registrationFailed());
		}
		
	}
	
	@After public void cleanUp(){ 
		afterSuite();
	   } 
	
	
	
}
