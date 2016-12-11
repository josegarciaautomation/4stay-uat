package com.fourstay.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.gargoylesoftware.htmlunit.httpclient.HtmlUnitBrowserCompatCookieHeaderValueFormatter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hook {
	private static WebDriver driver;
	
	public static final String CHROME_DRIVER = "webdriver.chrome.driver";
	public static final String CHROME_DRIVER_PATH = 
			"./src/test/resources/browsers/chromedriver";
	public static final String FIREFOX_DRIVER = "webdriver.gecko.driver";
	public static final String FIREFOX_DRIVER_PATH = 
			"./src/test/resources/browsers/geckodriver";
	
	@Before
	public void setUp() throws Exception {
		String browser = System.getProperty("browser");
		if (browser==null) {
			browser = "chrome";
		}
		System.out.println(browser);
		if (driver==null || ((RemoteWebDriver)driver).getSessionId()==null) {
			switch (browser) {
			case "chrome":
				System.setProperty(CHROME_DRIVER, CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty(FIREFOX_DRIVER, FIREFOX_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;
			}
			
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		}
		Base.driver=driver;
	}
	
	public static WebDriver getDriver() { // Getter for convenience
		return driver;
	}
	
	@After
	public void tearDown(Scenario scenario) throws Exception {
		// take a screenshot if scenario fails
//		Browser.takeScreenshot("/Users/pepe/Desktop/Docs/Cybertek/Cucumber/Screenshots/test2.png");
		if (scenario.isFailed()) {
			final byte[] screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		}
		if (driver != null) {
			driver.quit();
		}
	}	
}
