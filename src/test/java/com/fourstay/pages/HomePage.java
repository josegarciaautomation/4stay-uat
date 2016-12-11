package com.fourstay.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Base;

public class HomePage extends Base{
	
	public HomePage() {
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//img[@alt='HStay Logo']")
	public WebElement fourStayLogo;
	
	@FindBy(xpath="//li[@data-target='#modal-login']")
	public WebElement loginLink;
	
	@FindBy(id="btn-login")
	public WebElement loginButton;
	
	@FindBy(id="email")
	public WebElement inputEmail;
	
	@FindBy(name="Password")
	public WebElement inputPassword;
	
	@FindBy(id="iLocName")
	public WebElement inputSchool;
	
	@FindBy(id="rentoutfrom")
	public WebElement inputDateFrom;
	
	@FindBy(id="rentoutto")
	public WebElement inputDateTo;
	
	@FindBy(id="inputGroupSuccess1")
	public WebElement inputBeds;
	
	@FindBy(id="search")
	public WebElement searchButton;
	
	@FindBy(xpath="//div[@id='map']")
	public WebElement map;
	
	@FindBy(xpath = "//*[contains(text(),'Something went wrong')]")
	public WebElement wentWrongError;
	
	public void enterCredentials(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
	}
	
	public void login(String email, String password) {
		inputEmail.sendKeys(email);
		inputPassword.sendKeys(password);
		loginButton.click();
	}
	
	public boolean loginButtonEnabled() {
		return loginButton.isEnabled();
	}
	
	
	// Equivalent to:
	// WebElement fourStayLogo = driver.findElement(By.xpath("//img[@alt='HStay Logo']"))
}
