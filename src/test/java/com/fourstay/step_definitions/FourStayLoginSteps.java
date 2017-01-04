package com.fourstay.step_definitions;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.utilities.Base;
import com.fourstay.utilities.Browser;
import com.fourstay.utilities.TestInputs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class FourStayLoginSteps extends Base{
	
	HomePage homePage = new HomePage();
	SearchResultsPage searchResultsPage = new SearchResultsPage();

	@Given("^I am on the fourstay homepage$")
	public void i_am_on_the_fourstay_homepage() throws Throwable {
		driver.get(TestInputs.BASE_URL);
		// Check if logo is displayed
		try {
			assertTrue("Home page is not loaded",homePage.fourStayLogo.isDisplayed());
		} catch (Exception e) {
			fail("Home page is not loaded");
		}
	}

	@And("^I click Login link$")
	public void i_click_Login_link() throws Throwable {
		homePage.loginLink.click();
	}

	@When("^I enter \"([^\"]*)\" credentials$")
	public void i_enter_credentials(String role) throws Throwable {
		String userID = "";
		String pwd = "";
				
		if (role.equalsIgnoreCase("guest")) {
			userID = TestInputs.GUEST_USER_ID;
			pwd = TestInputs.GUEST_USER_PWD;
		} else if (role.equalsIgnoreCase("host")){
			userID = TestInputs.HOST_USER_ID;
			pwd = TestInputs.HOST_USER_PWD;
		} else {
			fail("User role is not valid: "+role);
		}
		
		homePage.inputEmail.sendKeys(userID);
		homePage.inputPassword.sendKeys(pwd);
		homePage.loginButton.click();
	}

//	@Then("^I should see see Listing Reserved by message$")
//	public void i_should_see_see_Listing_Reserved_by_message() throws Throwable {
//		String expectedText = "Listing Reserved by "+
//				TestInputs.GUEST_USER_FIRSTNAME+" "+
//		TestInputs.GUEST_USER_LASTNAME;
//		System.out.println(expectedText);
//		Browser.verifyText(driver, expectedText);
//	}
	
	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String text) throws Throwable {
////		String expectedText = text+
//				TestInputs.GUEST_USER_FIRSTNAME+" "+
//		TestInputs.GUEST_USER_LASTNAME;
		String expectedText = text;
		System.out.println(expectedText);
		Browser.verifyPartialText(expectedText);
	}

}
