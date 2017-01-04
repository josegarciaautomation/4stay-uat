package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.fourstay.pages.HomePage;
import com.fourstay.utilities.Base;
import com.fourstay.utilities.UserModel;

import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomePageStepDefs extends Base{
	HomePage homePage = new HomePage();
	
	@When("^I click on the beds dropdown list$")
	public void i_click_on_the_beds_dropdown_list() throws Throwable {
	    // click on the beds button
		homePage.bedOptions.click();
	}

	@Then("^I should see the following bed options$")
	public void i_should_see_the_following_bed_options(List<String> options) throws Throwable {
		// Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
	    String css = ".list-option-select";
	    List<WebElement> elList = driver.findElements(By.cssSelector(css));
	    ArrayList<String> actualOption = new ArrayList<String>();
	    for (WebElement element : elList) {
			actualOption.add(element.getText());
		}
	    // Assert if there is a mismatch
	    for (int i = 0; i < actualOption.size(); i++) {
			assertEquals(options.get(i), actualOption.get(i));
		}
	    
	}
	
	@When("^I enter user information:$")
	public void i_enter_user_information(List<UserModel> users) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    // For automatic transformation, change DataTable to one of
	    // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
	    // E,K,V must be a scalar (String, Integer, Date, enum etc)
		for (UserModel user : users) {
			System.out.println("First name :"+user.getFirstName());
			System.out.println("Last name :"+user.getLastName());
			System.out.println("email; :"+user.getEmail());
			System.out.println("password :"+user.getPassword());
		}
	}

	// List<YourType>, 
	// List<List<E>>, 
	// List<Map<K,V>>
	// Map<K,V>.
	// E,K,V must be a scalar (String, Integer, Date, enum etc)
}
