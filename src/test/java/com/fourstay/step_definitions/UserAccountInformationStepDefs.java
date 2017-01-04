package com.fourstay.step_definitions;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.UserAccountPage;
import com.fourstay.utilities.Base;
import com.fourstay.utilities.Browser;
import com.fourstay.utilities.DBUtility;
import com.fourstay.utilities.FileUtils;

import cucumber.api.java.en.Then;

public class UserAccountInformationStepDefs extends Base{
	@Then("^information for \"([^\"]*)\" should match the database records$")
	public void information_for_should_match_the_database_records(String email) throws Throwable {
		UserAccountPage userPage = new UserAccountPage();
//		Browser.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(userPage.accountHolderName));
		String actualName = userPage.accountHolderName.getText();
		
		// verify first name and last name
//		String sqlQuery = "select first_name,last_name from 4stay_test.users where email='"+email+"'";
		String sqlQuery = String.format("select first_name,last_name from 4stay_test.users where email='%s'", email);
		List<Map<String, String>> dbMap = DBUtility.getDbMap(sqlQuery);
		// get the first map
		Map<String, String> map = dbMap.get(0);
		// get first name
		String fName = map.get("first_name");
		// get last name
		String lName = map.get("last_name");
		// build expected name string
		System.out.println(fName+" "+lName+":"+actualName);
		assertEquals(fName+" "+lName, actualName);
		// Write code here that turns the phrase above into concrete actions

	}
	
	@Then("^information for \"([^\"]*)\" should match the provided records$")
	public void information_for_should_match_the_provided_records(String email) throws Throwable {
		UserAccountPage userPage = new UserAccountPage();
//		Browser.sleep(3000);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(userPage.accountHolderName));
		String actualName = userPage.accountHolderName.getText();
		
		// we need to read data from excel
		String[][] data = FileUtils.getExcelData("./src/test/resources/test_data/users.xlsx", "users");
		
		for (String[] row : data) {
			String eEmail = row[2];
			if (eEmail.equals(email)) {
				String fName = row[0];
				String lName = row[1];
				assertEquals(fName+" "+lName, actualName);
			}
		}
	}
}
