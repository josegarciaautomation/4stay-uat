package com.fourstay.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.fourstay.utilities.Base;

public class SearchResultsPage extends Base{
	
	public SearchResultsPage () {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="hLocName")
	public WebElement locationField;
}
