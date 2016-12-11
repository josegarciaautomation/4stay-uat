package com.fourstay.utilities;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Browser extends Base{
	 public static void verifyText (String text) {	
		if (text.isEmpty()) {
			fail("Empty text was passed to VerifyText method");
		}
		String xpath = "//*[.='"+text+"']";
		try {
			assertTrue("Text not displayed",driver.findElement(By.xpath(xpath)).isDisplayed());	
		} catch (Exception e) {
			fail("Text not displayed");
		}
	}
	  
	 public static void verifyPartialText (String text) {	
		if (text.isEmpty()) {
			fail("Empty text was passed to VerifyText method");
		}
		String xpath = "//*[contains(text(),'"+text+"')]";

		try {
			waitFor(By.xpath(xpath));
			assertTrue("Partial Text not displayed: "+text+"->Element not found",
					driver.findElement(By.xpath(xpath)).isDisplayed());	
		} catch (Exception e) {
			fail("Partial Text not displayed: "+text+"->Element not found");
		}
	 }
	 
	 public static void waitFor(By by) {
			WebDriverWait wait = new WebDriverWait(driver,10);
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	 }
	 
	 public static void takeScreenshot (String fileName) {	
		// Take screenshot and store as a file format
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
		// now copy the  screenshot to desired location using copyFile //method
		FileUtils.copyFile(src, new File(fileName));
		System.out.println("Screenshot saved!");
		} catch (IOException e) {
		System.out.println(e.getMessage());
		}
	 }
}
