package com.fourstay.utilities;

import org.openqa.selenium.By;

public class Utils extends Base{
	
	static public boolean isDisplayed  (By by) {
		boolean isDisplayed;
		try {
			isDisplayed = driver.findElement(by).isDisplayed();
			return (isDisplayed == true);
		
		} catch (Exception e) {
			System.out.println("Element not displayed: " + by);
			return false;
		}
	}
}
