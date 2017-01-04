package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Base;

public class UserAccountPage extends Base{
	
	public UserAccountPage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(className = "user-name")
	public WebElement accountHolderName;
}
