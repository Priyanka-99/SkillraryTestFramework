package com_Skillrary_pomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class TwitterPage {
	
	public WebDriver driver;

		
	public TwitterPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}

}
