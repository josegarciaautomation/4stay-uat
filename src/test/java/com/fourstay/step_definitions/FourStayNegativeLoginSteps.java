package com.fourstay.step_definitions;

import static org.junit.Assert.assertFalse;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.utilities.Base;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FourStayNegativeLoginSteps extends Base{
	
	HomePage homePage = new HomePage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@When("^I enter email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_enter_email_and_password(String userID, String pwd) throws Throwable {
		homePage.enterCredentials(userID, pwd);
	}

	@Then("^login button should disabled$")
	public void login_button_should_disabled() throws Throwable {
		assertFalse("Login Button is enabled",homePage.loginButtonEnabled());
	}

	@When("^I login with email \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void i_login_with_email_and_password(String userID, String pwd) throws Throwable {
		homePage.login(userID, pwd);
	}
	
	
}
