package com.fourstay.tests;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fourstay.pages.HomePage;
import com.fourstay.pages.SearchResultsPage;
import com.fourstay.utilities.TestInputs;

public class DemoTest {
	@Ignore
	@Test
	public void TestTitle () {
		System.setProperty("webdriver.chrome.driver", "//Users//pepe//Documents/Libraries/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("http://google.com");
		assertEquals("Google",driver.getTitle());
	}
	
	@Test
	public void TestMessageFourStay () {
		System.setProperty("webdriver.chrome.driver", "/Users/pepe/Documents/Libraries/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		driver.get(TestInputs.BASE_URL);
		HomePage homePage = new HomePage();
		SearchResultsPage searchResultsPage = new SearchResultsPage();
		homePage.searchButton.click();	
		String text = "Please fill out this field.";
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement el = driver.findElement(By.xpath("//*[contains(text(),'Please')]"));
		wait.until(ExpectedConditions.visibilityOf(el));
		if (el.isDisplayed()) {
			System.out.println("Found!");
		}
	}
}



 
